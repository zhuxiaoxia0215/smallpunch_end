package com.miniprogram.mapper;

import com.miniprogram.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

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

    Map selectById(Integer userId);

    Map selectRespondentByDiaryId(Integer diaryId);

    Map selectReviewerByDiaryId(Integer commentId);

    Map selectAdmirerById(Integer id);

    Map selectUserById (Integer userId);

    Map selectAdmirerNameById(Integer id);
}