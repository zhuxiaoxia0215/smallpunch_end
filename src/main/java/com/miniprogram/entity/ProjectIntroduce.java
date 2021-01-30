package com.miniprogram.entity;

import java.io.Serializable;

/**
 * (ProjectIntroduce)实体类
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:22:35
 */
public class ProjectIntroduce implements Serializable {
    private static final long serialVersionUID = 156764513708348341L;

    private Integer id;
    /**
     * 内容
     */
    private String content;
    /**
     * 类型 1.文本 2.图片
     */
    private Integer type;
    /**
     * 排序 0.文本 1.图片
     */
    private Integer order;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

}