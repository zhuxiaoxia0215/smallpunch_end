package com.miniprogram.controller;

import com.miniprogram.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/index/punchCardDiary")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private LikeService likeService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private DiaryResourceService diaryResourceService;

    @PostMapping("/getDiaryDetailInfoById")
    public Map getDiaryDetailInfoById (@RequestBody Map<String,Object> json, HttpServletRequest request){
        Map outerMap = new HashMap<String,Object>();
        try{
            Integer diaryId= (Integer) json.get("diaryId");
            //Integer vistorId = (Integer) json.get("visitorId");
            Map diaryMap = diaryService.selectDiaryById(diaryId);
            List<Map> commentList=commentService.getDiaryComment(diaryId);
            List<Map> likeList=likeService.getLikeInfo(diaryId);
            List<Map> diaryResourceList=diaryResourceService.getDiaryResource(diaryId);
            diaryMap.put("allCommentInfo",commentList);
            diaryMap.put("allLikeInfo",likeList);
            diaryMap.put("comment_num",commentList.size());
            diaryMap.put("like_user_num",likeList.size());
            diaryMap.put("diaryResource",diaryResourceList);
            diaryMap.put("publisher",userInfoService.selectRespondentByDiaryId(diaryId));
            diaryMap.put("projectInfo",projectService.selectProjectInfo(diaryId));
            outerMap.put("data",diaryMap);
            outerMap.put("sucMsg","获取日记详情成功");
            return outerMap;
        }catch(Exception e){
            e.printStackTrace();
            outerMap.put("errMsg","获取日记详情失败");
            return outerMap;
        }
    }
}
