drop table if exists shopping_customer_info0;
drop table if exists shopping_customer_info1;
drop table if exists shopping_customer_info2;
drop table if exists shopping_customer_info3;
drop table if exists shopping_commodity_info;
drop table if exists shopping_order_info0;
drop table if exists shopping_order_info1;
drop table if exists shopping_order_info2;
drop table if exists shopping_order_info3;
drop table if exists shopping_order_relation0;
drop table if exists shopping_order_relation1;
drop table if exists shopping_order_relation2;
drop table if exists shopping_order_relation3;

CREATE TABLE `shopping_commodity_info` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(10) DEFAULT NULL COMMENT '名称',
  `describe` varchar(100) DEFAULT NULL COMMENT '描述',
  `classify` varchar(50) DEFAULT NULL COMMENT '分类',
  `repertorynum` varchar(100) DEFAULT NULL COMMENT '库存数量',
  `purchaseprice` decimal(17,6) DEFAULT NULL COMMENT '进货价格',
  `offeringprice` decimal(17,6) DEFAULT NULL COMMENT '出售价格',
  `isenabled` varchar(10) DEFAULT NULL COMMENT '是否有效',
  `inputdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入日期',
  `updatedate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='商品表'

CREATE TABLE `shopping_customer_info0` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `certid` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `gender` varchar(10) DEFAULT NULL COMMENT '性别',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `photourl` varchar(100) DEFAULT NULL COMMENT '头像url',
  `status` varchar(10) DEFAULT NULL COMMENT '用户状态',
  `inputdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入日期',
  `updatedate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=635444022944464897 DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE `shopping_customer_info1` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `certid` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `gender` varchar(10) DEFAULT NULL COMMENT '性别',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `photourl` varchar(100) DEFAULT NULL COMMENT '头像url',
  `status` varchar(10) DEFAULT NULL COMMENT '用户状态',
  `inputdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入日期',
  `updatedate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE `shopping_customer_info2` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `certid` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `gender` varchar(10) DEFAULT NULL COMMENT '性别',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `photourl` varchar(100) DEFAULT NULL COMMENT '头像url',
  `status` varchar(10) DEFAULT NULL COMMENT '用户状态',
  `inputdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入日期',
  `updatedate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE `shopping_customer_info3` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `certid` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `gender` varchar(10) DEFAULT NULL COMMENT '性别',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `photourl` varchar(100) DEFAULT NULL COMMENT '头像url',
  `status` varchar(10) DEFAULT NULL COMMENT '用户状态',
  `inputdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入日期',
  `updatedate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE `shopping_order_info0` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `customerid` varchar(50) NOT NULL COMMENT '订单所属用户编号',
  `initamount` decimal(17,6) DEFAULT NULL COMMENT '初始金额',
  `discountamount` decimal(17,6) DEFAULT NULL COMMENT '优惠金额',
  `freightcharge` decimal(17,6) DEFAULT NULL COMMENT '运费金额',
  `totalamount` decimal(17,6) DEFAULT NULL COMMENT '总金额',
  `modeofpayment` varchar(50) DEFAULT NULL COMMENT '支付方式',
  `isenabled` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `inputdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '录入日期',
  `updatedate` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

CREATE TABLE `shopping_order_info1` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `customerid` varchar(50) NOT NULL COMMENT '订单所属用户编号',
  `initamount` decimal(17,6) DEFAULT NULL COMMENT '初始金额',
  `discountamount` decimal(17,6) DEFAULT NULL COMMENT '优惠金额',
  `freightcharge` decimal(17,6) DEFAULT NULL COMMENT '运费金额',
  `totalamount` decimal(17,6) DEFAULT NULL COMMENT '总金额',
  `modeofpayment` varchar(50) DEFAULT NULL COMMENT '支付方式',
  `isenabled` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `inputdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '录入日期',
  `updatedate` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

CREATE TABLE `shopping_order_info2` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `customerid` varchar(50) NOT NULL COMMENT '订单所属用户编号',
  `initamount` decimal(17,6) DEFAULT NULL COMMENT '初始金额',
  `discountamount` decimal(17,6) DEFAULT NULL COMMENT '优惠金额',
  `freightcharge` decimal(17,6) DEFAULT NULL COMMENT '运费金额',
  `totalamount` decimal(17,6) DEFAULT NULL COMMENT '总金额',
  `modeofpayment` varchar(50) DEFAULT NULL COMMENT '支付方式',
  `isenabled` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `inputdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '录入日期',
  `updatedate` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

CREATE TABLE `shopping_order_info3` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `customerid` varchar(50) NOT NULL COMMENT '订单所属用户编号',
  `initamount` decimal(17,6) DEFAULT NULL COMMENT '初始金额',
  `discountamount` decimal(17,6) DEFAULT NULL COMMENT '优惠金额',
  `freightcharge` decimal(17,6) DEFAULT NULL COMMENT '运费金额',
  `totalamount` decimal(17,6) DEFAULT NULL COMMENT '总金额',
  `modeofpayment` varchar(50) DEFAULT NULL COMMENT '支付方式',
  `isenabled` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `inputdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '录入日期',
  `updatedate` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

CREATE TABLE `shopping_order_relation0` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `orderserialno` varchar(50) DEFAULT NULL COMMENT '订单关联流水号',
  `commodityid` varchar(50) DEFAULT NULL COMMENT '商品关联流水号',
  `commoditycount` varchar(50) DEFAULT NULL COMMENT '货品数量',
  `inputdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '录入日期',
  `updatedate` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单-商品关联表';

CREATE TABLE `shopping_order_relation1` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `orderserialno` varchar(50) DEFAULT NULL COMMENT '订单关联流水号',
  `commodityid` varchar(50) DEFAULT NULL COMMENT '商品关联流水号',
  `commoditycount` varchar(50) DEFAULT NULL COMMENT '货品数量',
  `inputdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '录入日期',
  `updatedate` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单-商品关联表';

CREATE TABLE `shopping_order_relation2` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `orderserialno` varchar(50) DEFAULT NULL COMMENT '订单关联流水号',
  `commodityid` varchar(50) DEFAULT NULL COMMENT '商品关联流水号',
  `commoditycount` varchar(50) DEFAULT NULL COMMENT '货品数量',
  `inputdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '录入日期',
  `updatedate` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单-商品关联表';

CREATE TABLE `shopping_order_relation3` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `orderserialno` varchar(50) DEFAULT NULL COMMENT '订单关联流水号',
  `commodityid` varchar(50) DEFAULT NULL COMMENT '商品关联流水号',
  `commoditycount` varchar(50) DEFAULT NULL COMMENT '货品数量',
  `inputdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '录入日期',
  `updatedate` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单-商品关联表';