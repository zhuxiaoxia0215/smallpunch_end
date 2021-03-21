package com.miniprogram.mapper;

import com.miniprogram.entity.ProjectIntroduce;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * (ProjectIntroduce)表数据库访问层
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:22:35
 */
@Mapper
public interface ProjectIntroduceMapper {

    List<Map> getProjectIntr (Integer projectId);

    int update(ProjectIntroduce projectIntroduce);

    void insert(ProjectIntroduce projectIntroduce);
}