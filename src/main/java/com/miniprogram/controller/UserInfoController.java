package com.miniprogram.controller;

import com.miniprogram.entity.UserInfo;
import com.miniprogram.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (UserInfo)表控制层
 *
 * @author zhuxiaoxia
 * @since 2021-01-27 10:10:29
 */
@RestController
@RequestMapping("userInfo")
public class UserInfoController {
    /**
     * 服务对象
     */
    @Resource
    private UserInfoService userInfoService;



}