package com.example.readwriteseparateshardingjdbc.service;


import com.example.readwriteseparateshardingjdbc.entity.ShoppingCommodityInfo;
import com.example.readwriteseparateshardingjdbc.entity.ShoppingOrderInfo;

import java.util.List;

public interface IShoppingOrderService {

	int deleteByPrimaryKey(Long id);

	Long insert(ShoppingOrderInfo record);

	int insertSelective(ShoppingOrderInfo record);

	ShoppingOrderInfo selectByPrimaryKey(String serialno);

	int updateByPrimaryKeySelective(ShoppingOrderInfo record);

	int updateByPrimaryKey(ShoppingOrderInfo record);

	void insertOrdersBatch(List<ShoppingOrderInfo> orderInfos);
}
