package com.miniprogram.service;

import com.miniprogram.entity.Diary;

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

    int addPunchCardDiary(Diary diary);

    int setSticky(Integer diaryId, Integer haveSticky);

    List<Map> selectDiaryByUserIdAll(Integer visitedUserId);

    List<Map> selectDiaryByUserIdVisible(Integer visitedUserId);

    int deleteDiary(Integer diaryId);

    List<String> selectPunchCardDay(Integer userId, Integer proectId);
}