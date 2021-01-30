package com.miniprogram.entity;

import java.io.Serializable;

/**
 * (Project)实体类
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:21:45
 */
public class Project implements Serializable {
    private static final long serialVersionUID = -31867644912755242L;

    private Integer id;
    /**
     * 圈子名称
     */
    private String projectName;
    /**
     * 背景图地址
     */
    private String coverImgUrl;
    /**
     * 创建者id
     */
    private Integer creatorId;
    /**
     * 创建者介绍
     */
    private String creatorIntroduce;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorIntroduce() {
        return creatorIntroduce;
    }

    public void setCreatorIntroduce(String creatorIntroduce) {
        this.creatorIntroduce = creatorIntroduce;
    }

}