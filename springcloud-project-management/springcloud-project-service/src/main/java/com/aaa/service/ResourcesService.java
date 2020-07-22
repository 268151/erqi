package com.aaa.service;


import com.aaa.mapper.T_menuMapper;
import com.aaa.model.T_menu;
import com.aaa.utils.ObjectUtils;
import com.aaa.vo.TreeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: ResourcesService
 * @author: 彭于晏
 * @create: 2020-07-14 19:18
 **/
@Service
public class ResourcesService{
    @Autowired
    private T_menuMapper resourcesMapper;

    /**
     * system菜单菜单
     */
    public List<T_menu>getSysMenu(){

        List<T_menu> sysMenu = resourcesMapper.getSysMenu(0);
        for (T_menu menu : sysMenu) {

            List<T_menu> sysMenu1 = resourcesMapper.getSysMenu(0);
            menu.setChildren(sysMenu1);
            for (T_menu t_menu : sysMenu1) {
                List<T_menu> sysMenu2 = resourcesMapper.getSysMenu(0);
                t_menu.setChildren(sysMenu2);
            }
        }
        return sysMenu;
    }


    /**
     * 通过 用户id  sys获取菜单
     * @param userid
     * @return
     */
    public List<T_menu> getResources(Integer userid){
        //          第一菜单
        List<T_menu> oneMenu = resourcesMapper.getChildMenu(userid,0);
        if(oneMenu==null&&oneMenu.size()==0){
            throw new RuntimeException("查询有误");
        }
        for (T_menu menu : oneMenu) {
            //  第二菜单
            List<T_menu> twoMenu = resourcesMapper.getChildMenu(userid,menu.getMenuId().intValue());

            if(ObjectUtils.CollectionIsNull(twoMenu)){

                for (T_menu t_menu : twoMenu) {
                    //    第三菜单
                    List<T_menu>threeMenu=resourcesMapper.getChildMenu(userid,t_menu.getMenuId().intValue());
                    t_menu.setChildren(threeMenu);
                }
                menu.setChildren(twoMenu);
            }
        }
            return oneMenu;
    }


    /**
     * 获取权限树
     */

    public List<TreeData> getTree(){
        //获取第父级节点
        List<TreeData> tree = resourcesMapper.getTree(0);
        if(tree!=null&&tree.size()>0){

            for (TreeData treeData : tree) {
                //获取二级树节点
                List<TreeData> tree1 = resourcesMapper.getTree(treeData.getId());
                treeData.setChildren(tree1);
                for (TreeData data : tree1) {
                    //获取三级树节点
                    List<TreeData> tree2 = resourcesMapper.getTree(data.getId());
                    data.setChildren(tree2);
                }
            }
        }
        return tree;

    }





}
