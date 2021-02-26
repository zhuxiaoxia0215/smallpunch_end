package com.miniprogram.service;

import com.miniprogram.entity.Like;

import java.util.List;
import java.util.Map;

/**
 * (Like)表服务接口
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:15:28
 */
public interface LikeService {

    List getLikeInfo(Integer diaryId);

    Map<String,Object> selectLikeRecore(Integer userId,Integer diaryId);

    List getTenLikeInfo(Integer diaryId);

    int addLikeRecord (Like like);
}