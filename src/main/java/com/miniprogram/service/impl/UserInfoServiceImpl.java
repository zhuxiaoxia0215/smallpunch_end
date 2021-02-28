package com.miniprogram.service.impl;

import com.miniprogram.entity.UserInfo;
import com.miniprogram.mapper.UserInfoMapper;
import com.miniprogram.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (UserInfo)表服务实现类
 *
 * @author zhuxiaoxia
 * @since 2021-01-27 10:10:28
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public Map addUserInfo(String openId, String nickName, String avatarUrl, String sex) {

        Map userInfo=userInfoMapper.selectByOpenId(openId);
        if(userInfo == null){
            int insert = userInfoMapper.insert(openId,nickName,avatarUrl,sex);
            userInfo = userInfoMapper.selectByOpenId(openId);
        }
        return userInfo;
    }

    @Override
    public Map selectById(Integer userId) {
        return userInfoMapper.selectById(userId);
    }

    @Override
    public Map selectRespondentByDiaryId(Integer diaryId) {
        return userInfoMapper.selectRespondentByDiaryId(diaryId);
    }

    @Override
    public Map selectReviewerByDiaryId(Integer diaryId) {
        return userInfoMapper.selectReviewerByDiaryId(diaryId);
    }

    @Override
    public Map selectAdmirerById(Integer admirerId) {
        return userInfoMapper.selectAdmirerById(admirerId);
    }

    @Override
    public Map selectAdmirerNameById(Integer admirerId) {
        return userInfoMapper.selectAdmirerNameById(admirerId);
    }

    @Override
    public Map selectUserById(Integer userId){
        return userInfoMapper.selectUserById(userId);
    }

}