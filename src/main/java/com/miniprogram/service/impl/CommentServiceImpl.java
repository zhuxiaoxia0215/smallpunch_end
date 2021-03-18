package com.miniprogram.service.impl;

import com.miniprogram.entity.Comment;
import com.miniprogram.mapper.CommentMapper;
import com.miniprogram.mapper.UserInfoMapper;
import com.miniprogram.service.CommentService;
import com.miniprogram.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Comment)表服务实现类
 *
 * @author zhuxiaoxia
 * @since 2021-02-01 11:17:37
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private UserInfoService userInfoService;


    @Override
    public List getDiaryComment(Integer diaryId) {
        /**
        *@Description: 根据查出的评论list，取出diaryId，根据diaryId查出发表人和回复人的信息
        *@Param: [diaryId]
        *@return: java.util.List
        *@Author: zhuxiaoxia
        */
        List<Map> commentList=commentMapper.selectByDiaryId(diaryId);
        List<Map> commentWithUserList = new ArrayList<>();
        for(Map<String,Object> comment:commentList){
            Map respondent=userInfoService.selectUserById((Integer) comment.get("respondent_id"));
            Map reviewer = userInfoService.selectUserById((Integer) comment.get("reviewer"));
            comment.remove("respondent_id");
            comment.remove("reviewer");
            comment.put("respondent",respondent);
            comment.put("reviewer",reviewer);
//            Integer diaId = (Integer) comment.get("diary_id");
//            Integer commentId = (Integer)comment.get("id");
//            Map respondent = userInfoService.selectById();
//            Map reviewer=userInfoService.selectReviewerByDiaryId(commentId);
//            comment.put("respondent",respondent);
//            comment.put("reviewer",reviewer);
            commentWithUserList.add(comment);
        }
        return commentWithUserList;
    }

    @Override
    public int addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }

    @Override
    public Map selectCommentById(Integer commentId) {
        Map comment = commentMapper.selectCommentById(commentId);
        Map respondent=userInfoService.selectUserById((Integer) comment.get("respondent_id"));
        Map reviewer = userInfoService.selectUserById((Integer) comment.get("reviewer"));
        comment.remove("respondent_id");
        comment.remove("reviewer");
        comment.put("respondent",respondent);
        comment.put("reviewer",reviewer);
        return comment;
    }

    @Override
    public int deleteCommentById(Integer commentId) {
        return commentMapper.deleteCommentById(commentId);
    }

    @Override
    public int deleteCommentByDiaryId(Integer diaryId) {
        return commentMapper.deleteCommentByDiaryId(diaryId);
    }

    @Override
    public Map getUnReadNum(Integer userId) {
        return commentMapper.getUnReadNum(userId);
    }

    @Override
    public List<Map> selectByRespondentId(Integer userId) {
        return commentMapper.getUnReadByRespondent(userId);
    }

    @Override
    public void setNewsReadStatus(Integer recordId) {
        commentMapper.setReasdStatus(recordId);
    }


}