package com.miniprogram.service.impl;

import com.miniprogram.entity.Label;
import com.miniprogram.mapper.LabelMapper;
import com.miniprogram.service.LabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Label)表服务实现类
 *
 * @author zhuxiaoxia
 * @since 2021-01-31 00:16:10
 */
@Service("labelService")
public class LabelServiceImpl implements LabelService {
    @Resource
    private LabelMapper labelMapper;

    @Override
    public Map getAllTypeLabel() {
        List<Map> parentLabelList = labelMapper.selectParentLabel();
        List<Map> childLabelList = labelMapper.selectAllChildLabel();
        Map labelMap = new HashMap();
        labelMap.put("parentLabel",parentLabelList);
        labelMap.put("childLabel",childLabelList);
        return labelMap;
    }
}