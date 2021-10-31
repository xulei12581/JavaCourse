CREATE TABLE `jike_user`  (
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
