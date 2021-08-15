package com.example.readwriteseparateshardingjdbc.service;


import com.example.readwriteseparateshardingjdbc.entity.ShoppingCustomerInfo;

import java.util.List;

public interface IShoppingCustomerInfoService {

	List<ShoppingCustomerInfo> findAll();
	
	ShoppingCustomerInfo findBySerialno(Long id);

	ShoppingCustomerInfo findByCertId(String certId);

	Long insertCustomer(ShoppingCustomerInfo customerInfo);

	Long updateCustomerByCustomerInfo(ShoppingCustomerInfo customerInfo);

	void insertCustomersBatch(List<ShoppingCustomerInfo> customerInfos);

	void insertCustomerBatch(ShoppingCustomerInfo customerInfo);
}
