package com.miniprogram.service.impl;

import com.miniprogram.entity.Diary;
import com.miniprogram.mapper.DiaryMapper;
import com.miniprogram.service.DiaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map selectDiaryById(Integer diaryId) {
        Map map = diaryMapper.selectDiaryById(diaryId);
        return map;
    }

    @Override
    public Map getPunchCardNum(Integer projectId) {
        return diaryMapper.selectDiaryById(projectId);
    }

    @Override
    public List selectDiaryByProject(Integer projectId) {

        return diaryMapper.selectDiaryByProject(projectId);
    }

    @Override
    public int addPunchCardDiary(Diary diary) {
        return diaryMapper.addPunchCardDiary(diary);
    }

    @Override
    public int setSticky(Integer diaryId, Integer haveSticky) {
        return diaryMapper.setSticky(diaryId,haveSticky);
    }

    @Override
    public List<Map> selectDiaryByUserIdAll(Integer userId) {
        return diaryMapper.selectDiaryByUserIdAll(userId);
    }

    @Override
    public List<Map> selectDiaryByUserIdVisible(Integer userId) {
        return diaryMapper.selectDiaryByUserIdVisible(userId);
    }

    @Override
    public int deleteDiary(Integer diaryId) {
        return diaryMapper.deleteDiaryById(diaryId);
    }


}