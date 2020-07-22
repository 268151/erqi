package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.T_roleMapper;
import com.aaa.model.T_role;

import com.aaa.vo.TreeKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description: RoleService
 * @author: 彭于晏
 * @create: 2020-07-14 20:56
 **/
@Service
public class RoleService extends BaseService<T_role> {

    @Autowired
    private T_roleMapper roleMapper;


    /**
     * 获取所有
     * @param role
     * @return
     */
    public List<T_role> selectall(T_role role){
         return roleMapper.select(role);
    }

    /**
     * 修改 权限树 ——资源
     * @param treeKeys  添加事务
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    public int updateRoleMeun(TreeKeys treeKeys){
        if(treeKeys.getRole()!=null){
            Integer update = update(treeKeys.getRole());
        }
        int sum=0;
        int i = roleMapper.delByRoleid(treeKeys.getRoleId());
        if(i>0){
            int roleid=treeKeys.getRoleId();
            Integer[] keys = treeKeys.getKeys();
            for (Integer key : keys) {
               sum= roleMapper.InsertRoleMenu(roleid,key);
            }
        }
        return sum;
    }

    /**
     * 获取被选节点
     * @param rid
     * @return
     */
    public List<Integer> getcheckedNode(Integer rid){
        return roleMapper.getcheckedNode(rid);
    }




}
