package com.miniprogram.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Comment)实体类
 *
 * @author zhuxiaoxia
 * @since 2021-02-26 10:23:53
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = 704973261821110953L;

    private Integer id;
    /**
     * 日记id
     */
    private Integer diaryId;
    /**
     * 被评论者id
     */
    private Integer respondentId;
    /**
     * 评论者id
     */
    private Integer reviewer;
    /**
     * 文本内容
     */
    private String textComment;
    /**
     * 语音内容
     */
    private String soundComment;
    /**
     * 回复时间
     */
    private Date createTime;
    /**
     * 当前评论所属的父级评论的id
     */
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

    public Integer getRespondentId() {
        return respondentId;
    }

    public void setRespondentId(Integer respondentId) {
        this.respondentId = respondentId;
    }

    public Integer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Integer reviewer) {
        this.reviewer = reviewer;
    }

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public String getSoundComment() {
        return soundComment;
    }

    public void setSoundComment(String soundComment) {
        this.soundComment = soundComment;
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