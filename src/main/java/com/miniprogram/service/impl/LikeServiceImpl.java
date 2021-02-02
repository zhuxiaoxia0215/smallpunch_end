package com.miniprogram.service.impl;

import com.miniprogram.entity.Like;
import com.miniprogram.mapper.LikeMapper;
import com.miniprogram.service.LikeService;
import com.miniprogram.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @Resource
    private UserInfoService userInfoService;


    @Override
    public List getLikeInfo(Integer diaryId) {

        List<Map> likeInfos= likeMapper.selectLikeByDiaryId(diaryId);
        List<Map> allLikeInfo = new ArrayList<>();
        for(Map<String,Object> likeInfo:likeInfos){
            Integer admirerId = (Integer) likeInfo.get("admirer_id");
            Map admirerMap = userInfoService.selectAdmirerById(admirerId);
            likeInfo.remove("admirer_id");
            likeInfo.put("admirer",admirerMap);
            allLikeInfo.add(likeInfo);
        }
        return allLikeInfo;
    }
}