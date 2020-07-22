package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_mapping_project;
import com.aaa.service.T_mapping_projectService;
import com.aaa.service.T_resourceService;
import com.aaa.service.T_result_commitService;
import com.aaa.vo.MappingProjectVo;
import com.github.pagehelper.PageInfo;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: dz
 * @createtime: 2020/7/15 20:13
 * @param:
 * @desc: 项目表
 */

@RestController
public class T_mapping_project_Controller extends CommonController<T_mapping_project> {
    @Override
    public BaseService<T_mapping_project> getBaseService() {
        return mapping_projectService;
    }

    @Autowired
    private T_mapping_projectService mapping_projectService;
    @Autowired
    private T_resourceService t_resourceService;
    @Autowired
    private T_result_commitService commitService;

    @GetMapping("/allProject")
    public ResultData selectProjectByPage(MappingProjectVo mappingProjectVo){
        try {
            PageInfo<T_mapping_project> mapping_projectPage = mapping_projectService.selectProjectByPage(mappingProjectVo);
            if (mapping_projectPage.getList().size()>0&&mapping_projectPage!=null) {
                return operationSuccess(mapping_projectPage);
            }else {
                ResultData resultData = new ResultData();
                resultData.setCode("1");
                resultData.setMsg("暂无数据");
                return resultData;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return operationFailed();
    }

    /**
     * @author: dz
     * @createtime: 2020/7/16 10:20
     * @param:
     * @desc: 项目汇总，三表查询
     */

    @GetMapping("/selectProResultResource")
    public ResultData selelctPRR(Long id){
        HashMap map=new HashMap();

        map.put("project",mapping_projectService.selectList(id));
        map.put("result",commitService.selectList(id));
        map.put("project",t_resourceService.selectList(id));

        if (map!=null&&map.size()>0){
            return operationSuccess(map);
        }
        return operationFailed();
    }




    /**
     * @author: dz
     * @createtime: 2020/7/16 16:29
     * @param:
     * @desc: 在单位模块，根据user_id查询项目信息
     */

    @GetMapping("/ByUserIdProject")
    public ResultData selectProjectByUserId(MappingProjectVo mappingProjectVo,Long user_id){
        try {
            PageInfo<T_mapping_project> mapping_projectByUserId = mapping_projectService.selectProjectByUserId(mappingProjectVo,user_id);
            if (mapping_projectByUserId.getList().size()>0&&mapping_projectByUserId!=null) {
                return operationSuccess(mapping_projectByUserId);
            }else {
                ResultData resultData = new ResultData();
                resultData.setCode("1");
                resultData.setMsg("暂无数据");
                return resultData;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return operationFailed();
    }




    @RequestMapping("/updateProject")
    public ResultData updateProject(@RequestParam Map map){
        return update(map);
    }







}
