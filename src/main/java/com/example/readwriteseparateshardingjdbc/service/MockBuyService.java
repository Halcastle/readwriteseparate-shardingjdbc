package com.example.readwriteseparateshardingjdbc.service;

import com.example.readwriteseparateshardingjdbc.entity.ShoppingCustomerInfo;
import com.example.readwriteseparateshardingjdbc.entity.ShoppingOrderInfo;
import com.example.readwriteseparateshardingjdbc.entity.ShoppingOrderRelationInfo;
import com.example.readwriteseparateshardingjdbc.mapper.ShoppingCustomerInfoMapper;
import com.example.readwriteseparateshardingjdbc.mapper.ShoppingOrderInfoMapper;
import com.example.readwriteseparateshardingjdbc.mapper.ShoppingOrderRelationMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName MockService
 * @Description TODO
 * @Author Dream
 * @Date 2021-08-15 22:48
 * @Version 1.0
 **/
@Service
@Log4j2
public class MockBuyService {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public void mockBatchInsterCustomers(List<ShoppingCustomerInfo> customerInfos){
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        ShoppingCustomerInfoMapper mapper = sqlSession.getMapper(ShoppingCustomerInfoMapper.class);
        try{
            log.warn("try中customerInfos.size:{}",customerInfos.size());
            mapper.insertCustomersBatch(customerInfos);
            sqlSession.commit();
            sqlSession.clearCache();
        }catch (Exception e){
            log.warn(e);
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
            log.warn("sqlsession关闭！");
        }

    }

    public void mockBatchInsterOrders(List<ShoppingOrderInfo> orderInfos){
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        ShoppingOrderInfoMapper mapper = sqlSession.getMapper(ShoppingOrderInfoMapper.class);
        try{
            log.warn("try中orderInfos.size:{}",orderInfos.size());
            mapper.insertOrdersBatch(orderInfos);
            sqlSession.commit();
            sqlSession.clearCache();
        }catch (Exception e){
            log.warn(e);
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
            log.warn("sqlsession关闭！");
        }

    }

    public void mockBatchInsterOrderRelations(List<ShoppingOrderRelationInfo> orderRelationInfos){
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        ShoppingOrderRelationMapper mapper = sqlSession.getMapper(ShoppingOrderRelationMapper.class);
        try{
            log.warn("try中orderInfos.size:{}",orderRelationInfos.size());
            mapper.insertOrderRelationsBatch(orderRelationInfos);
            sqlSession.commit();
            sqlSession.clearCache();
        }catch (Exception e){
            log.warn(e);
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
            log.warn("sqlsession关闭！");
        }

    }
    public void mockBatchInsterCustomer(List<ShoppingCustomerInfo> customerInfos){
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        ShoppingCustomerInfoMapper mapper = sqlSession.getMapper(ShoppingCustomerInfoMapper.class);
        try{
            int tmp = 0;
            for(ShoppingCustomerInfo customerInfo : customerInfos){
                tmp++;
                mapper.insertCustomerBatch(customerInfo);
                if(tmp%2000 == 0){
                    sqlSession.commit();
                    sqlSession.clearCache();
                    log.info("----第{}条已提交-----",tmp);
                }
            };
            sqlSession.commit();
            sqlSession.clearCache();
            log.info("----共提交:{}-----",tmp);
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }

    }
}
