package com.miniprogram.service.impl;

import com.miniprogram.mapper.ProjectMapper;
import com.miniprogram.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Project)表服务实现类
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:21:46
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectMapper projectMapper;

}