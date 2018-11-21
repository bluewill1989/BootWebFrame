package com.wzn.bootwebframe.service.netty;

import lombok.Data;
import net.sf.json.JSONObject;

/**
 * Created by Administrator on 2018/1/2 0002.
 */
@Data
public class ClientMessage {

//    private String randomStr;
//    private String version; // 版本号
//    private String functionCode; // 功能代码
//    private JSONObject requestData;
//    private String response;

    private String version;

    private String functionCode;

    private JSONObject requestData;

    private String response;


}
