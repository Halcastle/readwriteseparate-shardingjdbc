package com.example.readwriteseparateshardingjdbc.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.readwriteseparateshardingjdbc.entity.ShoppingCustomerInfo;
import com.example.readwriteseparateshardingjdbc.service.BuyCommodityService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

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

    @RequestMapping(value = "/write/{number}", method = RequestMethod.GET)
    public void writeNumber(@PathVariable(name = "number") int number) {
        Random random = new Random();
        Random commotityRandom = new Random();
        JSONObject resultJson = new JSONObject();
        for (int i = 0; i < number; i++) {
            int rInt = random.nextInt(number);
            int rCommotityId = commotityRandom.nextInt(6);
            ShoppingCustomerInfo customerInfo = new ShoppingCustomerInfo();
            customerInfo.setId(null);
            customerInfo.setName("客户" + (rInt+1));
            customerInfo.setGender("1");
            customerInfo.setPhone("17809266135");
            customerInfo.setAddress("address" + (rInt+1));
            customerInfo.setPhotourl("./" + (rInt+1));
            customerInfo.setStatus("1");
            resultJson.put("customerInfo", customerInfo);
            JSONArray commotitys = new JSONArray();
            for (int j = 0; i <= rCommotityId; i++) {
                JSONObject commotityListJson = new JSONObject();
                commotityListJson.put("commotityId", Long.valueOf(commotityRandom.nextInt(6)+1));
                commotityListJson.put("commotityNumber", Long.valueOf(commotityRandom.nextInt(10)+1));

                commotitys.add(commotityListJson);
            }
            resultJson.put("commotityList", commotitys);
            log.info("-------------resultJson------------" + resultJson);

            buyCommodityService.buyCommodity(resultJson);
        }


    }
}
