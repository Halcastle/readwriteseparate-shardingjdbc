package com.example.readwriteseparateshardingjdbc.shardingAlgorithm;


import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j2;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.*;

/**
 * @ClassName ComplexShardingAlgorithm.java
 * @Description 复合分片算法
 * http://wuwenliang.net/2019/03/26/%E8%B7%9F%E6%88%91%E5%AD%A6shardingjdbc%E4%B9%8B%E8%87%AA%E5%AE%9A%E4%B9%89%E5%88%86%E5%BA%93%E5%88%86%E8%A1%A8%E7%AD%96%E7%95%A5-%E5%A4%8D%E5%90%88%E5%88%86%E7%89%87%E7%AE%97%E6%B3%95%E8%87%AA%E5%AE%9A%E4%B9%89%E5%AE%9E%E7%8E%B0/
 * @Author pwang6
 * @Date 2021/8/20 18:24
 * @Version 1.0
 **/
@Component
@Log4j2
public class ComplexDbShardingAlgorithm implements ComplexKeysShardingAlgorithm {

    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue shardingValue) {
        log.info("availableTargetNames:" + JSON.toJSONString(availableTargetNames) + ",ComplexKeysShardingValue:" + shardingValue);
//        availableTargetNames:["ds0","ds1","ds2"]
//        ComplexKeysShardingValue:ComplexKeysShardingValue(logicTableName=shopping_customer_info, columnNameAndShardingValuesMap={certid=[0], id=[635611807121145856]}, columnNameAndRangeValuesMap={})
//        ComplexKeysShardingValue:ComplexKeysShardingValue(logicTableName=shopping_customer_info, columnNameAndShardingValuesMap={certid=[0]}, columnNameAndRangeValuesMap={})
        Integer datasourcelength = availableTargetNames.size();
        Collection<String> collection = new ArrayList<>();
        Map columnNameAndShardingValuesMap = shardingValue.getColumnNameAndShardingValuesMap();
        BigInteger value = null;
        List certid = (List) columnNameAndShardingValuesMap.get("certid");
        value = new BigInteger((String) certid.get(0));
        if (null != value) {
            BigInteger[] bigIntegers = value.divideAndRemainder(BigInteger.valueOf(datasourcelength));
            collection.add("ds" + bigIntegers[1].toString());
            return collection;
        }
        List id = (List) columnNameAndShardingValuesMap.get("id");
        value = new BigInteger((String) certid.get(0));
        BigInteger[] bigIntegers = value.divideAndRemainder(BigInteger.valueOf(datasourcelength));
        collection.add("ds" + bigIntegers[1].toString());
        return collection;

    }
}

//https://www.cnblogs.com/rinack/p/11241111.html
