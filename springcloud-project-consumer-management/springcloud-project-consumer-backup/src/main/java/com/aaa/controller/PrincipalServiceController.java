package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.model.T_principal;
import com.aaa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: PrincipalServiceController
 * @author: 彭于晏
 * @create: 2020-07-16 15:13
 **/
@RestController
@RequestMapping("/principal")
public class PrincipalServiceController  {
    @Autowired
    private IProjectService iProjectService;


    /**
     * 获取工人人才进行分页查询
     * @param t_principal
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("/getPrincipalAll")
    public ResultData getAllBypage1(  T_principal t_principal,  int pageNo,  int pageSize){
        return iProjectService.getAllBypage1(t_principal,pageNo,pageSize);
    }

    /**
     *添加
     * @param t_principal
     * @return
     */
    @PostMapping("/insertPrincipalall")
    public  ResultData insertPrincipalall(T_principal t_principal){
        return iProjectService.insertPrincipalall(t_principal);
    }

    /**
     * 修改    和 物理删除
     */
    @PostMapping("updatePrincipalall")
    public  ResultData updatePrincipalall(T_principal t_principal){
        return iProjectService.updatePrincipalall(t_principal);
    }

}
