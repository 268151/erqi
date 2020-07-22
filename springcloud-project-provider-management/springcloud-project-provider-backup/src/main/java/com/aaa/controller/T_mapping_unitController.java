package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_mapping_unit;
import com.aaa.service.T_mapping_unitService;
import com.aaa.utils.PageInfoRandom;
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


    @GetMapping("/selectUnitList")
    public ResultData selectUnitList(T_mapping_unit mapping_unit,Integer pageNum, Integer pageSize){
        PageInfo<T_mapping_unit> tMappingUnitPageInfo = t_mapping_unitService.selectUnitList(mapping_unit,pageNum,pageSize);
        if (tMappingUnitPageInfo == null){
            return operationFailed("暂无数据");
        }
        return operationSuccess(tMappingUnitPageInfo);
    }


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
        PageInfoRandom<T_mapping_unit> pageInfo=new PageInfoRandom<>(randomUnit,pageNum,pageSize);
        return operationSuccess(pageInfo);
    }
}
