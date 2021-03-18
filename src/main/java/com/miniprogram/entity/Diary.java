package com.miniprogram.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Diary)实体类
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:10:59
 */
public class Diary implements Serializable {
    private static final long serialVersionUID = 917868059792110793L;

    private Integer id;
    /**
     * 所属圈子id
     */
    private Integer projectId;
    /**
     * 发布者id
     */
    private Integer publisherId;
    /**
     * 纬度
     */
    private Double addressLatitude;
    /**
     * 经度
     */
    private Double addressLongitude;
    /**
     * 打卡天数
     */
    private Integer currDiaryPunchCardDayNum;
    /**
     * 打卡地址
     */
    private String punchCardAddress;
    /**
     * 打卡时间
     */
    private Date punchCardTime;
    /**
     * 文本内容
     */
    private String textContent;
    /**
     * 是否公开 0.公开 1.不公开
     */
    private Integer visibleType;
    /**
     * 是否为补卡 0.否 1.是
     */
    private Integer isRepairDiary;
    /**
     * 是否置顶 0.否 1.是
     */
    private Integer haveSticky;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Double getAddressLatitude() {
        return addressLatitude;
    }

    public void setAddressLatitude(Double addressLatitude) {
        this.addressLatitude = addressLatitude;
    }

    public Double getAddressLongitude() {
        return addressLongitude;
    }

    public void setAddressLongitude(Double addressLongitude) {
        this.addressLongitude = addressLongitude;
    }

    public Integer getCurrDiaryPunchCardDayNum() {
        return currDiaryPunchCardDayNum;
    }

    public void setCurrDiaryPunchCardDayNum(Integer currDiaryPunchCardDayNum) {
        this.currDiaryPunchCardDayNum = currDiaryPunchCardDayNum;
    }

    public String getPunchCardAddress() {
        return punchCardAddress;
    }

    public void setPunchCardAddress(String punchCardAddress) {
        this.punchCardAddress = punchCardAddress;
    }

    public Date getPunchCardTime() {
        return punchCardTime;
    }

    public void setPunchCardTime(Date punchCardTime) {
        this.punchCardTime = punchCardTime;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public Integer getVisibleType() {
        return visibleType;
    }

    public void setVisibleType(Integer visibleType) {
        this.visibleType = visibleType;
    }

    public Integer getIsRepairDiary() {
        return isRepairDiary;
    }

    public void setIsRepairDiary(Integer isRepairDiary) {
        this.isRepairDiary = isRepairDiary;
    }

    public Integer getHaveSticky() {
        return haveSticky;
    }

    public void setHaveSticky(Integer haveSticky) {
        this.haveSticky = haveSticky;
    }
}