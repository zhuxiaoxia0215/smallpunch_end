package com.miniprogram.mapper;

import com.miniprogram.entity.Like;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * (Like)表数据库访问层
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:15:27
 */
@Mapper
public interface LikeMapper {

    List<Map> selectLikeByDiaryId (Integer diaryId);

    Map<String,Object> selectLikeRecore(Integer diaryId,Integer userId);

    int addLikeRecord (Like like);

    int deleteLikeRecore(Integer likeRecordId);

    int deleteLikeRecoreByDiaryId(Integer diaryId);

    Map getUnReadNum(Integer userId);
}