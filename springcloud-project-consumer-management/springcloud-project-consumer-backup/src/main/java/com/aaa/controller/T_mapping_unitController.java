package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.T_mapping_unit;
import com.aaa.service.IProjectService;
import com.aaa.vo.MappingUnitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class T_mapping_unitController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    @PostMapping("/selectUnitList")
    public ResultData selectUnitList(T_mapping_unit mapping_unit, Integer pageNum, Integer pageSize){
        return iProjectService.selectUnitList(mapping_unit, pageNum, pageSize);
    }

    @PostMapping("/updateUnit")
    public ResultData updateUint( T_mapping_unit mapping_unit){
        return iProjectService.updateUint(mapping_unit);
    }


    @GetMapping("/selUpdateAuditStatus")
    public ResultData selUpdateAuditStatus(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize, @RequestParam("unit_name")String unit_name){
        return iProjectService.selUpdateAuditStatus(pageNum, pageSize, unit_name);
    }

    @GetMapping("/selectRegisterAuditStatus")
    public ResultData selectRegisterAuditStatus(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize, @RequestParam("unit_name")String unit_name){
        return iProjectService.selectRegisterAuditStatus(pageNum, pageSize, unit_name);
    }


    @PostMapping("/selectByWhite")
    public ResultData selectByWhite( MappingUnitVo mappingUnitVo){
        return iProjectService.selectByWhite(mappingUnitVo);
    }

    @PostMapping("/selectByBlack")
    public ResultData selectByBlack( MappingUnitVo mappingUnitVo){
        return iProjectService.selectByBlack(mappingUnitVo);

    }
}
