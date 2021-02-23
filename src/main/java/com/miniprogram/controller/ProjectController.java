package com.miniprogram.controller;

import com.miniprogram.entity.Project;
import com.miniprogram.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * (Project)表控制层
 *
 * @author zhuxiaoxia
 * @since 2021-02-23 09:28:37
 */
@RestController
@RequestMapping("/index/PunchCardProject")
public class ProjectController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectService projectService;

    @PostMapping("/create")
    public Map createProject (HttpServletRequest request, @RequestBody Map<String, Object> json){
        Map outerMap =new HashMap();
        try{
            Integer creatorId = (Integer)json.get("creator_id");
            Integer privacyType = (Integer)json.get("privacy_type");
            String projectName = (String) json.get("project_name");
            String typeLabel = (String) json.get("type_label");

            Project project = new Project();
            project.setProjectName(projectName);
            project.setCreatorId(creatorId);
            project.setPrivacyType(privacyType);

            projectService.createProject(project);
            Integer projectId =project.getId();

            Map<String,Object> map = new HashMap<>();
            map.put("id",projectId);
            outerMap.put("data",map);
            outerMap.put("sucMsg","创建打卡圈子成功");


        }catch(Exception e){

        }
        return outerMap;
    }

}