package com.miniprogram.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (AttendUser)实体类
 *
 * @author zhuxiaoxia
 * @since 2021-01-30 18:11:44
 */
public class AttendUser implements Serializable {
    private static final long serialVersionUID = -54908265346271277L;

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
     * 是否为圈主 1.是 0.否
     */
    private Integer isCreator;
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

    public Integer getIsCreator() {
        return isCreator;
    }

    public void setIsCreator(Integer isCreator) {
        this.isCreator = isCreator;
    }

    public Date getAttendTime() {
        return attendTime;
    }

    public void setAttendTime(Date attendTime) {
        this.attendTime = attendTime;
    }

}