package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_mapping_unit;
import com.aaa.service.T_mapping_unitService;
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


    @GetMapping("/selectUnitList")
    public ResultData selectUnitList(@RequestParam(value = "currentPage",required = false,defaultValue = "1") Integer currentPage,
                                     @RequestParam(value = "pageSize",required = false,defaultValue = "5") Integer pageSize,String unitName){
        PageInfo<T_mapping_unit> tMappingUnitPageInfo = t_mapping_unitService.selectUnitList(currentPage,pageSize,unitName);
        if (tMappingUnitPageInfo == null){
            return operationFailed("暂无数据");
        }
        return operationSuccess(tMappingUnitPageInfo);
    }
}
