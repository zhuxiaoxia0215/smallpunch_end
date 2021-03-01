package com.miniprogram.service.impl;

import com.miniprogram.entity.AttendUser;
import com.miniprogram.mapper.AttendUserMapper;
import com.miniprogram.mapper.UserInfoMapper;
import com.miniprogram.service.AttendUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * (AttendUser)表服务实现类
 *
 * @author zhuxiaoxia
 * @since 2021-01-30 18:11:50
 */
@Service("attendUserService")
public class AttendUserServiceImpl implements AttendUserService {
    @Resource
    private AttendUserMapper attendUserMapper;
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public Map getAttendUserNum(Integer projectId) {
        return attendUserMapper.getAttendUserNumByProjectId(projectId);
    }

    @Override
    public Boolean existAttendProject(Integer userId, Integer projectId) {
        Map<String,Integer> map = attendUserMapper.attendId(userId, projectId);
        if(map != null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List getRecentAttendUser(Integer projectId){
        List<Map<String,String>> list= attendUserMapper.getRecentAttendUser(projectId);
        return list ;
    }

    @Override
    public List<Map> getAttendUser(Integer projectId) {
        List<Map> attendUserList = attendUserMapper.getAttendUser(projectId);
        List<Map> attendUserList1 = new LinkedList<>();
        for(Map attendUser : attendUserList){
            Integer userId = (Integer) attendUser.get("user_id");
            Map attendUserMap = userInfoMapper.selectUserById(userId);
            Map pivot = new HashMap();
            pivot.put("id",attendUser.get("id"));
            pivot.put("attend_time",attendUser.get("attend_time"));
            attendUserMap.put("pivot",pivot);
            attendUserList1.add(attendUserMap);
        }
        return attendUserList1;
    }

    @Override
    public Map<String, Integer> getAttendId(Integer userId, Integer projectId) {
        return attendUserMapper.attendId(userId,projectId);
    }

    @Override
    public int joinInProject(AttendUser attendUser) {
        return attendUserMapper.joinInProject(attendUser);
    }

}