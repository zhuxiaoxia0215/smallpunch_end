package com.miniprogram.entity;

import java.io.Serializable;

/**
 * (DiaryResource)实体类
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:12:49
 */
public class DiaryResource implements Serializable {
    private static final long serialVersionUID = -72813697466900277L;

    private Integer id;
    /**
     * 日记id
     */
    private Integer diaryId;
    /**
     * url地址
     */
    private String resourceUrl;
    /**
     * 类型 1.图片 2.录音
     */
    private Integer type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(Integer diaryId) {
        this.diaryId = diaryId;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}