package com.miniprogram.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miniprogram.entity.Diary;
import com.miniprogram.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/index")
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

    @PostMapping("/PunchCardDiary/getDiaryDetailInfoById")
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

    @PostMapping("/punchCardDiary/getDiaryListByRecommend")
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

    @PostMapping("/punchCardDiary/getDiaryListByProjectId")
    public Map getDiaryListByProjectId(@RequestBody Map<String,Object> json,HttpServletRequest request){

        Map<String,Object> rtnMap = new HashMap<>();
        try{
            int PageNo=(Integer) json.get("pageNo");
            int dataNum= (Integer) json.get("dataNum");
            int isCreator = (Integer) json.get("isCreator");
            Integer userId = (Integer) json.get("userId");
            Integer projectId = (Integer) json.get("projectId");

            List<Map> diaryList = diaryService.selectDiaryByProject(projectId);
            List<Map> data = new LinkedList<>();
            for( Map diary : diaryList){
                Integer diaryId = (Integer) diary.get("id");
                List<Map> commentList=commentService.getDiaryComment(diaryId);
                List<Map> diaryResourceList=diaryResourceService.getDiaryResource(diaryId);
                List<Map> likeList=likeService.getLikeInfo(diaryId);
                List<Map> tenLikeInfo =likeService.getTenLikeInfo(diaryId);

                diary.put("allCommentInfo",commentList);
                diary.put("diaryResource",diaryResourceList);
                diary.put("publisher",userInfoService.selectRespondentByDiaryId(diaryId));
                diary.put("like_user_num",likeList.size());
                diary.put("comment_num",commentList.size());
                diary.put("tenLikeInfo",tenLikeInfo);
                diary.putAll(likeService.selectLikeRecore(userId,diaryId));
                data.add(diary);
            }
            List<Map> pageInfo = new ArrayList<>();
            int start = (PageNo-1)*dataNum;
            for( int i= start; i<start+dataNum;i++){
                if(i<data.size()){
                    pageInfo.add(data.get(i));
                }else{
                    break;
                }

            }
            rtnMap.put("data",pageInfo);
            rtnMap.put("sucMsg","获取日记详情成功");
        }catch (Exception e){
            rtnMap.put("errMsg",e.getMessage());
        }
        return rtnMap;
    }

    @PostMapping("/PunchCardDiary/addPunchCardDiary")
    public Map addPunchCardDiary(@RequestBody Map<String,Object> json,HttpServletRequest request){
        Map rtnMap = new HashMap();
        try{
            Diary diary = new Diary();

            if(json.get("address_latitude") != null){
                diary.setAddressLatitude((Double) json.get("address_latitude"));
            }
            if(json.get("address_longitude") != null){
                diary.setAddressLongitude((Double) json.get("address_longitude"));
            }
            diary.setIsRepairDiary((Integer) json.get("is_repair_diary"));
            diary.setProjectId((Integer) json.get("project_id"));
            diary.setPunchCardAddress((String) json.get("punch_card_address"));
            diary.setTextContent((String) json.get("text_content" ));
            diary.setPublisherId((Integer) json.get("user_id"));
            diary.setVisibleType((Integer) json.get("visible_type"));
            diary.setPunchCardTime(new Date());

            int i = diaryService.addPunchCardDiary(diary);
            Map data = new HashMap();
            data.put("diaryId",diary.getId());
            rtnMap.put("data",data);
            rtnMap.put("sucMsg","发表日记成功");
        }catch(Exception e){
            rtnMap.put("errMsg","发表日记成功失败");
        }
        return  rtnMap;
    }

    @PostMapping("/PunchCardDiary/deleteDiaryById")
    public Map deleteDiaryById (@RequestBody Map<String,Object> json,HttpServletRequest request){

        Map rtnMap = new HashMap();
        try {
            Integer diaryId = (Integer) json.get("diaryId");
            Integer projectId = (Integer) json.get("projectId");
            Integer userId = (Integer) json.get("userId");

            int diaryNum = diaryService.deleteDiary(diaryId);
            int commentNum = commentService.deleteCommentByDiaryId(diaryId);
            int likeNum = likeService.deleteLikeRecordByDiaryId(diaryId);

            rtnMap.put("data",String.format("成功删除%s条日记，%s条评论，%s条点赞",diaryNum,commentNum,likeNum));
            rtnMap.put("sucMsg","操作成功!");
        }catch (Exception e){

        }
        return rtnMap;
    }

    @PostMapping("/PunchCardDiary/dealDiarySticky")
    public Map dealDiarySticky(@RequestBody Map<String,Object> json,HttpServletRequest request){
        Map rtnMap = new HashMap();
        try{
            Integer diaryId = (Integer) json.get("diaryId");
            Integer haveSticky = (Integer) json.get("haveSticky");

            int result = diaryService.setSticky(diaryId,haveSticky);
            if (result > 0){
                rtnMap.put("data","");
                rtnMap.put("sucMsg","置顶成功");
            }
        }catch(Exception e){
            rtnMap.put("errMsg","置顶失败");
        }
        return rtnMap;
    }

    @PostMapping("/PunchCardDiary/punchCardDay")
    public Map punchCardDay(@RequestBody Map<String,Object> json,HttpServletRequest request){
        Map rtnMap = new HashMap();
        try{
            Integer projectId = (Integer) json.get("projectId");
            Integer userId = (Integer) json.get("userId");

             List<String> data = diaryService.selectPunchCardDay(userId,projectId);
             rtnMap.put("data",data);
             rtnMap.put("sucMsg","获取成功");
        }catch (Exception e){
            rtnMap.put("errMsg","获取失败");
        }
        return rtnMap;
    }

    /**
     *@Description: todo
     *@Param:
     *@return:
     *@Author: zhuxiaoxia
     */
    @PostMapping("/PunchCardDiary/getCreatorInfo")
    public Map getCreatorInfo (HttpServletRequest request,@RequestBody Map<String, Object> json){
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

    /**
     *@Description: todo中
     *@Param:
     *@return:
     *@Author: zhuxiaoxia
     */
    @PostMapping("/PunchCardDiary/getProjectIntr")
    public Map getProjectIntr (HttpServletRequest request,@RequestBody Map<String, Object> json){
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

    /**
     *@Description: todo中
     *@Param:
     *@return:
     *@Author: zhuxiaoxia
     */
    @PostMapping("/PunchCardDiary/updateName")
    public Map updateName (HttpServletRequest request,@RequestBody Map<String, Object> json){
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
