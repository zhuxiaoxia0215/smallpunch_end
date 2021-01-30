package com.miniprogram.service.impl;

import com.miniprogram.entity.Visit;
import com.miniprogram.mapper.VisitMapper;
import com.miniprogram.service.VisitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Visit)表服务实现类
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 11:06:49
 */
@Service("visitService")
public class VisitServiceImpl implements VisitService {
    @Resource
    private VisitMapper visitMapper;

}