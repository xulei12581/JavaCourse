DROP DATABASE IF EXISTS `geekbang`;

CREATE DATABASE  `geekbang` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

USE geekbang;

DROP TABLE IF EXISTS `geekbang_user`;
CREATE TABLE `geekbang_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '序列id',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `del_flag` int(11) NOT NULL DEFAULT 0 COMMENT '逻辑删除  0未删除 1已删除',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '联系方式',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人id',
  `modify_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人id',
  `user_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户编码',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3530209245085697 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `geekbang_order`;
CREATE TABLE `geekbang_order`  (
  `order_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `order_no` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '订单编号',
  `member_id` int(11) NOT NULL COMMENT '用户编号',
  `supplier_id` int(11) NOT NULL COMMENT '商品编码',
  `order_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '订单状态 0未付款,1已付款,2已发货,3已签收,-1退货申请,-2退货中,-3已退货,-4取消交易',
  `product_count` int(11) NOT NULL DEFAULT 0 COMMENT '商品数量',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人id',
  `modify_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人id',
  `del_flag` int(11) NOT NULL DEFAULT 0 COMMENT '逻辑删除  0未删除 1已删除',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `order_order_sn_member_id_order_status_out_trade_no_index`(`member_id`, `order_status`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `geekbang_commodity`;
CREATE TABLE `geekbang_commodity`  (
  `commodity_id` bigint(20) NOT NULL COMMENT '商品id',
  `commodity_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '商品编号',
  `commodity_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '商品名称',
  `commodity_price` decimal(10, 4) NULL DEFAULT NULL COMMENT '商品价格',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人id',
  `modify_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人id',
  `del_flag` int(11) NOT NULL DEFAULT 0 COMMENT '逻辑删除  0未删除 1已删除',
  PRIMARY KEY (`commodity_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;
