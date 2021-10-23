package com.example.demo;

import com.example.demo.Entity.Student;
import com.example.demo.property.MyServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    //测试自动装配
    @Autowired
    MyServiceProperties myServiceProperties;

    @Bean
    public void print(){
        System.out.println(myServiceProperties.getMyProperties().getAge()+
                myServiceProperties.getMyProperties().getAuthor());
    }
}
