package com.example.readwriteseparateshardingjdbc.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.readwriteseparateshardingjdbc.entity.ShoppingCommodityInfo;
import com.example.readwriteseparateshardingjdbc.entity.ShoppingCustomerInfo;
import com.example.readwriteseparateshardingjdbc.entity.ShoppingOrderInfo;
import com.example.readwriteseparateshardingjdbc.entity.ShoppingOrderRelationInfo;
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
        if(null == customerService.findCustomerByCertId(customerInfo.getCertid())){
            customerId = customerService.generateCustomer(customerInfo);
        }else{
            customerId = customerService.updateCustomerByCustomerInfo(customerInfo);
        }
        //插入订单表及订单关联表
        commotityList.stream().map((com)->{
            return (JSONObject)com;
        }).forEach((commotityJson)->{
            Long commotityId = commotityJson.getLong("commotityId");
            Long commotityNumber = commotityJson.getLong("commotityNumber");
            ShoppingCommodityInfo commodityInfo = commotityService.findId(commotityId);
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
            Long orderId = orderService.generateOrder(orderInfo);

            //插入订单关联表
            ShoppingOrderRelationInfo orderRelationInfo = new ShoppingOrderRelationInfo();
            orderRelationInfo.setId(null);
            orderRelationInfo.setOrderserialno(orderId);
            orderRelationInfo.setCommodityid(commotityId);
            orderRelationInfo.setCommoditycount(commotityNumber);
        });


    }
}
