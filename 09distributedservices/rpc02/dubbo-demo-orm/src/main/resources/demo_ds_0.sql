DROP DATABASE IF EXISTS `demo_ds_0`;

CREATE DATABASE  `demo_ds_0` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

USE demo_ds_0;

-- ----------------------------
-- Table structure for t_bank_account
-- ----------------------------
DROP TABLE IF EXISTS `t_bank_account`;
CREATE TABLE `t_bank_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 自增列',
  `customer_id` int(11) NOT NULL COMMENT '用户编号',
  `account_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '账户类型：1 人民币账户，2 美元账户',
  `balance` bigint(20) NOT NULL COMMENT '客户余额 单位 分',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户注册时间',
  `is_validate` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据是否有效标识：1有效数据，2 无效数据',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;