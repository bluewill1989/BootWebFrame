/**
 * ZqInterfaceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.wzn.bootwebframe.service.webservice.ws.endpoint;

public class ZqInterfaceServiceLocator extends org.apache.axis.client.Service implements ZqInterfaceService {

    public ZqInterfaceServiceLocator() {
    }


    public ZqInterfaceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ZqInterfaceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ZqInterfaceServiceImplPort
    private java.lang.String ZqInterfaceServiceImplPort_address = "http://172.16.1.33:7001/zqInterfaceTest/service/mainService";

    public java.lang.String getZqInterfaceServiceImplPortAddress() {
        return ZqInterfaceServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ZqInterfaceServiceImplPortWSDDServiceName = "ZqInterfaceServiceImplPort";

    public java.lang.String getZqInterfaceServiceImplPortWSDDServiceName() {
        return ZqInterfaceServiceImplPortWSDDServiceName;
    }

    public void setZqInterfaceServiceImplPortWSDDServiceName(java.lang.String name) {
        ZqInterfaceServiceImplPortWSDDServiceName = name;
    }

    public ZqInterServiceImpl getZqInterfaceServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ZqInterfaceServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getZqInterfaceServiceImplPort(endpoint);
    }

    public ZqInterServiceImpl getZqInterfaceServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ZqInterfaceServiceSoapBindingStub _stub = new ZqInterfaceServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getZqInterfaceServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setZqInterfaceServiceImplPortEndpointAddress(java.lang.String address) {
        ZqInterfaceServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ZqInterfaceService.class.isAssignableFrom(serviceEndpointInterface)) {
                ZqInterfaceServiceSoapBindingStub _stub = new ZqInterfaceServiceSoapBindingStub(new java.net.URL(ZqInterfaceServiceImplPort_address), this);
                _stub.setPortName(getZqInterfaceServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ZqInterfaceServiceImplPort".equals(inputPortName)) {
            return getZqInterfaceServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://endpoint.ws/", "zqInterfaceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://endpoint.ws/", "ZqInterfaceServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ZqInterfaceServiceImplPort".equals(portName)) {
            setZqInterfaceServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
