package com.miniprogram.service;

import com.miniprogram.entity.ProjectLabel;

import java.util.List;
import java.util.Map;

/**
 * (ProjectLabel)表服务接口
 *
 * @author zhuxiaoxia
 * @since 2021-02-22 17:28:19
 */
public interface ProjectLabelService {

    List<Map<String,String>> selectTypeLabel (Integer projectId);


    int createProjectLabel (ProjectLabel projectLabel);

}