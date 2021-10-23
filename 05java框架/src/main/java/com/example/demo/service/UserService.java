package com.example.demo.service;


import com.example.demo.Entity.User;

public interface UserService {
    /**
     * 根据 Username 和 password 查找 User 对象
     * @param username 账号名称
     * @param password 账户密码
     * @return User
     */
    public User getUser(String username, Integer password);
}
