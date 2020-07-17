package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.T_menu;
import com.aaa.service.IProjectService;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description: ResourceController
 * @author: 彭于晏
 * @create: 2020-07-14 19:40
 **/
@RestController
public class ResourceController extends BaseController {
    @Autowired
    private IProjectService resourcesService;


    @GetMapping("/getSysMenu")
    public ResultData getSysMenu(){
        return resourcesService.getSysMenu();
    }



    /**
     * 通过id获取菜单
     * @param uid
     * @return
     */
    @GetMapping("/getMenu")
    public ResultData getMenu(@Param("uid") Integer uid){
       return resourcesService.getMenu(uid);
    }

    /**
     * 获取权限树
     * @return
     */
    @GetMapping("/getTree")
   public ResultData getTree(){
     return resourcesService.getTree();
   }





}
