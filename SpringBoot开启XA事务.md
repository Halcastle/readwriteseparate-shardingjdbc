# SpringBoot开启XA事务

1. 配置springboot事务管理器，配置之后会自动替代加载配置

   ```java
   @Configuration
   @EnableTransactionManagement
   public class TransactionConfiguration {
       @Bean
       public PlatformTransactionManager txManager(final DataSource dataSource) {
           return new DataSourceTransactionManager(dataSource);
       }
   
       @Bean
       public JdbcTemplate jdbcTemplate(final DataSource dataSource) {
           return new JdbcTemplate(dataSource);
       }
   }
   ```

2. 业务代码使用XA事务

   ```java
   @Transactional
   @ShardingTransactionType(TransactionType.XA)  // 支持TransactionType.LOCAL, TransactionType.XA, TransactionType.BASE
   public Long updateCustomerByCustomerInfo(ShoppingCustomerInfo customerInfo){
       return customerInfoServiceimpl.updateCustomerByCustomerInfo(customerInfo);
   }
   ```

3. 配置mysql事务隔离级别为：**Serializable（可串行化）**