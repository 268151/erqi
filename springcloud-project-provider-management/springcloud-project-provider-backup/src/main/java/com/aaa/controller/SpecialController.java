package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_special_post;
import com.aaa.service.SpecialService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description: SpecialController 特殊岗位
 * @author: 彭于晏
 * @create: 2020-07-16 19:29
 **/
@Controller
public class SpecialController extends CommonController<T_special_post> {

    private SpecialService specialService;

    @Override
    public BaseService<T_special_post> getBaseService() {
        return specialService;
    }

    @GetMapping("/getSpecial")
    public ResultData getSpecial(T_special_post tSpecialPost,Integer pageNo,Integer PageSize){
        return getAllBypage(tSpecialPost,pageNo,PageSize);
    }

    public ResultData insertSpecial(T_special_post tSpecialPost){
        return reponseInsert( specialService.add(tSpecialPost));
    }


    public   ResultData delSpecial(T_special_post tSpecialPost){
        return reponseDel(specialService.delete(tSpecialPost));
    }


}
