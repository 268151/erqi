package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_mapping_project;
import com.aaa.model.T_resource;
import com.aaa.service.T_mapping_projectService;
import com.aaa.service.T_resourceService;
import com.aaa.service.T_result_commitService;
import com.aaa.utils.IdWorker;
import com.aaa.vo.MappingProjectVo;
import com.github.pagehelper.PageInfo;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

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
    public ResultData selectProjectByUserId(MappingProjectVo mappingProjectVo,Long user_id,String projectType){
        try {
            PageInfo<T_mapping_project> mapping_projectByUserId = mapping_projectService.selectProjectByUserId(mappingProjectVo,user_id,projectType);
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


    /**
     * @author: dz
     * @createtime: 2020/7/20 21:35
     * @param:
     * @desc: 项目添加
     */

    @PostMapping(value = "/addMappingProject",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultData addMappingProject(T_mapping_project mapping_project, MultipartFile[] multipartFile, String refBizType){
           try{
            Long addOfResult = mapping_projectService.addMappingProject(mapping_project);
            if (addOfResult==0) {
               return insertFailed();
            }
               Boolean aBoolean = mapping_projectService.beforeToDo(multipartFile, refBizType,t_resourceService, addOfResult);
            if (aBoolean){
                return insertSuccess();
            }
           }catch (Exception e){
               e.printStackTrace();
           }

        return insertFailed();
    }
}
