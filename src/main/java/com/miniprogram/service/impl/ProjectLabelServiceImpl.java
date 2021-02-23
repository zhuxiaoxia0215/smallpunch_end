package com.miniprogram.service.impl;

import com.miniprogram.mapper.ProjectLabelMapper;
import com.miniprogram.service.ProjectLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (ProjectLabel)表服务实现类
 *
 * @author zhuxiaoxia
 * @since 2021-02-22 17:28:19
 */
@Service("projectLabelService")
public class ProjectLabelServiceImpl implements ProjectLabelService {
    @Resource
    private ProjectLabelMapper projectLabelMapper;

}