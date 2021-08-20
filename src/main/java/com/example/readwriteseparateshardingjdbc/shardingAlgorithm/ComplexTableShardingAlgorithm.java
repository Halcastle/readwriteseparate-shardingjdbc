package com.example.readwriteseparateshardingjdbc.shardingAlgorithm;


import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j2;
import org.apache.shardingsphere.api.sharding.ShardingValue;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
//https://www.cnblogs.com/rinack/p/11241111.html
/**
  *@ClassName ComplexShardingAlgorithm.java
  *@Description 复合分片算法
 * http://wuwenliang.net/2019/03/26/%E8%B7%9F%E6%88%91%E5%AD%A6shardingjdbc%E4%B9%8B%E8%87%AA%E5%AE%9A%E4%B9%89%E5%88%86%E5%BA%93%E5%88%86%E8%A1%A8%E7%AD%96%E7%95%A5-%E5%A4%8D%E5%90%88%E5%88%86%E7%89%87%E7%AE%97%E6%B3%95%E8%87%AA%E5%AE%9A%E4%B9%89%E5%AE%9E%E7%8E%B0/
  *@Author pwang6
  *@Date 2021/8/20 18:24
  *@Version 1.0
  **/
@Log4j2
public class ComplexTableShardingAlgorithm implements ComplexKeysShardingAlgorithm {

    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue shardingValue) {
        // 1. 打印物理分表集合 及 分片键属性集合
        log.info("availableTargetNames:" + JSON.toJSONString(availableTargetNames) + ",ComplexKeysShardingValue:" + shardingValue);

        // availableTargetNames:["t_new_order_0000","t_new_order_0001"],
        // shardingValues:[{"columnName":"order_id","logicTableName":"t_new_order","values":["OD010001011903261549424993200011"]},{"columnName":"user_id","logicTableName":"t_new_order","values":["UD030001011903261549424973200007"]}]
//        Collection<String> collection = new ArrayList<>();
//        // 2. 遍历分片键集合
//        for (ShardingValue var : shardingValues) {
//            // 2.1 逻辑与分库逻辑相同，转换ShardingValue为ListShardingValue
//            ListShardingValue<String> listShardingValue = (ListShardingValue<String>)var;
//            List<String> shardingValue = (List<String>)listShardingValue.getValues();
//            // 3. 打印当前分片键的真实值
//            // shardingValue:["OD010001011903261549424993200011"]
//            log.info("shardingValue:" + JSON.toJSONString(shardingValue));
//
//            // 4. 根据分片键的真实值获取数据分表索引值
//            String index = getIndex(listShardingValue.getLogicTableName(),                              listShardingValue.getColumnName(),
//                    shardingValue.get(0));
//            // 5. 循环匹配数据表，通过String.endsWith(String suffix)
//            // 判断第4步中获取到的索引是否包含在当前循环的物理分表中，
//            // （如：判断t_new_order_0000中是否包含“_0000”）
//            // 从而证明当前数据匹配物理分表成功。
//            for (String availableTargetName : availableTargetNames) {
//                if (availableTargetName.endsWith("_" + index)) {
//                    collection.add(availableTargetName);
//                    break;
//                }
//            }
//            // 6. 只要匹配成功一种路由规则就退出
//            if (collection.size() > 0) {
//                break;
//            }
//        }
//        // 7. 返回表路由结果
//        return collection;
        Collection<String> collection = new ArrayList<>();
        collection.add("shopping_customer_info0");
        return collection;
    }
}