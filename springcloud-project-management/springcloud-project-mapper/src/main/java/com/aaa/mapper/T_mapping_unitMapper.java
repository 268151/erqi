package com.aaa.mapper;

import com.aaa.model.T_mapping_unit;
import tk.mybatis.mapper.common.Mapper;


import java.util.List;

public interface T_mapping_unitMapper extends Mapper<T_mapping_unit> {

    /**
     * 分页查询+根据name搜索
     * @param unitName
     * @return
     */
    List<T_mapping_unit> selectUnitList(String unitName);
}