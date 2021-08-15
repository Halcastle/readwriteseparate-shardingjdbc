package com.example.readwriteseparateshardingjdbc.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.readwriteseparateshardingjdbc.entity.ShoppingCustomerInfo;
import com.example.readwriteseparateshardingjdbc.service.BuyCommodityService;
import com.example.readwriteseparateshardingjdbc.service.MockBuyService;
import com.example.readwriteseparateshardingjdbc.service.OrderRelationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @ClassName BuyCommotityController
 * @Description TODO
 * @Author Dream
 * @Date 2021-08-14 22:49
 * @Version 1.0
 **/
@RestController()
@Log4j2
public class BuyCommotityController {
    @Autowired
    BuyCommodityService buyCommodityService;

    @Autowired
    MockBuyService mockBuyService;

    @RequestMapping(value = "/write/{number}", method = RequestMethod.GET)
    public String writeNumber(@PathVariable(name = "number") int number) {
        Random random = new Random();
        Random commotityRandom = new Random();
        JSONObject resultJson = new JSONObject();
        int tmp = 0;
        for (int i = 0; i < number; i++) {
            buyCommotity(number, random, commotityRandom, resultJson);
        }
        return "完成：" + tmp + "请求。";
    }

    @RequestMapping(value = "/executor/{number}", method = RequestMethod.GET)
    public String writeExecutor(@PathVariable(name = "number") int number) {
        Random random = new Random();
        Random commotityRandom = new Random();
        JSONObject resultJson = new JSONObject();
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        for (int i = 0; i < number; i++) {
            final int no = i;
            executorService.execute(() -> {
                log.info("线程{}start", Thread.currentThread().getName());
                buyCommotity(number, random, commotityRandom, resultJson);
                log.info("线程{}end", Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
        log.info("线程{}end", Thread.currentThread().getName());


        return "完成请求。";
    }

    @RequestMapping(value = "/mock/{number}")
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
                customerInfo.setId(null);
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
            customerInfo.setId(null);
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

    private void buyCommotity(@PathVariable(name = "number") int number, Random random, Random commotityRandom, JSONObject resultJson) {
        int rInt = random.nextInt(number);
        int rCommotityId = commotityRandom.nextInt(6);
        ShoppingCustomerInfo customerInfo = new ShoppingCustomerInfo();
        customerInfo.setId(null);
        customerInfo.setName("客户" + (rInt + 1));
        customerInfo.setGender("1");
        customerInfo.setCertid(rInt + "");
        customerInfo.setPhone("17809266135");
        customerInfo.setAddress("address" + (rInt + 1));
        customerInfo.setPhotourl("./" + (rInt + 1));
        customerInfo.setStatus("1");
        resultJson.put("customerInfo", customerInfo);
        JSONArray commotitys = new JSONArray();
        for (int j = 0; j <= rCommotityId; j++) {
            JSONObject commotityListJson = new JSONObject();
            commotityListJson.put("commotityId", Long.valueOf(commotityRandom.nextInt(6) + 1));
            commotityListJson.put("commotityNumber", Long.valueOf(commotityRandom.nextInt(10) + 1));

            commotitys.add(commotityListJson);
        }
        resultJson.put("commotityList", commotitys);
        log.info("begin--购买请求开始处理：{}" + resultJson);
        buyCommodityService.buyCommodity(resultJson);
        log.info("end--购买请求处理完成：{}" + resultJson);
    }
}
