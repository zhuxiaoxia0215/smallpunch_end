package com.miniprogram.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miniprogram.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    @Autowired
    private AttendUserService attendUserService;

    @PostMapping("/getDiaryDetailInfoById")
    public Map getDiaryDetailInfoById (@RequestBody Map<String,Object> json, HttpServletRequest request){
        Map outerMap = new HashMap<String,Object>();
        try{
            Integer diaryId= (Integer) json.get("diaryId");
            Integer vistorId = (Integer) json.get("visitorId");
            Map diaryMap = diaryService.selectDiaryById(diaryId);
            List<Map> commentList=commentService.getDiaryComment(diaryId);
            List<Map> likeList=likeService.getLikeInfo(diaryId);
            List<Map> diaryResourceList=diaryResourceService.getDiaryResource(diaryId);
            Map projectInfo = projectService.selectProjectInfo(diaryId);
            Integer projectId =(Integer)projectInfo.get("projectId");
            diaryMap.put("allCommentInfo",commentList);
            diaryMap.put("allLikeInfo",likeList);
            diaryMap.put("comment_num",commentList.size());
            diaryMap.put("like_user_num",likeList.size());
            diaryMap.put("diaryResource",diaryResourceList);
            diaryMap.put("publisher",userInfoService.selectRespondentByDiaryId(diaryId));
            diaryMap.put("projectInfo",projectInfo);
            diaryMap.put("existAttendProject",attendUserService.existAttendProject(vistorId,projectId));
            diaryMap.putAll(likeService.selectLikeRecore(vistorId,diaryId));
            outerMap.put("data",diaryMap);
            outerMap.put("sucMsg","获取日记详情成功");
            return outerMap;
        }catch(Exception e){
            e.printStackTrace();
            outerMap.put("errMsg","获取日记详情失败");
            return outerMap;
        }
    }

    @PostMapping("/getDiaryListByRecommend")
    public Map getDiaryListByRecommend (@RequestBody Map<String,Object> json,HttpServletRequest request){
        Map<String,Object> outerMap =new HashMap<>();
        try{
            int PageNo=(Integer) json.get("pageNo");
            int dataNum= (Integer) json.get("dataNum");
            Integer userId = (Integer) json.get("userId");
            List<Integer> projectIdList = (List) json.get("projectIdList");
            List<Map> allDiary = new ArrayList<>();
            List<Map> diaryIdList = new ArrayList<>();
            for (Integer projectId :projectIdList){
                allDiary.addAll(diaryService.selectDiaryByProject(projectId));
            }
            for( int i=0; i<allDiary.size(); i++){
                Integer diaryId = (Integer) allDiary.get(i).get("id");
                List<Map> diaryResourceList=diaryResourceService.getDiaryResource(diaryId);
                List<Map> commentList=commentService.getDiaryComment(diaryId);
                List<Map> likeList=likeService.getLikeInfo(diaryId);
                Map projectInfo = projectService.selectRecommendProjectInfo(diaryId);
                Integer projectId = (Integer) projectInfo.get("id");
                allDiary.get(i).put("diaryResource",diaryResourceList);
                allDiary.get(i).put("comment_num",commentList.size());
                allDiary.get(i).putAll(likeService.selectLikeRecore(userId,diaryId));
                allDiary.get(i).put("like_user_num",likeList.size());
                allDiary.get(i).put("publisher",userInfoService.selectRespondentByDiaryId(diaryId));
                allDiary.get(i).put("projectInfo",projectInfo);
                allDiary.get(i).put("recentThreeAttendUserList",attendUserService.getRecentAttendUser(projectId));

            }
            List<Map> pageInfo = new ArrayList<>();
            int start = (PageNo-1)*dataNum;
            for( int i= start; i<start+dataNum;i++){
                if(i<allDiary.size()){
                    pageInfo.add(allDiary.get(i));
                }else{
                    break;
                }

            }
            outerMap.put("data",pageInfo);
            outerMap.put("susMsg","操作成功");

        }catch (Exception e){
            outerMap.put("errMsg",e.getMessage());
        }
        return outerMap;
    }
}
