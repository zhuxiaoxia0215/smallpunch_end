package com.miniprogram.controller;

import com.miniprogram.entity.Comment;
import com.miniprogram.service.CommentService;
import com.miniprogram.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/index/DiaryComment")
public class CommentController {

    @Autowired
    CommentService commentService;
    @Autowired
    UserInfoService userInfoService;

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

    @PostMapping("/getMyCommentedList")
    public Map getMyCommentedList(HttpServletRequest request,@RequestBody Map<String, Object> json){
        Map rtnMap = new HashMap();
        try{
            Integer userId = (Integer) json.get("user_id");

            List<Map> result = commentService.selectByRespondentId(userId);
            List<Map> data = new LinkedList<>();
            if(null !=result && ! result.isEmpty() ){
                for(Map comment : result){
                    Integer reviewerId = (Integer) comment.get("reviewer");
                    Map reviewer = userInfoService.selectUserById(reviewerId);
                    comment.remove(reviewer);
                    comment.put("reviewer",reviewer);
                    data.add(comment);
                }

            }

            rtnMap.put("data",data);
            rtnMap.put("sucMsg","获取成功");
        }catch (Exception e){
            rtnMap.put("errMsg",e.getMessage());
        }
        return rtnMap;
    }
}
