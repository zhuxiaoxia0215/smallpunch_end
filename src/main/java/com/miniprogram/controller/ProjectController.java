package com.miniprogram.controller;

import com.miniprogram.entity.Project;
import com.miniprogram.entity.ProjectLabel;
import com.miniprogram.mapper.ProjectLabelMapper;
import com.miniprogram.service.AttendUserService;
import com.miniprogram.service.ProjectIntroduceService;
import com.miniprogram.service.ProjectLabelService;
import com.miniprogram.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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
    @Resource
    private ProjectLabelService projectLabelService;
    @Resource
    private AttendUserService attendUserService;
    @Resource
    private ProjectIntroduceService projectIntroduceService;

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

            ProjectLabel projectLabel =new ProjectLabel();
            projectLabel.setProjectId(projectId);
            projectLabel.setTypeLabel(typeLabel);
            projectLabelService.createProjectLabel(projectLabel);

            Map<String,Integer> map = new HashMap<>();
            map.put("id",projectId);
            outerMap.put("data",map);
            outerMap.put("sucMsg","创建打卡圈子成功");

        }catch(Exception e){
            outerMap.put("data",null);
            outerMap.put("errMsg",e.getMessage());
        }
        return outerMap;
    }

    @PostMapping("/getProjectInfoById")
    public Map getProjectInfoById (HttpServletRequest request, @RequestBody Map<String, Object> json){
        Map rtnMap = new HashMap();
        try{
            Integer projectId = (Integer)json.get("projectId");
            Integer userId = (Integer)json.get("userId");
            Map projectMap = projectService.getProjectInfoById(projectId);
            List<Map> attendUserList =attendUserService.getAttendUser(projectId);
            projectMap.put("attendUserList",attendUserList);
            projectMap.put("attend_user_num",attendUserList.size());
            projectMap.put("projectIntrInfo",projectIntroduceService.getProjectIntr(projectId));

            rtnMap.put("data",projectMap);
            rtnMap.put("sucMsg","获取打卡圈子信息成功");

        }catch(Exception e){
            rtnMap.put("data",null);
            rtnMap.put("errMsg",e.getMessage());
        }
        return rtnMap;
    }


}