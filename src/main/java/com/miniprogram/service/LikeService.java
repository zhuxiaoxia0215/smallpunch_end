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
}