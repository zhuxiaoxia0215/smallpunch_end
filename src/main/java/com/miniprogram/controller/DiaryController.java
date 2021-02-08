package com.miniprogram.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
            int startPage=(Integer) json.get("pageNo");
            int pageSize= (Integer) json.get("dataNum");
            Integer userId = (Integer) json.get("userId");
            List<Integer> projectIdList = (List) json.get("projectIdList");

            Page page= PageHelper.startPage(startPage, pageSize);
// 从数据库查询，这里返回的的allUser就已经分页成功了
            List<Map> allDiary = new ArrayList<>();
            for (Integer projectId :projectIdList){
                allDiary.addAll(diaryService.selectDiaryByProject(projectId));
            }

// 获取查询记录总数，必须位于从数据库查询数据的语句之后，否则不生效
            long total = page.getTotal();

// 一下是layui的分页要求的信息
            HashMap<String, Object> map = new HashMap<>();
            map.put("code",0);
            map.put("msg","请求成功");
            //map.put("data",allUser);
            map.put("count",total);

        }catch (Exception e){

        }
        return outerMap;
    }
}
