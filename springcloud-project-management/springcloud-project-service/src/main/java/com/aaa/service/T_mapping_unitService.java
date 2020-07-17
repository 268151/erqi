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

    public PageInfo<T_mapping_unit> selectUnitList(T_mapping_unit mapping_unit,Integer pageNum, Integer pageSize) {
        //获取分页信息，进行分页设置

        //进行查询
        PageInfo<T_mapping_unit> tMappingUnits = super.selectListByPage(mapping_unit,pageNum,pageSize);
        if (tMappingUnits.getSize() > 0 ) {
            return tMappingUnits;
        }
        return null;
    }

    /**
     * @author: dz
     * @createtime: 2020/7/16 17:15
     * @param:
     * @desc: 修改单位审核状态
     */

    public Integer updateMappingUnit(T_mapping_unit mapping_unit) {
        mapping_unit.setAuditStatus(0);
        return super.update(mapping_unit);
    }


    public Long updateScore(Integer scorePlus, Integer scoreSubtract, Long unitId) {
        Long aLong = t_mapping_unitMapper.updateScore(scorePlus, scoreSubtract, unitId);
        if (aLong != null && aLong > 0) {
            return aLong;
        }
        return null;
    }
}

