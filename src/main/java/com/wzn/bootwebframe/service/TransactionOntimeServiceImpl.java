/**
 * TransactionOntimeServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.wzn.bootwebframe.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TransactionOntimeServiceImpl extends Remote {
	public String applyGoodsReturnSsl(String userName,
                                      String password, String record)
			throws RemoteException;

	public String queryGoodsReturnSsl(String userName,
                                      String password, String qryType,
                                      String seq) throws RemoteException;
}
