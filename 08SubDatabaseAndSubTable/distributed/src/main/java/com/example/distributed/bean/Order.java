package com.example.distributed.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;

@TableName("t_order")
@Data
public class Order {
    private static final long serialVersionUID = 1L;

    /**
     ** 字典id
     */
    @TableId(value = "order_id")
    private Long orderId;

    /**
     ** 字典名称
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     ** 状态
     */
    @Column(name = "status")
    private String status;
}
