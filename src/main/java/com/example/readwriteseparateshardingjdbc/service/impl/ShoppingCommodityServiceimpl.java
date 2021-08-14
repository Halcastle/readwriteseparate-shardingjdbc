package com.example.readwriteseparateshardingjdbc.service.impl;

import com.example.readwriteseparateshardingjdbc.entity.ShoppingCommodityInfo;
import com.example.readwriteseparateshardingjdbc.mapper.ShoppingCommodityInfoMapper;
import com.example.readwriteseparateshardingjdbc.service.IShoppingCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCommodityServiceimpl implements IShoppingCommodityService {

	@Autowired
	private ShoppingCommodityInfoMapper shoppingCommodityInfoMapper;


	@Override
	public int deleteByPrimaryKey(Long id) {
		return shoppingCommodityInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ShoppingCommodityInfo record) {
		return 0;
	}

	@Override
	public int insertSelective(ShoppingCommodityInfo record) {
		return 0;
	}

	@Override
	public ShoppingCommodityInfo selectByPrimaryKey(Long id) {
		return shoppingCommodityInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(ShoppingCommodityInfo record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ShoppingCommodityInfo record) {
		return 0;
	}
}
