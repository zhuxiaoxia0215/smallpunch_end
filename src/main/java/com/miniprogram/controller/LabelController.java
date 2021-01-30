package com.miniprogram.controller;

import com.miniprogram.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Admin/ProjectTypeLabelManage")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping("/getAllTypeLabel")
    public Map getAllTypeLabel(HttpServletRequest request){
        Map outerMap = new HashMap();
        outerMap.put("data",labelService.getAllTypeLabel());
        outerMap.put("sucMsg","获取圈子类型标签成功");
        return outerMap;
    }
}
