package com.miniprogram.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Visit)实体类
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:23:23
 */
public class Visit implements Serializable {
    private static final long serialVersionUID = -60583161739417444L;

    private Integer id;
    /**
     * 被访问者id
     */
    private Integer vistedId;
    /**
     * 访问者id
     */
    private Integer vistorId;
    /**
     * 访问时间
     */
    private Date creatTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVistedId() {
        return vistedId;
    }

    public void setVistedId(Integer vistedId) {
        this.vistedId = vistedId;
    }

    public Integer getVistorId() {
        return vistorId;
    }

    public void setVistorId(Integer vistorId) {
        this.vistorId = vistorId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

}