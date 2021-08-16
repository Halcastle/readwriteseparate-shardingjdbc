package com.example.readwriteseparateshardingjdbc.mapper;

import com.example.readwriteseparateshardingjdbc.entity.ShoppingCustomerInfo;
import com.example.readwriteseparateshardingjdbc.entity.ShoppingOrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface ShoppingOrderInfoMapper {
    int deleteByPrimaryKey(Long id);

    Long insert(ShoppingOrderInfo record);

    int insertSelective(ShoppingOrderInfo record);

    ShoppingOrderInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShoppingOrderInfo record);

    int updateByPrimaryKey(ShoppingOrderInfo record);

    void insertOrdersBatch(List<ShoppingOrderInfo> orderInfos);
}