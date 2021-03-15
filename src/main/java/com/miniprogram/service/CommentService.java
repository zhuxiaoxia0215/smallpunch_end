package com.miniprogram.service;

import com.miniprogram.entity.Comment;

import java.util.List;
import java.util.Map;

/**
 * (Comment)表服务接口
 *
 * @author zhuxiaoxia
 * @since 2021-02-01 11:17:36
 */
public interface CommentService {

    List getDiaryComment (Integer diaryId);

    int addComment(Comment comment);

    Map selectCommentById (Integer commentId);

    int deleteCommentById (Integer commentId);

    int deleteCommentByDiaryId(Integer diaryId);

    Map getUnReadNum(Integer userId);
}