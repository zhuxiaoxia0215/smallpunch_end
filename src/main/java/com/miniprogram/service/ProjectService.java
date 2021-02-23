package com.miniprogram.service;

import com.miniprogram.entity.Project;

import java.util.List;
import java.util.Map;

/**
 * (Project)表服务接口
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:21:45
 */
public interface ProjectService {

    List selectByUserId(Integer userId);

    Map selectProjectInfo(Integer diaryId);

    Map selectRecommendProjectInfo(Integer diaryId);

    Integer createProject(Project project);

}