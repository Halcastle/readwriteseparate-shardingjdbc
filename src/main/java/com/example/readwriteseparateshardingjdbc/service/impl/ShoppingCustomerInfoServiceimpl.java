package com.example.readwriteseparateshardingjdbc.service.impl;

import com.example.readwriteseparateshardingjdbc.entity.ShoppingCustomerInfo;
import com.example.readwriteseparateshardingjdbc.mapper.ShoppingCustomerInfoMapper;
import com.example.readwriteseparateshardingjdbc.service.IShoppingCustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCustomerInfoServiceimpl implements IShoppingCustomerInfoService {

	@Autowired
	private ShoppingCustomerInfoMapper customerInfoMapper;
	
	@Override
	public List<ShoppingCustomerInfo> findAll() {
		return customerInfoMapper.findAll();
	}

	@Override
	public ShoppingCustomerInfo findBySerialno(String id) {
		return customerInfoMapper.findBySerialno(id);
	}

	@Override
	public int insertCustomer(ShoppingCustomerInfo customerInfo) {
		return customerInfoMapper.insertCustomer(customerInfo);
	}

	@Override
	public int updateCustomerBySerialno(ShoppingCustomerInfo customerInfo) {
		return customerInfoMapper.updateCustomerBySerialno(customerInfo);
	}

}
