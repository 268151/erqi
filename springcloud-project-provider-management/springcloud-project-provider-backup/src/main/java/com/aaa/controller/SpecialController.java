package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_special_post;
import com.aaa.service.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: SpecialController 特殊岗位
 * @author: 彭于晏
 * @create: 2020-07-16 19:29
 **/
@RestController
public class SpecialController extends CommonController<T_special_post> {

    @Autowired
    private SpecialService specialService;

    @Override
    public BaseService<T_special_post> getBaseService() {
        return specialService;
    }

    @PostMapping("/getSpecial")
    public ResultData getSpecial(@RequestBody T_special_post tSpecialPost, Integer pageNo, Integer PageSize){
        return getAllBypage(tSpecialPost,pageNo,PageSize);
    }
    @PostMapping("/insertSpecial")
    public ResultData insertSpecial(@RequestBody T_special_post tSpecialPost){
        return reponseInsert( specialService.add(tSpecialPost));
    }

    @PostMapping("/delSpecial")
    public   ResultData delSpecial(@RequestBody T_special_post tSpecialPost){
        return reponseDel(specialService.delete(tSpecialPost));
    }


}
