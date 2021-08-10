package com.example.readwriteseparateshardingjdbc.mapper;

import com.example.readwriteseparateshardingjdbc.entity.ShoppingCustomerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShoppingCustomerInfoMapper {

	List<ShoppingCustomerInfo> findAll();
	
	ShoppingCustomerInfo findBySerialno(String id);

	int insertCustomer(ShoppingCustomerInfo customerInfo);

	int updateCustomerBySerialno(ShoppingCustomerInfo customerInfo);
}
