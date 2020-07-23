package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.service.IProjectService;
import com.aaa.vo.DictVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class T_dictController extends BaseController {
    @Autowired
    private IProjectService iProjectService;
    @PostMapping("/alldict")
    public ResultData selectDictByPage(DictVo dictVo){

        return iProjectService.selectDictByPage(dictVo);
    }
}
