package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.T_mapping_unitMapper;
import com.aaa.model.T_mapping_unit;
import com.aaa.vo.MappingUnitVo;
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


    /**
     * @author: dz
     * @createtime: 2020/7/18 9:03
     * @param:
     * @desc: 修改单位表中的分值
     */

    public Long updateScore(Integer scorePlus, Integer scoreSubtract, Long unitId) {
        Long aLong = t_mapping_unitMapper.updateScore(scorePlus, scoreSubtract, unitId);
        if (aLong != null && aLong > 0) {
            return aLong;
        }
        return null;
    }


    /**
     * @author: dz
     * @createtime: 2020/7/18 9:43
     * @param:
     * @desc: 查询待修改审核单位信息
     */

    public PageInfo<T_mapping_unit> selectUpdateAuditStatus(Integer pageNum,Integer pageSize,String unit_name){
        if (pageNum !=null && pageSize !=null){
            PageHelper.startPage(pageNum,pageSize);
        }

        List<T_mapping_unit> t_mapping_units = t_mapping_unitMapper.selectUpdateAuditStatus(unit_name);
        if (t_mapping_units.size()>0 && t_mapping_units!=null){
            return new PageInfo(t_mapping_units);
        }
        return null;

    }


    /**
     * @author: dz
     * @createtime: 2020/7/18 11:07
     * @param:
     * @desc: 查询注册单位审核单位信息
     */

    public PageInfo<T_mapping_unit> selectRegisterAuditStatus(Integer pageNum,Integer pageSize,String unit_name){
        if (pageNum !=null && pageSize !=null){
            PageHelper.startPage(pageNum,pageSize);
        }

        List<T_mapping_unit> t_mapping_units = t_mapping_unitMapper.selectRegistAuditStatus(unit_name);
        if (t_mapping_units.size()>0 && t_mapping_units!=null){
            return new PageInfo(t_mapping_units);
        }
        return null;

    }


    /**
     * @author: dz
     * @createtime: 2020/7/18 15:37
     * @param:
     * @desc: 白名单
     */

    public PageInfo<T_mapping_unit> selectByWhite(MappingUnitVo mappingUnitVo) throws Exception {
        if (mappingUnitVo.getPageNum()==null){
            mappingUnitVo.setPageNum(1);
        }
        if (mappingUnitVo.getPageSize()==null){
            mappingUnitVo.setPageSize(10);
        }
        PageHelper.startPage(mappingUnitVo.getPageNum(),mappingUnitVo.getPageSize());


        List<T_mapping_unit> tMappingUnitList = t_mapping_unitMapper.selectByWhite();
        if (tMappingUnitList.size()>0 && tMappingUnitList!=null){
            return new PageInfo(tMappingUnitList);
        }
        return null;

    }


    /**
     * @author: dz
     * @createtime: 2020/7/18 15:37
     * @param:
     * @desc: 黑名单
     */

    public PageInfo<T_mapping_unit> selectByBlack(MappingUnitVo mappingUnitVo) throws Exception {
        if (mappingUnitVo.getPageNum()==null){
            mappingUnitVo.setPageNum(1);
        }
        if (mappingUnitVo.getPageSize()==null){
            mappingUnitVo.setPageSize(10);
        }
        PageHelper.startPage(mappingUnitVo.getPageNum(),mappingUnitVo.getPageSize());


        List<T_mapping_unit> tMappingUnitList = t_mapping_unitMapper.selectByBlack();
        if (tMappingUnitList.size()>0 && tMappingUnitList!=null){
            return new PageInfo(tMappingUnitList);
        }
        return null;

    }


}

