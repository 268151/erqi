package com.aaa.controller;


import com.aaa.base.ResultData;
import com.aaa.model.T_special_post;
import com.aaa.service.IProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description: SpecialController 特殊岗位
 * @author: 彭于晏
 * @create: 2020-07-16 19:29
 **/
@Controller
public class SpecialController  {

    @Autowired
    private IProjectService iProjectService;
    @GetMapping("/getSpecial")
    public ResultData getSpecial(T_special_post tSpecialPost,Integer pageNo,Integer PageSize){
        return iProjectService.getSpecial(tSpecialPost,pageNo,PageSize);
    }

    @GetMapping("/insertSpecial")
    public ResultData insertSpecial(T_special_post tSpecialPost){
        return iProjectService.insertSpecial(tSpecialPost);
    }


    @GetMapping("/delSpecial")
    public  ResultData delSpecial(T_special_post tSpecialPost){
        return iProjectService.delSpecial(tSpecialPost);
    }


}
