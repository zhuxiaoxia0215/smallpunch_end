package com.miniprogram.mapper;

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
}