DROP DATABASE IF EXISTS `demo_ds_1`;

CREATE DATABASE  `demo_ds_1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

USE demo_ds_1;

-- ----------------------------
-- Table structure for t_bank_freeze
-- ----------------------------
DROP TABLE IF EXISTS `t_bank_freeze`;
CREATE TABLE `t_bank_freeze` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 自增列',
  `customer_id` int(11) NOT NULL COMMENT '用户编号',
  `account_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '账户类型：1 人民币账户，2 美元账户',
  `amount` bigint(20) NOT NULL COMMENT '客户余额 单位 分',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_validate` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据是否有效标识：1有效数据，2 无效数据',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_try_log`;
CREATE TABLE `t_try_log` (
  `tx_no` varchar(64) NOT NULL COMMENT '事务id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`tx_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `t_confirm_log`;
CREATE TABLE `t_confirm_log` (
                                 `tx_no` varchar(64) NOT NULL COMMENT '事务id',
                                 `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
                                 PRIMARY KEY (`tx_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `t_cancel_log`;
CREATE TABLE `t_cancel_log` (
                                `tx_no` varchar(64) NOT NULL COMMENT '事务id',
                                `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
                                PRIMARY KEY (`tx_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;