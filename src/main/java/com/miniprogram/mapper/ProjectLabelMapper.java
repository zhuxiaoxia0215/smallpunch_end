package com.miniprogram.mapper;

import com.miniprogram.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * (ProjectLabel)表数据库访问层
 *
 * @author zhuxiaoxia
 * @since 2021-02-22 17:28:19
 */
@Mapper
public interface ProjectLabelMapper {

    List<Map> selectTypeLabel (Integer projectId);

    Integer createProjectLabel (Project project);

}