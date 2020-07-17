package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.T_mapping_unitMapper;
import com.aaa.model.T_mapping_unit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class T_mapping_unitService extends BaseService<T_mapping_unit> {

    @Autowired
    private T_mapping_unitMapper t_mapping_unitMapper;

    public PageInfo<T_mapping_unit> selectUnitList(Integer currentPage, Integer pageSize,String unitName){
        //获取分页信息，进行分页设置
        PageHelper.startPage(currentPage,pageSize);
        //进行查询
        List<T_mapping_unit> tMappingUnits = t_mapping_unitMapper.selectUnitList(unitName);
        if (tMappingUnits.size() > 0) {
            return new PageInfo(tMappingUnits);
        }
        return null;
    }


}
