package com.miniprogram.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * (DiaryResource)表数据库访问层
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:12:49
 */
@Mapper
public interface DiaryResourceMapper {

    List<Map> selectDiaryResourceByDiaryId(Integer diaryid);

}