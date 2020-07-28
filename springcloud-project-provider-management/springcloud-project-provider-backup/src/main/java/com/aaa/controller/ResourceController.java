package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.T_menu;
import com.aaa.service.ResourcesService;
import com.aaa.utils.ObjectUtils;
import com.aaa.vo.MenuVo;
import com.aaa.vo.TreeData;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @description: ResourceController
 * @author: 彭于晏
 * @create: 2020-07-14 19:40
 **/
@RestController
public class ResourceController extends BaseController {
    @Autowired
    private ResourcesService resourcesService;


    @GetMapping("/getSysMenu")
    public ResultData getSysMenu(){
        return reponseListStatus(resourcesService.getSysMenu());
    }



    /**
     * 通过id获取菜单
     * @param uid
     * @return
     */
    @GetMapping("/getMenu")
    public ResultData getMenu(@RequestParam("uid") Integer uid){
        List<MenuVo> resources = resourcesService.getResources(uid);
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("list",resources);
        return operationSuccess(objectObjectHashMap);
    }

    /**
     * 获取权限树
     * @return
     */
    @GetMapping("/getTree")
   public ResultData getTree(){
     return reponseListStatus( resourcesService.getTree());
   }





}
