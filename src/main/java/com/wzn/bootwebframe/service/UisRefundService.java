package com.wzn.bootwebframe.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

/**
 * DESCRIPTION:
 *
 * @author will
 * @create 2018-11-08 10:18
 */
@Component
@Slf4j
public class UisRefundService {

    private  TransactionOntimeServiceImplServiceLocator locator;

//    private TransactionOntimeServiceImpl client;

    private final String UIS_REFUND_URL = "https://58.247.0.18:20443/uis-web/services/TransactionOntimeService?wsdl";

    private final String SSL_USER_NAME = "029bf87578ec46b7b3e2d5f7e3ab4f250001";
    private final String SSL_USER_PW = "Test123456";

    @PostConstruct
    private void init(){
        System.setProperty("javax.net.ssl.trustStore", "E://trust.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "ws654321");
        System.setProperty("javax.net.ssl.keyStore", "E://wskey.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "ws654321");
        locator = new TransactionOntimeServiceImplServiceLocator();
        locator.setTransactionOntimeServiceEndpointAddress(UIS_REFUND_URL);
    }

    public String doGoodsReturnSsl(String record){
        String result = null;
        TransactionOntimeServiceImpl client = null;
        try {
            client = locator.getTransactionOntimeService();
            result = client.applyGoodsReturnSsl(SSL_USER_NAME, SSL_USER_PW, record);
        } catch (Exception e) {
            log.error("e错误信息是={}",e);
        }

        log.info("result={}",result);
        return result;
    }


}