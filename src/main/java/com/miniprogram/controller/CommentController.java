package com.miniprogram.controller;

import com.miniprogram.entity.Comment;
import com.miniprogram.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/index/DiaryComment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/addComment")
    public Map addComment(@RequestBody Map<String,Object> json, HttpServletRequest request){
        Map <String,Object> rtnMap = new HashMap<>();
        try{
            Comment comment = new Comment();
            comment.setDiaryId((Integer)json.get("diary_id"));
            comment.setRespondentId((Integer) json.get("respondent_id"));
            comment.setReviewer((Integer) json.get("reviewer_id"));
            comment.setPid((Integer) json.get("pid"));
            comment.setTextComment((String) json.get("text_comment"));
            comment.setCreateTime(new Date());

            commentService.addComment(comment);
            Map data = commentService.selectCommentById(comment.getId());
            rtnMap.put("data",data);
            rtnMap.put("sucMsg","评论成功");

        }catch(Exception e){
            rtnMap.put("errMsg",rtnMap);
        }
        return  rtnMap;
    }

    @PostMapping("/deleteComment")
    public Map deleteComment(@RequestBody Map<String,Object> json, HttpServletRequest request){
        Map<String,Object> rtnMap = new HashMap<>();
        try{
            Integer commentId = (Integer) json.get("commentId");
            Integer diaryId = (Integer) json.get("diaryId");

            int result = commentService.deleteCommentById(commentId);
            Map<String,Object> data = new HashMap<>();
            data.put("deletedNum",result);
            rtnMap.put("data",data);
            rtnMap.put("sucMsg","删除评论成功");

        }catch(Exception e){
            rtnMap.put("errMsg",rtnMap);
        }
        return rtnMap;
    }
}
