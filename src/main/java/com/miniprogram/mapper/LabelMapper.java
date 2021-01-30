package com.miniprogram.mapper;

import com.miniprogram.entity.Label;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * (Label)表数据库访问层
 *
 * @author zhuxiaoxia
 * @since 2021-01-31 00:16:10
 */
@Mapper
public interface LabelMapper {

    List<Map> selectParentLabel ( );

    List<Map> selectAllChildLabel ( );

}