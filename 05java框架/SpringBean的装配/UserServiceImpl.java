package com.geek.course.serviceImpl;

import com.geek.course.Entity.User;
import com.geek.course.service.UserService;
import org.springframework.stereotype.Repository;

@Repository("userServiceImpl")
//@Repository("userServiceImpl")相当于配置文件中的:<bean id="userServiceImpl"
// class="com.geek.course.service.UserService.UserServiceImpl" />
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(String userName, String password) {
        System.out.println("userController...getUser...");
        User user = new User("1",2,null);
        return user;
    }
}
