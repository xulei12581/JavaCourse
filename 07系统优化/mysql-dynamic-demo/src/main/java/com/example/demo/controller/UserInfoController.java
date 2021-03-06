package com.example.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.dto.PageRequest;
import com.example.demo.dto.UserInfoRequest;
import com.example.demo.entities.UserInfo;
import com.example.demo.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RequestMapping("/userinfo")
@RestController
@RequiredArgsConstructor
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @PostMapping("/saveUser")
    @ApiOperation(value = "saveUser")
    public String saveUser(@RequestBody UserInfoRequest request) {
        return userInfoService.saveUser(request);
    }

    @GetMapping("/pageUser")
    @ApiOperation(value = "pageUser")
    public List<UserInfo> getUserList() {
        return userInfoService.getUserList();
    }

}
