package com.miniprogram.mapper;

import com.miniprogram.entity.ProjectLabel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * (ProjectLabel)表数据库访问层
 *
 * @author zhuxiaoxia
 * @since 2021-02-22 17:28:19
 */
@Mapper
public interface ProjectLabelMapper {

    Map selectTypeLabel ( Integer projectId);

    Integer createProjectLabel (ProjectLabel projectLabel);

}