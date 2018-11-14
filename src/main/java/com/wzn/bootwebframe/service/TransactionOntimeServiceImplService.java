/**
 * TransactionOntimeServiceImplService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.wzn.bootwebframe.service;

import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public interface TransactionOntimeServiceImplService extends
		Service {
	public String getTransactionOntimeServiceAddress();

	public TransactionOntimeServiceImpl getTransactionOntimeService()
			throws ServiceException;

	public TransactionOntimeServiceImpl getTransactionOntimeService(
            java.net.URL portAddress) throws ServiceException;
}
