package com.miniprogram.mapper;

import com.miniprogram.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * (Comment)表数据库访问层
 *
 * @author zhuxiaoxia
 * @since 2021-02-01 11:17:34
 */
@Mapper
public interface CommentMapper {

    List<Map> selectByDiaryId (Integer diaryId);

    int addComment(Comment comment);

    Map selectCommentById (Integer commentId);

    int deleteCommentById(Integer commentId);
}