package com.miniprogram.mapper;

import com.miniprogram.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Project)表数据库访问层
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:21:45
 */
@Mapper
public interface ProjectMapper {

    List<HashMap> selectByUserId (Integer userId);

    Map selectProjectByDiaryId(Integer diaryId);

    Integer createProject(Project project);

    Map<String,Object> getProjectInfoById (Integer project);
}