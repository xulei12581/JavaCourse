package com.example.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.PageRequest;
import com.example.demo.dto.UserInfoRequest;
import com.example.demo.entities.BaseEntity;
import com.example.demo.entities.UserInfo;
import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.service.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @DS("master")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveUser(UserInfoRequest request) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(request, userInfo);
        boolean save = save(userInfo);
        if (!save) {
            throw new RuntimeException("添加用户失败");
        }
        return "添加用户成功";
    }

    @DS("slave_1")
    @Override
    public List<UserInfo> getUserList() {

        return userInfoMapper.getUserList();
    }
}
