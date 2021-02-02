package com.miniprogram.service.impl;

import com.miniprogram.mapper.DiaryResourceMapper;
import com.miniprogram.service.DiaryResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (DiaryResource)表服务实现类
 *
 * @author zhuxiaoxia
 * @since 2021-01-29 10:12:49
 */
@Service("diaryResourceService")
public class DiaryResourceServiceImpl implements DiaryResourceService {
    @Resource
    private DiaryResourceMapper diaryResourceMapper;

    @Override
    public List<Map> getDiaryResource(Integer diaryId){
        return diaryResourceMapper.selectDiaryResourceByDiaryId(diaryId);
    }
}