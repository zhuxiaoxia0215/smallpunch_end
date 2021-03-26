package com.miniprogram.service.impl;

import com.miniprogram.entity.Project;
import com.miniprogram.mapper.AttendUserMapper;
import com.miniprogram.mapper.DiaryMapper;
import com.miniprogram.mapper.ProjectMapper;
import com.miniprogram.service.ProjectLabelService;
import com.miniprogram.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
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

    @Override
    public int updateCreatorIntr(Integer projectId, String introduce) {
        return projectMapper.updateCreatorIntr(projectId,introduce);
    }

    @Override
    public int updateWeiXinNum(Integer projectId, String weixinNum) {
        return projectMapper.updateWeixinNum(projectId,weixinNum);
    }

    @Override
    public int updateName(Integer projectId, String projectName) {
        return projectMapper.updateName(projectId,projectName);
    }

    @Override
    public Map getCreatorInfo(Integer projectId) {
        return projectMapper.getCreatInfo(projectId);
    }

    @Override
    public List<Map> selectByType(String typeName) {
        List<Map> projectList = projectMapper.selectByType(typeName);
        List<Map> result = new LinkedList<>();
        for (Map project : projectList){
            Integer projectId = (Integer) project.get("id");
            Map punchCardNum = diaryMapper.projectNum(projectId);
            Map attendNum = attendUserMapper.attendNum(projectId);

            project.putAll(punchCardNum);
            project.putAll(attendNum);
            result.add(project);
        }
        return result;
    }

    @Override
    public List<Map> selectByKeyWord(String keyWord) {
        return projectMapper.selectByKeyWord(keyWord);
    }


}