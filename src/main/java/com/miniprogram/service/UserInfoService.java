package com.miniprogram.service;

import com.miniprogram.entity.UserInfo;
import org.springframework.stereotype.Service;


/**
 * (UserInfo)表服务接口
 *
 * @author zhuxiaoxia
 * @since 2021-01-27 10:10:27
 */

public interface UserInfoService {

    UserInfo addUserInfo(String openId,String nickName,String avatarUrl,String sex);

}