package com.geek.course.service;

import com.geek.course.Entity.User;

public interface UserService {

    public User getUser(String username, String password);
}
