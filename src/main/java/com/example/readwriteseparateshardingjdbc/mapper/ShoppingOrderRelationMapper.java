package com.example.readwriteseparateshardingjdbc.mapper;

import com.example.readwriteseparateshardingjdbc.entity.ShoppingOrderRelationInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface ShoppingOrderRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShoppingOrderRelationInfo record);

    int insertSelective(ShoppingOrderRelationInfo record);

    ShoppingOrderRelationInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShoppingOrderRelationInfo record);

    int updateByPrimaryKey(ShoppingOrderRelationInfo record);
}