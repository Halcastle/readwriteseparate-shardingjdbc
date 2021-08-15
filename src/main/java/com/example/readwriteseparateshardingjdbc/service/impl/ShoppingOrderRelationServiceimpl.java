package com.example.readwriteseparateshardingjdbc.service.impl;

import com.example.readwriteseparateshardingjdbc.entity.ShoppingOrderRelationInfo;
import com.example.readwriteseparateshardingjdbc.mapper.ShoppingOrderRelationMapper;
import com.example.readwriteseparateshardingjdbc.service.IShoppingOrderRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingOrderRelationServiceimpl implements IShoppingOrderRelationService {

	@Autowired
	private ShoppingOrderRelationMapper shoppingOrderRelationMapper;


	@Override
	public int deleteByPrimaryKey(Long id) {
		return 0;
	}

	@Override
	public int insert(ShoppingOrderRelationInfo record) {
		return shoppingOrderRelationMapper.insert(record);
	}

	@Override
	public int insertSelective(ShoppingOrderRelationInfo record) {
		return 0;
	}

	@Override
	public ShoppingOrderRelationInfo selectByPrimaryKey(String serialno) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ShoppingOrderRelationInfo record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ShoppingOrderRelationInfo record) {
		return 0;
	}
}
