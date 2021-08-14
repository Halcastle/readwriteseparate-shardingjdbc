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
	public ShoppingCustomerInfo findBySerialno(Long id) {
		return customerInfoMapper.findBySerialno(id);
	}

	@Override
	public ShoppingCustomerInfo findByCertId(String certId) {
		return customerInfoMapper.findByCertId(certId);
	}

	@Override
	public Long insertCustomer(ShoppingCustomerInfo customerInfo) {
		return customerInfoMapper.insertCustomer(customerInfo);
	}

	@Override
	public Long updateCustomerByCustomerInfo(ShoppingCustomerInfo customerInfo) {
		return customerInfoMapper.updateCustomerByCustomerInfo(customerInfo);
	}

}
