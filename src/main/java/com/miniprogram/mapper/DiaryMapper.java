package com.miniprogram.mapper;

import com.miniprogram.entity.Diary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * (Diary)表数据库访问层
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:10:59
 */
@Mapper
public interface DiaryMapper {

    Map selectDiaryById (Integer diaryId);

    Map getPunchCardNumByProjectId (Integer projectId);

    List<Map> selectDiaryByProject (Integer ProjectId);

    int addPunchCardDiary(Diary diary);

    int setSticky(Integer diaryId, Integer haveSticky);

    List<Map> selectDiaryByUserIdAll(Integer userId);

    List<Map> selectDiaryByUserIdVisible(Integer userId);

    int deleteDiaryById(Integer diaryId);

    List<String> selectPunchCardDay(Integer userId, Integer projectId);

    Map projectNum(Integer projectId);
}