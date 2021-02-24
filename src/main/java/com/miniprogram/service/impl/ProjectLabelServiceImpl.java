package com.miniprogram.service.impl;

import com.miniprogram.entity.ProjectLabel;
import com.miniprogram.mapper.ProjectLabelMapper;
import com.miniprogram.service.ProjectLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (ProjectLabel)表服务实现类
 *
 * @author zhuxiaoxia
 * @since 2021-02-22 17:28:19
 */
@Service("projectLabelService")
public class ProjectLabelServiceImpl implements ProjectLabelService {
    @Resource
    private ProjectLabelMapper projectLabelMapper;

    @Override
    public List<Map<String,String>> selectTypeLabel(Integer projectId) {
        String typeLabel = (String) projectLabelMapper.selectTypeLabel(projectId).get("type_label");
        String[] labelList = typeLabel.split(",") ;
        Map<String,String> labelMap = new HashMap<>();
        List<Map<String,String>> typeLabelList =new ArrayList<>();
        for(String label : labelList){
            String[] splitLabel = label.split("-");
            if(splitLabel.length<2){
                labelMap.put("parent_label","自定义");
                labelMap.put("child_label",splitLabel[0]);
            }else{
                labelMap.put("parent_label",splitLabel[0]);
                labelMap.put("child_label",splitLabel[1]);
            }
            typeLabelList.add(labelMap);
        }
        return typeLabelList;
    }

    @Override
    public int createProjectLabel(ProjectLabel projectLabel) {
        return projectLabelMapper.createProjectLabel(projectLabel);
    }
}