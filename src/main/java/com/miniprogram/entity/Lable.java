package com.miniprogram.entity;

import java.io.Serializable;

/**
 * (Lable)实体类
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:13:28
 */
public class Lable implements Serializable {
    private static final long serialVersionUID = -35110193467571226L;

    private Integer id;
    /**
     * 父标签id
     */
    private Integer parentId;
    /**
     * 标签名称
     */
    private String lableName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getLableName() {
        return lableName;
    }

    public void setLableName(String lableName) {
        this.lableName = lableName;
    }

}