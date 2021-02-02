package com.miniprogram.service.impl;

import com.miniprogram.mapper.AttendUserMapper;
import com.miniprogram.service.AttendUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Override
    public Map getAttendUserNum(Integer projectId) {
        return attendUserMapper.getAttendUserNumByProjectId(projectId);
    }
}