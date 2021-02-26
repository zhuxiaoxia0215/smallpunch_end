package com.miniprogram.controller;

import com.miniprogram.entity.Like;
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
@RequestMapping("/index/DiaryLike")
public class LikeController {
    @Autowired
    private LikeService likeService;

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
}
