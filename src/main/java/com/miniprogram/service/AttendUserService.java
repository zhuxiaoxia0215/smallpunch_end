package com.miniprogram.service;

import com.miniprogram.entity.AttendUser;

import java.util.List;
import java.util.Map;

/**
 * (AttendUser)表服务接口
 *
 * @author zhuxiaoxia
 * @since 2021-01-30 18:11:49
 */
public interface AttendUserService {

    Map getAttendUserNum (Integer projectId);

    Boolean existAttendProject( Integer userId,Integer projectId);

    List<Map<String,String>> getRecentAttendUser(Integer projectId);

    List<Map> getAttendUser (Integer projectId);

    Map<String,Integer> getAttendId (Integer userId, Integer projectId);

    int joinInProject(AttendUser attendUser);
}