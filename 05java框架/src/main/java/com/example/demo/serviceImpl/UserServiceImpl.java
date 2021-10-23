package com.example.demo.serviceImpl;


import com.example.demo.Entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Repository;

@Repository("userServiceImpl")
//@Repository("userServiceImpl")相当于配置文件中的:<bean id="userServiceImpl"
// class="com.geek.course.service.UserService.UserServiceImpl" />
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(String userName, Integer password) {
        System.out.println("userController...getUser...");
        User user = new User(userName,password,null);
        return user;
    }
}
