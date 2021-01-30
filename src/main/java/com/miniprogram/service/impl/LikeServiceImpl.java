package com.miniprogram.service.impl;

import com.miniprogram.entity.Like;
import com.miniprogram.mapper.LikeMapper;
import com.miniprogram.service.LikeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Like)表服务实现类
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:19:30
 */
@Service("likeService")
public class LikeServiceImpl implements LikeService {
    @Resource
    private LikeMapper likeMapper;

}