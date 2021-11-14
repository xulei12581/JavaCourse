package com.example.distributed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.distributed.mapper")
public class DistributedApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedApplication.class, args);
    }

}
