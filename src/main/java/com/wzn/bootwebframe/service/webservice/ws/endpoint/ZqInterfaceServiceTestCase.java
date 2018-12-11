///**
// * ZqInterfaceServiceTestCase.java
// *
// * This file was auto-generated from WSDL
// * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
// */
//
//package com.wzn.bootwebframe.service.webservice.ws.endpoint;
//
//public class ZqInterfaceServiceTestCase extends junit.framework.TestCase {
//    public ZqInterfaceServiceTestCase(java.lang.String name) {
//        super(name);
//    }
//
//    public void testZqInterfaceServiceImplPortWSDL() throws Exception {
//        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
//        java.net.URL url = new java.net.URL(new ws.endpoint.ZqInterfaceServiceLocator().getZqInterfaceServiceImplPortAddress() + "?WSDL");
//        javax.xml.rpc.Service service = serviceFactory.createService(url, new ws.endpoint.ZqInterfaceServiceLocator().getServiceName());
//        assertTrue(service != null);
//    }
//
//    public void test1ZqInterfaceServiceImplPortZqInterface() throws Exception {
//        ws.endpoint.ZqInterfaceServiceSoapBindingStub binding;
//        try {
//            binding = (ws.endpoint.ZqInterfaceServiceSoapBindingStub)
//                          new ws.endpoint.ZqInterfaceServiceLocator().getZqInterfaceServiceImplPort();
//        }
//        catch (javax.xml.rpc.ServiceException jre) {
//            if(jre.getLinkedCause()!=null)
//                jre.getLinkedCause().printStackTrace();
//            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
//        }
//        assertNotNull("binding is null", binding);
//
//        // Time out after a minute
//        binding.setTimeout(60000);
//
//        // Test operation
//        java.lang.String value = null;
//        value = binding.zqInterface(new java.lang.String(), new java.lang.String(), new java.lang.String());
//        // TBD - validate results
//    }
//
//    public void test2ZqInterfaceServiceImplPortSybxjntsbtSyjfjl() throws Exception {
//        ws.endpoint.ZqInterfaceServiceSoapBindingStub binding;
//        try {
//            binding = (ws.endpoint.ZqInterfaceServiceSoapBindingStub)
//                          new ws.endpoint.ZqInterfaceServiceLocator().getZqInterfaceServiceImplPort();
//        }
//        catch (javax.xml.rpc.ServiceException jre) {
//            if(jre.getLinkedCause()!=null)
//                jre.getLinkedCause().printStackTrace();
//            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
//        }
//        assertNotNull("binding is null", binding);
//
//        // Time out after a minute
//        binding.setTimeout(60000);
//
//        // Test operation
//        java.lang.String value = null;
//        value = binding.sybxjntsbtSyjfjl(new java.lang.String());
//        // TBD - validate results
//    }
//
//}
