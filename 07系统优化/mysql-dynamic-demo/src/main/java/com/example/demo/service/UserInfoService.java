package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.dto.PageRequest;
import com.example.demo.dto.UserInfoRequest;
import com.example.demo.entities.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserInfoService extends IService<UserInfo> {
    String saveUser(UserInfoRequest request);

    List<UserInfo> getUserList();
}
