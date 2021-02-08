package com.miniprogram.service;

import java.util.List;
import java.util.Map;

/**
 * (Diary)表服务接口
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:10:59
 */
public interface DiaryService {

    Map selectDiaryById (Integer diaryId);

    Map getPunchCardNum (Integer projectId);

    List<Map> selectDiaryByProject (Integer projectId);

}