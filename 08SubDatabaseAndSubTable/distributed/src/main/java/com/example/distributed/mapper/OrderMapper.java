package com.example.distributed.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.distributed.bean.Order;
import org.springframework.stereotype.Component;

@Component
public interface OrderMapper extends BaseMapper<Order> {

}
