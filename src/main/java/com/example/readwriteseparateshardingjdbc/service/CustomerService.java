package com.example.readwriteseparateshardingjdbc.service;

import com.example.readwriteseparateshardingjdbc.entity.ShoppingCustomerInfo;
import com.example.readwriteseparateshardingjdbc.entity.ShoppingOrderInfo;
import com.example.readwriteseparateshardingjdbc.service.impl.ShoppingCustomerInfoServiceimpl;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName GenerateOrderService
 * @Description TODO
 * @Author Dream
 * @Date 2021-08-14 22:04
 * @Version 1.0
 **/
@Service
public class CustomerService {

    @Autowired
    ShoppingCustomerInfoServiceimpl customerInfoServiceimpl;

    public Long generateCustomer(ShoppingCustomerInfo customerInfo){
        return customerInfoServiceimpl.insertCustomer(customerInfo);
    }

    public ShoppingCustomerInfo findCustomerByCertId(String certId){
        return customerInfoServiceimpl.findByCertId(certId);
    }

    public Long updateCustomerByCustomerInfo(ShoppingCustomerInfo customerInfo){
        return customerInfoServiceimpl.updateCustomerByCustomerInfo(customerInfo);
    }

}
