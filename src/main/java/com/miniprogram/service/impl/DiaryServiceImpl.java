package com.miniprogram.service.impl;

import com.miniprogram.mapper.DiaryMapper;
import com.miniprogram.service.DiaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Diary)表服务实现类
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:11:00
 */
@Service("diaryService")
public class DiaryServiceImpl implements DiaryService {
    @Resource
    private DiaryMapper diaryMapper;

}