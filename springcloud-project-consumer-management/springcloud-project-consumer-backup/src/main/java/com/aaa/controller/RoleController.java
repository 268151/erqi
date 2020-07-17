package com.aaa.controller;


import com.aaa.base.ResultData;
import com.aaa.model.T_role;
import com.aaa.service.IProjectService;

import com.aaa.vo.TreeKeys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: RoleController
 * @author: 彭于晏
 * @create: 2020-07-14 20:57
 **/
@RestController
@RequestMapping("/role")
public class RoleController  {

    @Autowired
    private IProjectService iProjectService;


    /**
     * 获取角色
     * @return
     */
    @PostMapping("/getRole")
    public ResultData getRole(T_role  t_role){
      return iProjectService.getRole(t_role);
    }

    /**
     * 修改Tree
     * @param treeKeys
     * @return
     */
    @PostMapping("/updateResource")
    public ResultData updateResource(@RequestBody TreeKeys treeKeys){

       return iProjectService.updateResource(treeKeys);
    }

    /**
     * 获取被选节点
     * @param rid
     * @return
     */
    @GetMapping("/getCheckNode")
    public ResultData getCheckNode( Integer rid){
        return iProjectService.getCheckNode(rid);
    }





}
