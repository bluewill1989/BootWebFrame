package com.wzn.bootwebframe.service.netty.handler;

/**
 * Created by Administrator on 2017/11/30.
 */

import com.alibaba.fastjson.JSONObject;
import com.wzn.bootwebframe.common.util.BusinessException;
import com.wzn.bootwebframe.service.netty.ClientMessage;
import com.wzn.bootwebframe.service.netty.biz.BizRouter;
import com.wzn.bootwebframe.service.netty.biz.ICommonBs;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;

import static io.netty.handler.codec.http.HttpHeaderNames.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_LENGTH;

@Slf4j
public class NettyHttpServerHandler extends ChannelInboundHandlerAdapter {

    @Autowired
    private BizRouter bizRouter;
    private ICommonBs bizBs;
    private HttpHeaders headers;
    private FullHttpResponse response;
    private FullHttpRequest fullRequest;
    private HttpPostRequestDecoder decoder;
    private static final HttpDataFactory factory = new DefaultHttpDataFactory(DefaultHttpDataFactory.MAXSIZE);


    public NettyHttpServerHandler(BizRouter bizRouter) {
        this.bizRouter = bizRouter;
    }

    public void channelRegistered(ChannelHandlerContext ctx)  {
        log.info("{}主机接连成功", ctx.channel().remoteAddress());
    }

    public void channelUnregistered(ChannelHandlerContext ctx)  {
        log.info("{}主机退出连接", ctx.channel().remoteAddress());
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)  {
        if (msg instanceof FullHttpRequest) {
            try {
                fullRequest = (FullHttpRequest) msg;
                headers = fullRequest.headers();
                String uri = fullRequest.uri();
                HttpMethod method = fullRequest.method();
                if (!method.equals(HttpMethod.POST)) {
                    log.error("只支持POST请求方法：");
                    throw new BusinessException("B200", NettyServiceConstant.METHOD_ERROR);
                }
                handlerPublicPayUri(ctx);
//                if (uri.equals(NettyServiceConstant.BMP_PUBLIC_PAY)) {
//                    handlerPublicPayUri(ctx);
//                } else {
//                    log.error("该URI无效");
//                    throw new BusinessException("B201", NettyServiceConstant.URI_ERROR);
//                }
            } catch (BusinessException e) {
                log.error(e.getErrInfo());
                JSONObject msgObj = new JSONObject();
                msgObj.put(e.getErrCode(), e.getErrInfo());
                writeResponse(ctx.channel(), HttpResponseStatus.NON_AUTHORITATIVE_INFORMATION, msgObj.toJSONString(), true);

            }
            catch (UnsupportedEncodingException e) {
                JSONObject msgObj = new JSONObject();
                msgObj.put("B299", NettyServiceConstant.BIZ_HANDLER_ERROR);
                writeResponse(ctx.channel(), HttpResponseStatus.NON_AUTHORITATIVE_INFORMATION, msgObj.toJSONString(), true);

            }
            finally {
                ReferenceCountUtil.release(msg);
            }
        } else {
            //discard request...
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws BusinessException {
        log.info("channelReadComplete");
        ctx.flush();
    }

    private void handlerPublicPayUri(ChannelHandlerContext ctx) throws UnsupportedEncodingException, BusinessException {
        ClientMessage clientMessage ;
        int len = fullRequest.content().readableBytes();
        byte[] content = new byte[len];
        fullRequest.content().readBytes(content);
        String jsonString = new String(content, "GBK").replaceAll("\r|\n", "");
        clientMessage = JSONObject.parseObject(jsonString, ClientMessage.class);
        dealWithContentType(clientMessage);
        //返回response
        log.info("响应数据：{}", clientMessage.getResponse());
        writeResponse(ctx.channel(), HttpResponseStatus.OK, clientMessage.getResponse(), false);
    }

    /**
     * 简单处理常用几种 Content-Type 的 POST 内容（可自行扩展）
     *
     * @throws Exception
     */
    private void dealWithContentType(ClientMessage clientMessage) throws BusinessException {
        String contentType = getContentType();
        if (NettyServiceConstant.CONTENT_TYPE_JSON.equals(contentType)) {
            //路由到具体得处理去取处理；
            bizBs = bizRouter.route(clientMessage.getVersion(), clientMessage.getFunctionCode());
            if (bizBs == null) {
                throw new BusinessException(NettyServiceConstant.VERSION_FUNCTION_ERROR);  //返回错误类型
            }
            bizBs.handle(clientMessage);
        } else {
            throw new BusinessException(NettyServiceConstant.CONTENT_TYPE_ERROR);
        }
    }

    private void writeResponse(Channel channel, HttpResponseStatus status, String msg, boolean forceClose) {
        ByteBuf byteBuf = Unpooled.wrappedBuffer(msg.getBytes());
        response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, status, byteBuf);
        boolean close = isClose();
        if (!close && !forceClose) {
            response.headers().add(CONTENT_LENGTH, String.valueOf(byteBuf.readableBytes()));
        }
        ChannelFuture future = channel.writeAndFlush(response);
        if (close || forceClose) {
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }

    private String getContentType() {
        String typeStr = headers.get("Content-Type").toString();
        String[] list = typeStr.split(";");
        return list[0];
    }

    private boolean isClose() {
        if (fullRequest.headers().contains(CONNECTION, NettyServiceConstant.CONNECTION_CLOSE, true) ||
                (fullRequest.protocolVersion().equals(HttpVersion.HTTP_1_0) &&
                        !fullRequest.headers().contains(CONNECTION, NettyServiceConstant.CONNECTION_KEEP_ALIVE, true)))
            return true;
        return false;
    }

}