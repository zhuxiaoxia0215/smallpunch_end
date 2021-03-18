package com.miniprogram.controller;

import com.miniprogram.service.CommentService;
import com.miniprogram.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/index/UnreadNewsCount")
public class UnReadController {

    @Autowired
    CommentService commentService;
    @Autowired
    LikeService likeService;


    @PostMapping("/getUnreadNewsNum")
    public Map getUnreadNewsNum (@RequestBody Map<String,Object> json, HttpServletRequest request){
        Map rtnMap = new HashMap();
        try{
            Integer userId = (Integer) json.get("user_id");

            Map unreadComment = commentService.getUnReadNum(userId);
            Map unreadLike = likeService.getUnReadNum(userId);

            Map data = new HashMap();
            data.putAll(unreadComment);
            data.putAll(unreadLike);
            rtnMap.put("data",data);
            rtnMap.put("sucMsg","获取未读消息成功");
        }catch (Exception e){
            rtnMap.put("errMsg",e.getMessage());
        }
        return rtnMap;
    }

    /**
    *@Description: todo
    *@Param:
    *@return:
    *@Author: zhuxiaoxia
    */
    @PostMapping("/setNewsReadStatus")
    public Map setNewsReadStatus (HttpServletRequest request,@RequestBody Map<String, Object> json){
        Map rtnMap = new HashMap();
        try{
            String unreadNewsType = (String) json.get("unread_news_type");
            Integer recordId = (Integer) json.get("record_id");

            if(unreadNewsType!= null && !unreadNewsType.isEmpty()){
                if("commentNews".equals(unreadNewsType)){
                    commentService.setNewsReadStatus(recordId);
                }else {
                    likeService.setNewsReadStatus(recordId);
                }
            }
            Map data = new HashMap();
            rtnMap.put("data",data);
            rtnMap.put("sucMsg","已读成功");
        }catch (Exception e){
            rtnMap.put("errMsg",e.getMessage());
        }
        return rtnMap;
    }

    /**
    *@Description: todo
    *@Param:
    *@return:
    *@Author: zhuxiaoxia
    */
    @PostMapping("/getMyCommentedList")
    public Map getMyCommentedList(HttpServletRequest request,@RequestBody Map<String, Object> json){
        Map rtnMap = new HashMap();
        try{

            Map data = new HashMap();
            rtnMap.put("data",data);
            rtnMap.put("sucMsg","");
        }catch (Exception e){
            rtnMap.put("errMsg",e.getMessage());
        }
        return rtnMap;
    }
}
