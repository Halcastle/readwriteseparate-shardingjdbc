package com.example.readwriteseparateshardingjdbc.service;


import com.example.readwriteseparateshardingjdbc.entity.ShoppingCustomerInfo;

import java.util.List;

public interface IShoppingCustomerInfoService {

	List<ShoppingCustomerInfo> findAll();
	
	ShoppingCustomerInfo findBySerialno(String id);

	int insertCustomer(ShoppingCustomerInfo customerInfo);

	int updateCustomerBySerialno(ShoppingCustomerInfo customerInfo);
}
