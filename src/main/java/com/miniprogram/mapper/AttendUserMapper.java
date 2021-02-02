package com.miniprogram.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * (AttendUser)表数据库访问层
 *
 * @author zhuxiaoxia
 * @since 2021-01-30 18:11:48
 */
@Mapper
public interface AttendUserMapper {

    Map getAttendUserNumByProjectId (Integer projectId );

}