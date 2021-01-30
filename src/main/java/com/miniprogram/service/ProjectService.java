package com.miniprogram.service;

import java.util.List;
import java.util.Map;

/**
 * (Project)表服务接口
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:21:45
 */
public interface ProjectService {

    List selectByUserId(Integer userId);

}