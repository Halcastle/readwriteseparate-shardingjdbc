package com.example.readwriteseparateshardingjdbc.mapper;

import com.example.readwriteseparateshardingjdbc.entity.ShoppingCustomerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
//@Component
public interface ShoppingCustomerInfoMapper {

	List<ShoppingCustomerInfo> findAll();

	ShoppingCustomerInfo findBySerialno(Long id);

	ShoppingCustomerInfo findByCertId(String certId);

	Long insertCustomer(ShoppingCustomerInfo customerInfo);

	Long updateCustomerByCustomerInfo(ShoppingCustomerInfo customerInfo);
}
