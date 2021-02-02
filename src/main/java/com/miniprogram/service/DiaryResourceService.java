package com.miniprogram.service;

import java.util.List;
import java.util.Map;

/**
 * (DiaryResource)表服务接口
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:12:49
 */
public interface DiaryResourceService {

    List<Map> getDiaryResource(Integer diaryId);

}