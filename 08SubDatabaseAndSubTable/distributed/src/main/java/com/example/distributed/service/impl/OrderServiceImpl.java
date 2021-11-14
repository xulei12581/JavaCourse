package com.example.distributed.service.impl;

import com.example.distributed.bean.Order;
import com.example.distributed.mapper.OrderMapper;
import com.example.distributed.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public void insert(Order order) {
        orderMapper.insert(order);
    }
}
