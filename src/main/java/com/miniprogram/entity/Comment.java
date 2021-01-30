package com.miniprogram.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Comment)实体类
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 09:59:15
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = 144527876563243536L;

    private Integer id;
    /**
     * 日记id
     */
    private Integer diaryId;
    /**
     * 评论者id
     */
    private Integer reviewer;
    /**
     * 回复时间
     */
    private Date createTime;

    private Integer pid;
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

    public Integer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Integer reviewer) {
        this.reviewer = reviewer;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

}