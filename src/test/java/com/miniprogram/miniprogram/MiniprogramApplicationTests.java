package com.miniprogram.miniprogram;

import com.miniprogram.mapper.UserInfoMapper;
import com.miniprogram.mapper.UserInfoMapper;
import com.miniprogram.service.ProjectLabelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class MiniprogramApplicationTests {

    @Autowired
    ProjectLabelService projectLabelService;

    @Test
    void contextLoads() {
        Integer projectId = new Integer(11);
        List<Map<String,String>> typeLabelList = projectLabelService.selectTypeLabel(projectId);
        System.out.println(typeLabelList);
    }





}
