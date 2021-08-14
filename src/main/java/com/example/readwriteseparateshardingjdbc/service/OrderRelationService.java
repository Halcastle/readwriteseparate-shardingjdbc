package com.example.readwriteseparateshardingjdbc.service;

import com.example.readwriteseparateshardingjdbc.entity.ShoppingOrderRelationInfo;
import com.example.readwriteseparateshardingjdbc.service.impl.ShoppingOrderRelationServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName GenerateOrderRelationService
 * @Description TODO
 * @Author Dream
 * @Date 2021-08-14 22:07
 * @Version 1.0
 **/
@Service
public class OrderRelationService {
    @Autowired
    ShoppingOrderRelationServiceimpl orderRelationServiceimpl;

    public void generateOrderRelationService(ShoppingOrderRelationInfo orderRelationInfo){
        orderRelationServiceimpl.insert(orderRelationInfo);
    }
}
