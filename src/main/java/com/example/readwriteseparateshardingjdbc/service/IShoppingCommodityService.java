package com.example.readwriteseparateshardingjdbc.service;


import com.example.readwriteseparateshardingjdbc.entity.ShoppingCommodityInfo;

import java.util.List;

public interface IShoppingCommodityService {

	int deleteByPrimaryKey(Long id);

	int insert(ShoppingCommodityInfo record);

	int insertSelective(ShoppingCommodityInfo record);

	ShoppingCommodityInfo selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(ShoppingCommodityInfo record);

	int updateByPrimaryKey(ShoppingCommodityInfo record);
}
