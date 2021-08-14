package com.example.readwriteseparateshardingjdbc.service;

import com.example.readwriteseparateshardingjdbc.entity.ShoppingCustomerInfo;
import com.example.readwriteseparateshardingjdbc.entity.ShoppingOrderInfo;
import com.example.readwriteseparateshardingjdbc.service.impl.ShoppingOrderServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName GenerateOrderService
 * @Description TODO
 * @Author Dream
 * @Date 2021-08-14 22:04
 * @Version 1.0
 **/
@Service
public class OrderService {

    @Autowired
    ShoppingOrderServiceimpl orderServiceimpl;

    public Long generateOrder(ShoppingOrderInfo orderInfo){

        return orderServiceimpl.insert(orderInfo);
    }
}
