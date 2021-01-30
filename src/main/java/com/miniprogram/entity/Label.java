package com.miniprogram.entity;

import java.io.Serializable;

/**
 * (Label)实体类
 *
 * @author zhuxiaoxia
 * @since 2021-01-31 00:16:10
 */
public class Label implements Serializable {
    private static final long serialVersionUID = 796998679966254148L;

    private Integer id;
    /**
     * 父标签id
     */
    private Integer parentId;
    /**
     * 标签名称
     */
    private String labelName;


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

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

}