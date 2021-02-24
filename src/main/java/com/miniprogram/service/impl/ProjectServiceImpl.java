package com.miniprogram.service.impl;

import com.miniprogram.entity.Project;
import com.miniprogram.mapper.AttendUserMapper;
import com.miniprogram.mapper.DiaryMapper;
import com.miniprogram.mapper.ProjectLabelMapper;
import com.miniprogram.mapper.ProjectMapper;
import com.miniprogram.service.ProjectLabelService;
import com.miniprogram.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Resource
    private DiaryMapper diaryMapper;
    @Resource
    private AttendUserMapper attendUserMapper;
    @Resource
    private ProjectLabelService projectLabelService;

    @Override
    public List selectByUserId(Integer userId) {
        List<HashMap> projectList = projectMapper.selectByUserId(userId);
        return projectList;
    }

    @Override
    public Map selectProjectInfo(Integer diaryId) {
        Map projectMap = projectMapper.selectProjectByDiaryId(diaryId);
        Integer projectId= (Integer) projectMap.get("id");
        projectMap.putAll(diaryMapper.getPunchCardNumByProjectId(projectId));
        projectMap.putAll(attendUserMapper.getAttendUserNumByProjectId(projectId));
        return projectMap;
    }

    @Override
    public Map selectRecommendProjectInfo(Integer diaryId) {
        Map projectMap = projectMapper.selectProjectByDiaryId(diaryId);
        Integer projectId= (Integer) projectMap.get("id");
        List<Map<String,String>> typeLabelList = projectLabelService.selectTypeLabel(projectId);
        projectMap.put("type_label",typeLabelList);
        return projectMap;
    }

    @Override
    public Integer createProject(Project project){
        return projectMapper.createProject(project);
    }

    @Override
    public Map<String, Object> getProjectInfoById(Integer projectId) {
        return projectMapper.getProjectInfoById(projectId);
    }


}