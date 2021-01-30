package com.miniprogram.service.impl;

import com.miniprogram.mapper.ProjectIntroduceMapper;
import com.miniprogram.service.ProjectIntroduceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (ProjectIntroduce)表服务实现类
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:22:36
 */
@Service("projectIntroduceService")
public class ProjectIntroduceServiceImpl implements ProjectIntroduceService {
    @Resource
    private ProjectIntroduceMapper projectIntroduceMapper;

}