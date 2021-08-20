package com.example.readwriteseparateshardingjdbc.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.readwriteseparateshardingjdbc.entity.ShoppingCustomerInfo;
import com.example.readwriteseparateshardingjdbc.entity.ShoppingOrderInfo;
import com.example.readwriteseparateshardingjdbc.entity.ShoppingOrderRelationInfo;
import com.example.readwriteseparateshardingjdbc.service.BuyCommodityService;
import com.example.readwriteseparateshardingjdbc.service.MockBuyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName BuyCommotityController
 * @Description TODO
 * @Author Dream
 * @Date 2021-08-14 22:49
 * @Version 1.0
 **/
@RestController()
@Log4j2
public class XABuyCommotityController {
    @Autowired
    MockBuyService mockBuyService;

    @RequestMapping(value = "/mockCustomerXA/{number}")
    public void mockBatchInsterController(@PathVariable(name = "number") int number) {
        //插入客户表
        int size = 1000;
        long start = System.currentTimeMillis();
        log.info("开始时间：{}", start);
        List<ShoppingCustomerInfo> customerInfos = new ArrayList<>();
        int tmp = number;
        int _tmp = 0;
        while (tmp > size) {
            for (int i = 0; i < size; i++) {
                ShoppingCustomerInfo customerInfo = new ShoppingCustomerInfo();
//                customerInfo.setId(null);
                customerInfo.setName("客户mock");
                customerInfo.setGender("1");
                customerInfo.setCertid("610424199609126592");
                customerInfo.setPhone("17809266135");
                customerInfo.setAddress("addressmock");
                customerInfo.setPhotourl("./mock");
                customerInfo.setStatus("1");
                customerInfos.add(customerInfo);
                _tmp++;
            }
            mockBuyService.mockBatchInsterCustomers(customerInfos);
            customerInfos.clear();
            tmp = tmp - size;
        }
        customerInfos.clear();
        for (int i = 0; i < tmp; i++) {
            ShoppingCustomerInfo customerInfo = new ShoppingCustomerInfo();
//            customerInfo.setId(null);
            customerInfo.setName("客户mock");
            customerInfo.setGender("1");
            customerInfo.setCertid("610424199609126592");
            customerInfo.setPhone("17809266135");
            customerInfo.setAddress("addressmock");
            customerInfo.setPhotourl("./mock");
            customerInfo.setStatus("1");
            customerInfos.add(customerInfo);
            _tmp++;
        }
        if(customerInfos.size()>0){
            mockBuyService.mockBatchInsterCustomers(customerInfos);
        }

        long end = System.currentTimeMillis();
        log.info("结束时间：{}", end);
        log.info("耗时：{}", end - start);
        log.info("共提交：{}条", _tmp);
        //插入订单表
        //插入订单关联表
    }

}
