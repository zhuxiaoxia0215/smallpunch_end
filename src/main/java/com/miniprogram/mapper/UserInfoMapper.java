package com.miniprogram.mapper;

import com.miniprogram.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * (UserInfo)表数据库访问层
 *
 * @author zhuxiaoxia
 * @since 2021-01-27 10:10:27
 */

@Mapper
public interface UserInfoMapper {

    UserInfo selectByOpenId (String open_id);

    int insert (String openId,String nickName,String avatarUrl,String sex);

}