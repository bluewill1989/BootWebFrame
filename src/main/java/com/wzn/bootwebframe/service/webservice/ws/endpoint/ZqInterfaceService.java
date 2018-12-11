/**
 * ZqInterfaceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.wzn.bootwebframe.service.webservice.ws.endpoint;

import java.rmi.Remote;

public interface ZqInterfaceService extends javax.xml.rpc.Service {
    public java.lang.String getZqInterfaceServiceImplPortAddress();

    public ZqInterServiceImpl getZqInterfaceServiceImplPort() throws javax.xml.rpc.ServiceException;

    public ZqInterServiceImpl getZqInterfaceServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
