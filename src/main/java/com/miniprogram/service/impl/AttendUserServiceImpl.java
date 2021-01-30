package com.miniprogram.service.impl;

import com.miniprogram.mapper.AttendUserMapper;
import com.miniprogram.service.AttendUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * (AttendUser)表服务实现类
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 09:56:37
 */
@Service("attendUserService")
public class AttendUserServiceImpl implements AttendUserService {
    @Resource
    private AttendUserMapper attendUserMapper;

}