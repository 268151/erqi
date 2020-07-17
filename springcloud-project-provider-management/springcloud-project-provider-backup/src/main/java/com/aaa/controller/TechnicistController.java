package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_technicist;
import com.aaa.service.TechnicistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: TechnicistController
 * @author: 彭于晏
 * @create: 2020-07-16 20:04
 **/
@Service
public class TechnicistController extends CommonController<T_technicist> {

    @Autowired
    private TechnicistService technicistService;
    @Override
    public BaseService<T_technicist> getBaseService() {
        return technicistService;
    }


    public ResultData getTechnicist(T_technicist tTechnicist ,Integer PageNum,Integer PageSize){
        return getAllBypage(tTechnicist,PageNum,PageSize);
    }


    public ResultData inserTechnicist(T_technicist tTechnicist){
        return reponseInsert(technicistService.add(tTechnicist));
    }


    public ResultData updateTechnicist(T_technicist tTechnicist){

        return reponseupdate(technicistService.update(tTechnicist));
    }
}
