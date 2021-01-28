package com.miniprogram.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (UserInfo)实体类
 *
 * @author zhuxiaoxia
 * @since 2021-01-27 10:10:24
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 923893163934365432L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 微信open_id
     */
    private String openId;

    private String nickName;
    /**
     * 性别 1.男 2.女
     */
    private Integer sex;

    private Date birthday;

    private Long bgImgId;

    private String personSign;

    private String weixinNum;

    private String avatarUrl;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getBgImgId() {
        return bgImgId;
    }

    public void setBgImgId(Long bgImgId) {
        this.bgImgId = bgImgId;
    }

    public String getPersonSign() {
        return personSign;
    }

    public void setPersonSign(String personSign) {
        this.personSign = personSign;
    }

    public String getWeixinNum() {
        return weixinNum;
    }

    public void setWeixinNum(String weixinNum) {
        this.weixinNum = weixinNum;
    }

    public String getavatarUrl() {
        return avatarUrl;
    }

    public void setavatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

}