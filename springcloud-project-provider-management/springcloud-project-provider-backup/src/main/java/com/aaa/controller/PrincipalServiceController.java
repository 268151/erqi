package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_principal;
import com.aaa.service.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @description: PrincipalServiceController
 * @author: 彭于晏
 * @create: 2020-07-16 15:13
 **/
@RestController
@RequestMapping("/principal")
public class PrincipalServiceController  extends CommonController<T_principal> {
    @Autowired
    private PrincipalService principalService;
    @Override
    public BaseService<T_principal> getBaseService() {
        return principalService;
    }

    /**
     * 获取工人人才进行分页查询
     * @param t_principal
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("/getPrincipalAll")
    public ResultData getAllBypage1(  @RequestBody T_principal t_principal, @RequestParam("pageNo") int pageNo,  @RequestParam("pageNo")int pageSize){
        return getAllBypage(t_principal,pageNo,pageSize);
    }

    /**
     *添加
     * @param t_principal
     * @return
     */
    @PostMapping("/insertPrincipalall")
    public  ResultData insertPrincipalall(@RequestBody T_principal t_principal){
        return reponseupdate(principalService.add(t_principal));
    }

    /**
     * 修改    和 物理删除
     */
    @PostMapping("updatePrincipalall")
    public  ResultData updatePrincipalall(T_principal t_principal){
        return reponseupdate(principalService.update(t_principal));
    }

}
