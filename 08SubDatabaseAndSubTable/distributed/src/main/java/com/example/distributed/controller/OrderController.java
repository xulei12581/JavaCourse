package com.example.distributed.controller;

import com.example.distributed.bean.Order;
import com.example.distributed.mapper.OrderMapper;
import com.example.distributed.service.OrderService;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/saveDictInfo")
    public void saveDictInfo() {
        Order order = new Order();
        order.setStatus("1");
        order.setUserId(1L);
        orderService.insert(order);
        order.setStatus("2");
        order.setUserId(2L);
        orderService.insert(order);
    }


//    @PostMapping("XA")
//    @ShardingTransactionType(TransactionType.XA)
//    @Transactional
//    public void testXA(){
//
//    }

}
