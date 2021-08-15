package com.example.readwriteseparateshardingjdbc.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.readwriteseparateshardingjdbc.entity.ShoppingCommodityInfo;
import com.example.readwriteseparateshardingjdbc.entity.ShoppingCustomerInfo;
import com.example.readwriteseparateshardingjdbc.entity.ShoppingOrderInfo;
import com.example.readwriteseparateshardingjdbc.entity.ShoppingOrderRelationInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @ClassName BuyCommodityService
 * @Description TODO
 * @Author Dream
 * @Date 2021-08-14 22:12
 * @Version 1.0
 **/
@Service
@Log4j2
public class BuyCommodityService {
    @Autowired
    OrderService orderService;

    @Autowired
    OrderRelationService orderRelationService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CommotityService commotityService;

    public void buyCommodity(JSONObject json){
        ShoppingCustomerInfo customerInfo = json.getObject("customerInfo",ShoppingCustomerInfo.class);
        JSONArray commotityList = json.getJSONArray("commotityList");
        //插入客戶表
        Long customerId = null;
        String certid = customerInfo.getCertid();
        log.info("begin--根据客户身份证号：{}查询客户信息",certid);
        ShoppingCustomerInfo customer_db = customerService.findCustomerByCertId(certid);
        log.info("end--根据客户身份证号：{}查询客户信息完成：{}",certid,customer_db);
        if(null == customer_db){
            log.info("begin--生成客户信息：{}",customerInfo);
            customerId = customerService.generateCustomer(customerInfo);
            log.info("end--生成客户信息完成：{}",customerInfo);
        }else{
            Long id = customer_db.getId();
            customerInfo.setId(id);
            if("1".equals(customer_db.getStatus())){
                customerInfo.setStatus("2");
            }else {
                customerInfo.setStatus("1");
            }
            log.info("begin--更新客户信息：{}",customerInfo);
            customerId = customerService.updateCustomerByCustomerInfo(customerInfo);
            log.info("end--更新客户信息完成：{}",customerInfo);
        }
        //插入订单表及订单关联表
        commotityList.stream().map((com)->{
            return (JSONObject)com;
        }).forEach((commotityJson)->{
            Long commotityId = commotityJson.getLong("commotityId");
            Long commotityNumber = commotityJson.getLong("commotityNumber");
            log.info("begin--根据商品id：{}查询商品信息",commotityId);
            ShoppingCommodityInfo commodityInfo = commotityService.findId(commotityId);
            log.info("end--根据商品id：{}查询商品信息完成：{}",commotityId,commodityInfo);
            BigDecimal orderTotalAmt = commodityInfo.getOfferingprice().multiply(BigDecimal.valueOf(commotityNumber));
            ShoppingOrderInfo orderInfo = new ShoppingOrderInfo();
            orderInfo.setId(null);
            orderInfo.setCustomerid(customerInfo.getId());
            orderInfo.setInitamount(orderTotalAmt);
            orderInfo.setDiscountamount(BigDecimal.ZERO);
            orderInfo.setFreightcharge(BigDecimal.ZERO);
            orderInfo.setTotalamount(orderTotalAmt);
            orderInfo.setModeofpayment("1");
            orderInfo.setIsenabled("1");
            log.info("begin--生成订单：{}",orderInfo);
            orderService.generateOrder(orderInfo);
            log.info("end--生成订单完成：{}",orderInfo);
            Long orderId = orderInfo.getId();

                    //插入订单关联表
            ShoppingOrderRelationInfo orderRelationInfo = new ShoppingOrderRelationInfo();
            orderRelationInfo.setId(null);
            orderRelationInfo.setOrderserialno(orderId);
            orderRelationInfo.setCommodityid(commotityId);
            orderRelationInfo.setCommoditycount(commotityNumber);
            log.info("begin--生成关联信息：{}",orderRelationInfo);
            orderRelationService.generateOrderRelationService(orderRelationInfo);
            log.info("begin--生成关联信息完成：{}",orderRelationInfo);
        });


    }
}
