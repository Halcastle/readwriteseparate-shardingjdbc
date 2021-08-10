package com.example.readwriteseparateshardingjdbc.service;


import com.example.readwriteseparateshardingjdbc.entity.ShoppingCustomerInfo;
import com.example.readwriteseparateshardingjdbc.service.impl.ShoppingCustomerInfoServiceimpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class ReadWriteService {
    private final static Logger logger = LoggerFactory.getLogger(ReadWriteService.class);
    @Autowired
    ShoppingCustomerInfoServiceimpl shoppingCustomerInfoService;

    public ReadWriteService() throws SQLException {
    }

    public ShoppingCustomerInfo masterRead(String id){
        logger.info("使用maser数据源读取id为：{}数据",id);
        ShoppingCustomerInfo shoppingCustomerInfo = shoppingCustomerInfoService.findBySerialno(id);
        logger.info("----maser对象读取为{}----",shoppingCustomerInfo.toString());
        return shoppingCustomerInfo;
    }

    public ShoppingCustomerInfo slave1Read(String id){
        logger.info("使用slave1数据源读取id为：{}数据",id);
        ShoppingCustomerInfo shoppingCustomerInfo = shoppingCustomerInfoService.findBySerialno(id);
        logger.info("----slave1对象读取为{}----",shoppingCustomerInfo.toString());
        return shoppingCustomerInfo;
    }

    public ShoppingCustomerInfo slave2Read(String id){
        logger.info("使用slave2数据源读取id为：{}数据",id);
        ShoppingCustomerInfo shoppingCustomerInfo = shoppingCustomerInfoService.findBySerialno(id);
        logger.info("----slave2对象读取为{}----",shoppingCustomerInfo.toString());
        return shoppingCustomerInfo;
    }

    public ShoppingCustomerInfo slave3Read(String id){
        logger.info("使用slave3数据源读取id为：{}数据",id);
        ShoppingCustomerInfo shoppingCustomerInfo = shoppingCustomerInfoService.findBySerialno(id);
        logger.info("----slave3对象读取为{}----",shoppingCustomerInfo.toString());
        return shoppingCustomerInfo;
    }

    public int masterInsert(){
        logger.info("使用maser数据源插入数据");
        ShoppingCustomerInfo customerInfo = new ShoppingCustomerInfo();
        customerInfo.setName("330630");
        customerInfo.setAddress("address30");
        customerInfo.setGender("1");
        customerInfo.setPhone("17809266135");
        customerInfo.setPhotourl("./30");
        customerInfo.setStatus("1");
        int num = shoppingCustomerInfoService.insertCustomer(customerInfo);
        logger.info("----maser数据源插入数据量： {}----",num);
        return num;
    }

    public int slave1Insert(){
        logger.info("使用slave1数据源插入数据");
        ShoppingCustomerInfo customerInfo = new ShoppingCustomerInfo();
        customerInfo.setName("331630");
        customerInfo.setAddress("address30");
        customerInfo.setGender("1");
        customerInfo.setPhone("17809266135");
        customerInfo.setPhotourl("./30");
        customerInfo.setStatus("1");
        int num = shoppingCustomerInfoService.insertCustomer(customerInfo);
        logger.info("----slave1数据源插入数据量： {}----",num);
        return num;
    }

    public int slave2Insert(){
        logger.info("使用slave2数据源插入数据");
        ShoppingCustomerInfo customerInfo = new ShoppingCustomerInfo();
        customerInfo.setName("332630");
        customerInfo.setAddress("address30");
        customerInfo.setGender("1");
        customerInfo.setPhone("17809266135");
        customerInfo.setPhotourl("./30");
        customerInfo.setStatus("1");
        int num = shoppingCustomerInfoService.insertCustomer(customerInfo);
        logger.info("----slave2数据源插入数据量： {}----",num);
        return num;
    }

    public int slave3Insert(){
        logger.info("使用slave3数据源插入数据");
        ShoppingCustomerInfo customerInfo = new ShoppingCustomerInfo();
        customerInfo.setName("999");
        customerInfo.setAddress("address30");
        customerInfo.setGender("1");
        customerInfo.setPhone("17809266135");
        customerInfo.setPhotourl("./30");
        customerInfo.setStatus("1");
        int num = shoppingCustomerInfoService.insertCustomer(customerInfo);
        logger.info("----slave3数据源插入数据量： {}----",num);
        return num;
    }

    @Transactional(rollbackFor = Exception.class)
    public int masterUpdate(){
        logger.info("使用maser数据源更新数据");
        ShoppingCustomerInfo customerInfo = new ShoppingCustomerInfo();
        customerInfo.setId("1");
        customerInfo.setName("更新3306");
        customerInfo.setAddress("address30");
        customerInfo.setGender("1");
        customerInfo.setPhone("17809266135");
        customerInfo.setPhotourl("./30");
        customerInfo.setStatus("1");
        int num = shoppingCustomerInfoService.updateCustomerBySerialno(customerInfo);
        logger.info("----maser数据源更新数据量： {}----",num);
        return num;
    }

    @Transactional(rollbackFor = Exception.class)
    public int slave1Update(){
        logger.info("使用slave1数据源更新数据");
        ShoppingCustomerInfo customerInfo = new ShoppingCustomerInfo();
        customerInfo.setId("1");
        customerInfo.setName("更新3316");
        customerInfo.setAddress("address30");
        customerInfo.setGender("1");
        customerInfo.setPhone("17809266135");
        customerInfo.setPhotourl("./30");
        customerInfo.setStatus("1");
        int num = shoppingCustomerInfoService.updateCustomerBySerialno(customerInfo);
        logger.info("----slave1数据源更新数据量： {}----",num);
        return num;
    }

    @Transactional(rollbackFor = Exception.class)
    public int slave2Update(){
        logger.info("使用slave2数据源更新数据");
        ShoppingCustomerInfo customerInfo = new ShoppingCustomerInfo();
        customerInfo.setId("1");
        customerInfo.setName("更新3326");
        customerInfo.setAddress("address30");
        customerInfo.setGender("1");
        customerInfo.setPhone("17809266135");
        customerInfo.setPhotourl("./30");
        customerInfo.setStatus("1");
        int num = shoppingCustomerInfoService.updateCustomerBySerialno(customerInfo);
        logger.info("----slave2数据源更新数据量： {}----",num);
        return num;
    }

    @Transactional(rollbackFor = Exception.class)
    public int slave3Update(){
        logger.info("使用slave3数据源更新数据");
        ShoppingCustomerInfo customerInfo = new ShoppingCustomerInfo();
        customerInfo.setId("2");
        customerInfo.setName("更新999");
        customerInfo.setAddress("address30");
        customerInfo.setGender("1");
        customerInfo.setPhone("17809266135");
        customerInfo.setPhotourl("./30");
        customerInfo.setStatus("1");
        int num = shoppingCustomerInfoService.updateCustomerBySerialno(customerInfo);
        logger.info("----slave3数据源更新数据量： {}----",num);
        return num;
    }


}
