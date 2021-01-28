package com.miniprogram.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miniprogram.bean.OutputObject;
import com.miniprogram.entity.UserInfo;
import com.miniprogram.entity.OpenIdJson;
import com.miniprogram.service.UserInfoService;
import com.miniprogram.utils.HttpUtil;
import com.miniprogram.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/index/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

 /**
   * 根据code换取openid和session_key
   */
    @GetMapping("getOpenId")
    public String getOpenId(HttpServletRequest request, @RequestParam("code") String code) throws IOException {
        String appID = "wxf2f99291359f6aa8";
        String appSecret = "ec8966fbefb0b13ed7f4ed32672c99c0";
        String result = "";
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
            System.out.println(openIdJson.getOpenid());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     *@Description:更加微信openid查询用户信息，如果没有，则将用户信息存入数据库中
     *@Param: [request, openId, nickName, avatarUrl, sex]
     *@return: java.util.Map
     *@Author: zhuxiaoxia
     */
    @GetMapping("/addUserInfo")
    public Map addUserInfo(HttpServletRequest request, @RequestParam("open_id") String openId,
                                    @RequestParam("nick_name") String nickName, @RequestParam("avatar_url") String avatarUrl,
                                    @RequestParam("sex") String sex){
        UserInfo userInfo = userInfoService.addUserInfo(openId,nickName,avatarUrl,sex);
        Map map=new HashMap<String, Object>();
        map.put("userInfo", userInfo);
        return map;
    }



}
