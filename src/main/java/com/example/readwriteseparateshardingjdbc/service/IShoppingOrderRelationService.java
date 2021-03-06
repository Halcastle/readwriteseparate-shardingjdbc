package com.example.readwriteseparateshardingjdbc.service;


import com.example.readwriteseparateshardingjdbc.entity.ShoppingOrderRelationInfo;

import java.util.List;

public interface IShoppingOrderRelationService {

	int deleteByPrimaryKey(Long id);

	int insert(ShoppingOrderRelationInfo record);

	int insertSelective(ShoppingOrderRelationInfo record);

	ShoppingOrderRelationInfo selectByPrimaryKey(String serialno);

	int updateByPrimaryKeySelective(ShoppingOrderRelationInfo record);

	int updateByPrimaryKey(ShoppingOrderRelationInfo record);

	void insertOrderRelationsBatch(List<ShoppingOrderRelationInfo> orderInfos);
}
