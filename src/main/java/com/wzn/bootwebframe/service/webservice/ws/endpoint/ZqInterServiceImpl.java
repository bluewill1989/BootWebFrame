package com.wzn.bootwebframe.service.webservice.ws.endpoint;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ZqInterServiceImpl extends Remote {
    public String zqInterface(String user, java.lang.String in_head_json, java.lang.String in_body_json) throws RemoteException;;
}
