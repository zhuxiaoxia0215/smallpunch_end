package com.miniprogram.service.impl;

import com.miniprogram.mapper.LableMapper;
import com.miniprogram.service.LableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Lable)表服务实现类
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:13:29
 */
@Service("lableService")
public class LableServiceImpl implements LableService {
    @Resource
    private LableMapper lableMapper;

}