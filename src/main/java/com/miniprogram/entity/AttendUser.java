package com.miniprogram.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (AttendUser)实体类
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 09:56:36
 */
public class AttendUser implements Serializable {
    private static final long serialVersionUID = -55317846998815533L;

    private Integer id;
    /**
     * 圈子id
     */
    private Integer projectId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 加入时间
     */
    private Date attendTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getAttendTime() {
        return attendTime;
    }

    public void setAttendTime(Date attendTime) {
        this.attendTime = attendTime;
    }

}