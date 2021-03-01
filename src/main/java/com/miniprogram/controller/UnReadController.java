package com.miniprogram.controller;

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

    /**
    *@Description: todo中
    *@Param: 
    *@return: 
    *@Author: zhuxiaoxia
    */
    @PostMapping("/getUnreadNewsNum")
    public Map getUnreadNewsNum (@RequestBody Map<String,Object> json, HttpServletRequest request){
        Map rtnMap = new HashMap();
        try{
            Map data = new HashMap();
            data.put("unreadCommentNewsNum",0);
            data.put("unreadLikeNewsNum",0);
            rtnMap.put("data",data);
            rtnMap.put("sucMsg","获取未读消息成功");
        }catch (Exception e){
            rtnMap.put("errMsg",e.getMessage());
        }
        return rtnMap;
    }
}
