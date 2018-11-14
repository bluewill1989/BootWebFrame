/**
 * TransactionOntimeServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.wzn.bootwebframe.service;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.Service;
import org.apache.axis.client.Stub;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.net.URL;
import java.rmi.Remote;
import java.util.HashSet;
import java.util.Iterator;

public class TransactionOntimeServiceImplServiceLocator extends
		Service implements
		TransactionOntimeServiceImplService {

	public TransactionOntimeServiceImplServiceLocator() {
	}

	public TransactionOntimeServiceImplServiceLocator(
			EngineConfiguration config) {
		super(config);
	}

	public TransactionOntimeServiceImplServiceLocator(String wsdlLoc,
			QName sName)
			throws ServiceException {
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for TransactionOntimeService
	// private String TransactionOntimeService_address =
	// "https://172.16.3.29:9141/uis-web-test/services/TransactionOntimeService";
	private String TransactionOntimeService_address = "https://210.22.91.77:20443/uis-web/services/TransactionOntimeService?wsdl";

	// private String TransactionOntimeService_address =
	// "https://www.chinaums.com:8441/uis-web/services/TransactionOntimeService";

	public String getTransactionOntimeServiceAddress() {
		return TransactionOntimeService_address;
	}

	// The WSDD service name defaults to the port name.
	private String TransactionOntimeServiceWSDDServiceName = "TransactionOntimeService";

	public String getTransactionOntimeServiceWSDDServiceName() {
		return TransactionOntimeServiceWSDDServiceName;
	}

	public void setTransactionOntimeServiceWSDDServiceName(String name) {
		TransactionOntimeServiceWSDDServiceName = name;
	}

	public TransactionOntimeServiceImpl getTransactionOntimeService()
			throws ServiceException {
		URL endpoint;
		try {
			endpoint = new URL(TransactionOntimeService_address);
		} catch (java.net.MalformedURLException e) {
			throw new ServiceException(e);
		}
		return getTransactionOntimeService(endpoint);
	}

	public TransactionOntimeServiceImpl getTransactionOntimeService(
			URL portAddress) throws ServiceException {
		try {
			TransactionOntimeServiceSoapBindingStub _stub = new TransactionOntimeServiceSoapBindingStub(
					portAddress, this);
			_stub.setPortName(getTransactionOntimeServiceWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setTransactionOntimeServiceEndpointAddress(
			String address) {
		TransactionOntimeService_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public Remote getPort(Class serviceEndpointInterface)
			throws ServiceException {
		try {
			if (TransactionOntimeServiceImpl.class
					.isAssignableFrom(serviceEndpointInterface)) {
				TransactionOntimeServiceSoapBindingStub _stub = new TransactionOntimeServiceSoapBindingStub(
						new URL(TransactionOntimeService_address),
						this);
				_stub.setPortName(getTransactionOntimeServiceWSDDServiceName());
				return _stub;
			}
		} catch (Throwable t) {
			throw new ServiceException(t);
		}
		throw new ServiceException(
				"There is no stub implementation for the interface:  "
						+ (serviceEndpointInterface == null ? "null"
								: serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public Remote getPort(QName portName,
						  Class serviceEndpointInterface)
			throws ServiceException {
		if (portName == null) {
			return getPort(serviceEndpointInterface);
		}
		String inputPortName = portName.getLocalPart();
		if ("TransactionOntimeService".equals(inputPortName)) {
			return getTransactionOntimeService();
		} else {
			Remote _stub = getPort(serviceEndpointInterface);
			((Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public QName getServiceName() {
		return new QName(
				"http://com.ums.uis.transactionOntimeService",
				"TransactionOntimeServiceImplService");
	}

	private HashSet ports = null;

	public Iterator getPorts() {
		if (ports == null) {
			ports = new HashSet();
			ports.add(new QName(
					"http://com.ums.uis.transactionOntimeService",
					"TransactionOntimeService"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(String portName,
			String address) throws ServiceException {

		if ("TransactionOntimeService".equals(portName)) {
			setTransactionOntimeServiceEndpointAddress(address);
		} else { // Unknown Port Name
			throw new ServiceException(
					" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(QName portName,
			String address) throws ServiceException {
		setEndpointAddress(portName.getLocalPart(), address);
	}

}
