package com.miniprogram.entity;

import java.io.Serializable;

/**
 * (Like)实体类
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:14:17
 */
public class Like implements Serializable {
    private static final long serialVersionUID = -45030321579557938L;

    private Integer id;
    /**
     * 日记id
     */
    private Integer diaryId;
    /**
     * 点赞者id
     */
    private Integer admirerId;
    /**
     * 是否已读 0.未读 1.已读
     */
    private Integer isRead;


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

    public Integer getAdmirerId() {
        return admirerId;
    }

    public void setAdmirerId(Integer admirerId) {
        this.admirerId = admirerId;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

}