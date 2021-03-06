package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_mapping_unit;
import com.aaa.service.T_mapping_unitService;
import com.aaa.utils.PageInfoRandom;
import com.aaa.vo.MappingUnitVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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

    @PostMapping("/selectUnitList")
    public ResultData selectUnitList(@RequestBody T_mapping_unit mapping_unit,@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize){
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
    public ResultData updateUint(@RequestBody T_mapping_unit mapping_unit){

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
    public ResultData selUpdateAuditStatus(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize")Integer pageSize,@RequestParam("unit_name")String unit_name){
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
    public ResultData selectRegisterAuditStatus(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize")Integer pageSize,@RequestParam("unit_name")String unit_name){
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

    @PostMapping("/selectByWhite")
    public ResultData selectByWhite(@RequestBody MappingUnitVo mappingUnitVo){
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

    @PostMapping("/selectByBlack")
    public ResultData selectByBlack(@RequestBody MappingUnitVo mappingUnitVo){
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
    /**
     * 抽查分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getRandomUnit")
    public ResultData  getRandomUnitlimit(@RequestParam Integer  pageNum,@RequestParam Integer pageSize){
        PageInfoRandom<T_mapping_unit> pageInfo=new PageInfoRandom(T_mapping_unitService.list,pageNum,pageSize);
        return operationSuccess(pageInfo);
    }

    /**'
     * 抽查表初始化
     * @param qu
     * @param scale
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getRandomUnitinit")
    public ResultData  getRandomUnitinit(@RequestParam String qu,@RequestParam Double scale,@RequestParam Integer  pageNum,@RequestParam Integer pageSize){
        T_mapping_unitService.setList(null);
        List<T_mapping_unit> randomUnit = t_mapping_unitService.getRandomUnit(qu, scale);
        PageInfoRandom<T_mapping_unit> pageInfo=new PageInfoRandom<T_mapping_unit>(randomUnit,pageNum,pageSize);
        return operationSuccess(pageInfo);
    }
}
