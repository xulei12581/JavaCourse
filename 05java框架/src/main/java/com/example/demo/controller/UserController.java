package com.example.demo.controller;

import com.example.demo.Entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/user")
//相当于配置文件中的:<bean id="userController" class=com.geek.course.controller.UserController" />
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public User get(){
        User user =  userService.getUser("1",2);
        return user;
    }

}
