package com.miniprogram.service;

import com.miniprogram.entity.ProjectIntroduce;

import java.util.List;
import java.util.Map;

/**
 * (ProjectIntroduce)表服务接口
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:22:36
 */
public interface ProjectIntroduceService {

    List<Map> getProjectIntr (Integer projectId);

    int update(ProjectIntroduce projectIntroduce);
}