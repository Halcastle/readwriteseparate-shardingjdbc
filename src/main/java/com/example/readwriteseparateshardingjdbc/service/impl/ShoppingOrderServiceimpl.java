package com.example.readwriteseparateshardingjdbc.service.impl;

import com.example.readwriteseparateshardingjdbc.entity.ShoppingOrderInfo;
import com.example.readwriteseparateshardingjdbc.mapper.ShoppingOrderInfoMapper;
import com.example.readwriteseparateshardingjdbc.service.IShoppingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingOrderServiceimpl implements IShoppingOrderService {

	@Autowired
	private ShoppingOrderInfoMapper shoppingOrderInfoMapper;


	@Override
	public int deleteByPrimaryKey(Long id) {
		return 0;
	}

	@Override
	public Long insert(ShoppingOrderInfo record) {
		return shoppingOrderInfoMapper.insert(record);
	}

	@Override
	public int insertSelective(ShoppingOrderInfo record) {
		return 0;
	}

	@Override
	public ShoppingOrderInfo selectByPrimaryKey(String serialno) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ShoppingOrderInfo record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ShoppingOrderInfo record) {
		return 0;
	}
}
