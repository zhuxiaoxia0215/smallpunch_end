package com.miniprogram.service.impl;


import com.miniprogram.mapper.CommentMapper;
import com.miniprogram.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Comment)表服务实现类
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 09:59:16
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

}