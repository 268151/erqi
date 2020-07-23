package com.aaa.controller;


import com.aaa.annotation.RoleAnnotion;
import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_role;

import com.aaa.service.RoleService;
import com.aaa.utils.ObjectUtils;
import com.aaa.vo.TreeKeys;
import org.apache.ibatis.annotations.Param;
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
public class RoleController extends CommonController<T_role> {


    @Autowired
    private RoleService roleService;

    @Override
    public BaseService<T_role> getBaseService() {
        return roleService;
    }
    /**
     * 获取角色
     * @return
     */
    @PostMapping("/getRole")
    public ResultData getRole(@RequestBody T_role  t_role){
        List<T_role> selectall = roleService.selectall(t_role);
       return reponseListStatus(selectall);
    }

    /**
     * 修改Tree
     * @param treeKeys
     * @return
     */
    @PostMapping("/updateResource")
    public ResultData updateResource(@RequestBody TreeKeys treeKeys){
        int i = roleService.updateRoleMeun(treeKeys);
        if(i>0){
            return operationSuccess();
        }

        return operationFailed();
    }

    /**
     * 获取被选节点
     * @param rid
     * @return
     */
    @GetMapping("/getCheckNode")
    public ResultData getCheckNode(@Param("rid") Integer rid){

        List<Integer> list = roleService.getcheckedNode(rid);
        if(!ObjectUtils.CollectionIsNull(list)){
            return operationSuccess(list);
        }
        return operationFailed();

    }

    @RoleAnnotion(roleName = "管理员")
    @GetMapping("/getRoleRe123")
    public ResultData getRoleRe(){

        System.out.println("123");
        return operationFailed();
    }

}
