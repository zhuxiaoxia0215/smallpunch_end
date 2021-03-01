package com.miniprogram.controller;

import com.miniprogram.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/Admin/ProjectTypeLabelManage")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping("/Admin/ProjectTypeLabelManage/getAllTypeLabel")
    public Map getAllTypeLabel(HttpServletRequest request){
        Map outerMap = new HashMap();
        try{
            outerMap.put("data",labelService.getAllTypeLabel());
            outerMap.put("sucMsg","获取圈子类型标签成功");
            return outerMap;
        }catch(Exception e){
            outerMap.put("data",null);
            outerMap.put("errMsg","获取圈子类型标签失败");
            return outerMap;
        }
    }

    @PostMapping("/index/ProjectTypeLabel/getChildrenLabel")
    public Map getChildrenLabel(HttpServletRequest request,@RequestBody Map<String, Object> json){
        Map rtnMap = new HashMap();
        try{
            String parentLabelName = (String) json.get("parentLabelName");
            List<Map> data = labelService.getChildrenLable(parentLabelName);
            rtnMap.put("data",data);
            rtnMap.put("sucMsg",String.format("获取%s类型的子标签成功",parentLabelName));
        }catch (Exception e){
            rtnMap.put("errMsg",e.getMessage());
        }
        return rtnMap;
    }

}
