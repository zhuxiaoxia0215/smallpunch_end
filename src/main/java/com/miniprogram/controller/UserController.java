package com.miniprogram.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miniprogram.bean.OutputObject;
import com.miniprogram.entity.Project;
import com.miniprogram.entity.UserInfo;
import com.miniprogram.entity.OpenIdJson;
import com.miniprogram.service.AttendUserService;
import com.miniprogram.service.ProjectService;
import com.miniprogram.service.UserInfoService;
import com.miniprogram.utils.HttpUtil;
import com.miniprogram.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/index")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private AttendUserService attendUserService;

 /**
   * 根据code换取openid和session_key
   */
    @GetMapping("/user/getOpenId")
    public Map getOpenId(HttpServletRequest request, @RequestParam("code") String code) throws IOException {
        String appID = "wxf2f99291359f6aa8";
        String appSecret = "ec8966fbefb0b13ed7f4ed32672c99c0";
        String result = "";
        Map rtnMap = new HashMap();
        try {//请求微信服务器，用code换取openid。HttpUtil是工具类，后面会给出实现，Configure类是小程序配置信息，后面会给出代码
            String urlPath = "https://api.weixin.qq.com/sns/jscode2session?appid="
                    + appID + "&secret="
                    + appSecret + "&js_code="
                    + code
                    + "&grant_type=authorization_code";
            result = HttpUtil.doGet(urlPath, null);
            ObjectMapper mapper = new ObjectMapper();
            OpenIdJson openIdJson = mapper.readValue(result, OpenIdJson.class);
            System.out.println(result.toString());
            System.out.println();
            Map data = new HashMap();
            data.put("openid",openIdJson.getOpenid());
            rtnMap.put("openid",openIdJson.getOpenid());
            rtnMap.put("sucMsg","获取openid成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rtnMap;
    }


    /**
     *@Description:更加微信openid查询用户信息，如果没有，则将用户信息存入数据库中
     *@Param: [request, openId, nickName, avatarUrl, sex]
     *@return: java.util.Map
     *@Author: zhuxiaoxia
     */
    @GetMapping("/user/addUserInfo")
    public Map addUserInfo(HttpServletRequest request, @RequestParam("open_id") String openId,
                                    @RequestParam("nick_name") String nickName, @RequestParam("avatar_url") String avatarUrl,
                                    @RequestParam("sex") String sex){
        Map map=new HashMap<String, Object>();
        try{
            Map userInfo = userInfoService.addUserInfo(openId,nickName,avatarUrl,sex);
            map.put("userInfo", userInfo);
            return map;
        }catch(Exception e){
            map.put("data",null);
            map.put("errMsg","获取我的打卡圈子列表失败");
            return map;
        }
    }

    @RequestMapping(value = "/User/getAllProject")
    public Map getAllproject(HttpServletRequest request,@RequestBody Map<String, Object> json){

        Map outerMap =new HashMap();
        try{
            Integer userId = (Integer) json.get("userId");
            Map map = userInfoService.selectById(userId);
            map.put("punchCardProjectList",projectService.selectByUserId(userId));
            outerMap.put("data",map);
            outerMap.put("sucMsg","获取我的打卡圈子列表成功!");
        }catch(Exception e){
            outerMap.put("data",null);
            outerMap.put("errMsg","获取我的打卡圈子列表失败");
        }
        return outerMap;
    }

    @PostMapping("/User/checkUserIsAttend")
    public Map checkUserIsAttend(HttpServletRequest request,@RequestBody Map<String, Object> json){
        Map rtnMap = new HashMap();
        try{
            Integer projectId = (Integer) json.get("projectId");
            Integer userId = (Integer) json.get("userId");
            Map data = new HashMap();

            Map<String,Integer> map = attendUserService.getAttendId(userId, projectId);
            if(map != null){
                data.put("checkUserIsAttendRes",true);
            }else{
                data.put("checkUserIsAttendRes",false);
            }
            rtnMap.put("data",data);
            rtnMap.put("sucMsg","检测用户是否已参与打卡圈子成功");

        }catch (Exception e){
            rtnMap.put("data",null);
            rtnMap.put("errMsg",e.getMessage());
        }
        return rtnMap;
    }

    @PostMapping("/User/getUserPunchCardDiaryList")
    public Map getUserPunchCardDiaryList(HttpServletRequest request,@RequestBody Map<String, Object> json){
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

    @PostMapping("/User/getUserPunchCardProjectListByType")
    public Map getUserPunchCardProjectListByType(HttpServletRequest request,@RequestBody Map<String, Object> json){
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
