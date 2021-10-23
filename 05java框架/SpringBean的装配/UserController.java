package com.geek.course.controller;

import com.geek.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController("userController")
//相当于配置文件中的:<bean id="userController" class=com.geek.course.controller.UserController" />
public class UserController {

    @Autowired
    private UserService userService;

    public void save(){
        userService.getUser("1","2");
        System.out.println("userController...getUser...");
    }

}
