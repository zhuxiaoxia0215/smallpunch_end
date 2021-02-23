package com.miniprogram.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * (AttendUser)表数据库访问层
 *
 * @author zhuxiaoxia
 * @since 2021-01-30 18:11:48
 */
@Mapper
public interface AttendUserMapper {

    Map<String,Object> getAttendUserNumByProjectId (Integer projectId );

    Map<String,Integer> attendId (Integer userId,Integer projectId);

    List<Map<String,String>> getRecentAttendUser(Integer projectId);
}