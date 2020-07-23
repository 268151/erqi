package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.T_audit;
import com.aaa.model.T_mapping_project;
import com.aaa.model.T_mapping_unit;
import com.aaa.service.IProjectService;
import com.aaa.vo.ProjectVo;
import com.aaa.vo.SheHeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.aaa.status.ShenHeStatus.*;
import static com.aaa.status.ShenHeStatus.PROJECT_RESULT;

@RestController
public class T_auditController extends BaseController {
    @Autowired
    private IProjectService resourcesService;


    /**
     * @author: dz
     * @createtime: 2020/7/22 19:54
     * @param:
     * @desc: 查询审核记录
     */

    @PostMapping("/allaudit")
    public ResultData selectAdit( T_audit audit, Integer pageNum,  Integer pageSize){
        return resourcesService.selectAdit(audit, pageNum, pageSize);
    }


    @PostMapping("/addUpdateUnitAuditStatus")
    public ResultData addUpdateUnitAuditStatus( T_mapping_unit mapping_unit,  T_audit audit){
        SheHeVo sheHeVo=new SheHeVo();
        return resourcesService.addUpdateUnitAuditStatus(sheHeVo.setAudit(audit).setT_mapping_unit(mapping_unit));
    }


    /**
     * @author: dz
     * @createtime: 2020/7/18 10:09
     * @param:
     * @desc: 生成注册单位审核后的记录
     */
    @PostMapping("/addRegisterUnitAuditStatus")
    public ResultData addRegisterUnitAuditStatus(T_mapping_unit mapping_unit,  T_audit audit){
        SheHeVo sheHeVo=new SheHeVo();
        return resourcesService.addRegisterUnitAuditStatus(sheHeVo.setAudit(audit).setT_mapping_unit(mapping_unit));

    }

    /**
     * @author: dz
     * @createtime: 2020/7/18 15:04
     * @param:
     * @desc: 项目进度审核
     */

    @PostMapping("/addProjectFowardAuditStatus")
    public ResultData addProjectFowardAuditStatus(T_mapping_project mapping_project,T_audit audit){
        ProjectVo projectVo=new ProjectVo();
        return resourcesService.addProjectFowardAuditStatus(projectVo.setMapping_project(mapping_project).setAudit(audit));

    }

    /**
     * @author: dz
     * @createtime: 2020/7/18 15:05
     * @param:
     * @desc: 项目登记审核
     */

    @PostMapping("/addRegProjectAuditStatus")
    public ResultData addRegProjectAuditStatus(T_mapping_project mapping_project,T_audit audit){
        ProjectVo projectVo=new ProjectVo();
        return resourcesService.addRegProjectAuditStatus(projectVo.setMapping_project(mapping_project).setAudit(audit));

    }


    /**
     * @author: dz
     * @createtime: 2020/7/18 15:07
     * @param:
     * @desc: 项目成果汇交审核
     */

    @PostMapping("/addProjectResultAuditStatus")
    public ResultData addProjectResultAuditStatus(T_mapping_project mapping_project,T_audit audit){
        ProjectVo projectVo=new ProjectVo();
        return resourcesService.addProjectResultAuditStatus(projectVo.setMapping_project(mapping_project).setAudit(audit));

    }
}
