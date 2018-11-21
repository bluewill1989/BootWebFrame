package com.wzn.bootwebframe.service.netty.handler;

/**
 * Created by Administrator on 2018/3/5 0005.
 */
public class NettyServiceConstant {

    public static final String BMP_PUBLIC_PAY = "/bmpPublicPay";

    public static final String METHOD_ERROR = "支持POST请求";
    public static final String URI_ERROR = "该URI无效！";
    public static final String CONNECTION_KEEP_ALIVE = "keep-alive";
    public static final String CONNECTION_CLOSE = "close";
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_BROWSER_FORM = "application/x-www-form-urlencoded";
    public static final String BIZ_HANDLER_ERROR ="便民业务处理错误" ;
    public static final String VERSION_FUNCTION_ERROR = "请确定version或functionCode正确";
    public static final String CONTENT_TYPE_ERROR = "该contentType暂不支持！";

    public static final String NO_SIGN_PARAM_ERROR = "请求没有签名字段";

    public static final String SIGN_CHECK_FAILED = "签名字段";


    public static final String CP_GET_ORDER = "/cpgetorder";

    public static final String CP_TEST_ORDER = "/cptestorder"; //专门配合CP测试的地址

    public static final String ULINK_WRITE_OFF = "/ulinkwriteoff";
    public static final String UCS_WRITE_OFF = "/ucswriteoff";

}

