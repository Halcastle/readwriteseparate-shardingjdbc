package com.example.readwriteseparateshardingjdbc.mapper;

import com.example.readwriteseparateshardingjdbc.entity.ShoppingCommodityInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface ShoppingCommodityInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShoppingCommodityInfo record);

    int insertSelective(ShoppingCommodityInfo record);

    ShoppingCommodityInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShoppingCommodityInfo record);

    int updateByPrimaryKey(ShoppingCommodityInfo record);
}