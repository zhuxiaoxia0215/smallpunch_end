package com.miniprogram.controller;

import com.miniprogram.entity.Like;
import com.miniprogram.service.LikeService;
import com.miniprogram.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/index/DiaryLike")
public class LikeController {
    @Autowired
    private LikeService likeService;
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/like")
    public Map like(@RequestBody Map<String,Object> json, HttpServletRequest request){
        Map rtnMap = new HashMap();
        try {
            Like like=new Like();
            like.setAdmirerId((Integer) json.get("admirer_id"));
            like.setDiaryId((Integer) json.get("diary_id"));
            like.setLikedUserId((Integer) json.get("liked_user_id"));

            likeService.addLikeRecord(like);
            Map data = new HashMap();
            data.put("like_record_id",like.getId());
            rtnMap.put("data",data);
            rtnMap.put("sucMsg","点赞成功");
        }catch(Exception e){
            rtnMap.put("errMsg","点赞失败");
        }
        return rtnMap;
    }

    @PostMapping("/cancelLike")
    public Map cancelLike(@RequestBody Map<String,Object> json, HttpServletRequest request){
        Map rtnMap = new HashMap ();
        try{
            Integer diaryId = (Integer) json.get("diaryId");
            Integer likeRecordId = (Integer) json.get("likeRecordId");

            if(likeService.deleteLikeRecord(likeRecordId)> 0){
                rtnMap.put("data","");
                rtnMap.put("sucMsg","取消点赞成功");
            }
        }catch (Exception e){
            rtnMap.put("errMsg",e.getMessage());
        }
        return rtnMap;
    }

    @PostMapping("/getMyLikedList")
    public Map getMyCommentedList(HttpServletRequest request,@RequestBody Map<String, Object> json){
        Map rtnMap = new HashMap();
        try{
            Integer userId = (Integer) json.get("user_id");

            List<Map> result = likeService.selectByLikeUserId(userId);
            List<Map> data = new LinkedList<>();
            if(null !=result && ! result.isEmpty() ){
                for(Map likeInfo : result){
                    Integer reviewerId = (Integer) likeInfo.get("admirer_id");
                    Map reviewer = userInfoService.selectUserById(reviewerId);
                    likeInfo.remove(reviewer);
                    likeInfo.put("reviewer",reviewer);
                    data.add(likeInfo);
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
