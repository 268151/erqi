package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_mapping_unit;
import com.aaa.service.T_mapping_unitService;
import com.aaa.vo.MappingUnitVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class T_mapping_unitController extends CommonController<T_mapping_unit> {
    @Autowired
    private T_mapping_unitService t_mapping_unitService;

    @Override
    public BaseService<T_mapping_unit> getBaseService() {
        return t_mapping_unitService;
    }


    /**
     * @author: dz
     * @createtime: 2020/7/18 9:05
     * @param:
     * @desc: c
     * 查询所有单位信息
     */

    @GetMapping("/selectUnitList")
    public ResultData selectUnitList(T_mapping_unit mapping_unit,Integer pageNum, Integer pageSize){
        PageInfo<T_mapping_unit> tMappingUnitPageInfo = t_mapping_unitService.selectUnitList(mapping_unit,pageNum,pageSize);
        if (tMappingUnitPageInfo == null){
            return operationFailed("暂无数据");
        }
        return operationSuccess(tMappingUnitPageInfo);
    }


    /**
     * @author: dz
     * @createtime: 2020/7/18 9:05
     * @param:
     * @desc: 修改单位状态（审核）
     */

    @PostMapping("/updateUnit")
    public ResultData updateUint(T_mapping_unit mapping_unit){

        Integer i = t_mapping_unitService.updateMappingUnit(mapping_unit);
        if (i>0){
            return operationSuccess();
        }else {
            return operationFailed();
        }
    }


    /**
     * @author: dz
     * @createtime: 2020/7/18 15:39
     * @param:
     * @desc: 查询待修改审核单位信息
     */

    @GetMapping("/selUpdateAuditStatus")
    public ResultData selUpdateAuditStatus(Integer pageNum,Integer pageSize,String unit_name){
        PageInfo<T_mapping_unit> mappingUnitPageInfo = t_mapping_unitService.selectUpdateAuditStatus(pageNum, pageSize, unit_name);
        if (mappingUnitPageInfo!=null){
            return operationSuccess(mappingUnitPageInfo);
        }
        return operationFailed();
    }



    /**
     * @author: dz
     * @createtime: 2020/7/18 15:40
     * @param:
     * @desc: 查询注册单位审核单位信息
     */

    @GetMapping("/selectRegisterAuditStatus")
    public ResultData selectRegisterAuditStatus(Integer pageNum,Integer pageSize,String unit_name){
        PageInfo<T_mapping_unit> mappingUnitPageInfo = t_mapping_unitService.selectRegisterAuditStatus(pageNum, pageSize, unit_name);
        if (mappingUnitPageInfo!=null){
            return operationSuccess(mappingUnitPageInfo);
        }
        return operationFailed();
    }


    /**
     * @author: dz
     * @createtime: 2020/7/18 15:43
     * @param:
     * @desc: 查询白名单
     */

    @GetMapping("/selectByWhite")
    public ResultData selectByWhite(MappingUnitVo mappingUnitVo){
        try {
            PageInfo<T_mapping_unit> unitPageInfo = t_mapping_unitService.selectByWhite(mappingUnitVo);
        if (unitPageInfo!=null && unitPageInfo.getSize()>0){
            return operationSuccess(unitPageInfo);
        }else {
            return operationFailed("暂无数据");
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return operationFailed();

    }



    /**
     * @author: dz
     * @createtime: 2020/7/18 15:43
     * @param:
     * @desc: 查询白名单
     */

    @GetMapping("/selectByBlack")
    public ResultData selectByBlack(MappingUnitVo mappingUnitVo){
        try {
            PageInfo<T_mapping_unit> unitPageInfo = t_mapping_unitService.selectByBlack(mappingUnitVo);
            if ( unitPageInfo!=null && unitPageInfo.getSize()>0){
                return operationSuccess(unitPageInfo);
            }else {
                return operationFailed("暂无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return operationFailed();

    }
}
