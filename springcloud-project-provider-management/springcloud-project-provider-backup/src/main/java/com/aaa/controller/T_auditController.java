package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_audit;
import com.aaa.model.T_mapping_project;
import com.aaa.model.T_mapping_unit;
import com.aaa.service.T_auditService;
import com.aaa.service.T_mapping_projectService;
import com.aaa.service.T_mapping_unitService;
import com.aaa.utils.DateUtils;
import com.aaa.utils.FileNameUtils;
import com.aaa.vo.ProjectVo;
import com.aaa.vo.SheHeVo;
import com.aaa.vo.T_auditVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static com.aaa.status.ShenHeStatus.*;

@RestController
public class T_auditController extends CommonController<T_audit> {
    @Override
    public BaseService<T_audit> getBaseService() {
        return auditService;
    }

    @Autowired
    private T_auditService auditService;
    @Autowired
    private T_mapping_unitService mapping_unitService;
    @Autowired
    private T_mapping_projectService mapping_projectService;

    /**
     * @author: dz
     * @createtime: 2020/7/18 9:54
     * @param:
     * @desc: 查询审核记录
     */

    @PostMapping("/allaudit")
    public ResultData selectAdit(@RequestBody T_audit audit, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        try {

        PageInfo<T_audit> auditPageInfo = auditService.selectAuditByPage(audit, pageNum,pageSize);
        if (auditPageInfo.getList().size()>0&&auditPageInfo!=null) {
            return operationSuccess(auditPageInfo);
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
     * @createtime: 2020/7/18 10:09
     * @param:
     * @desc: 生成修改单位审核后的记录
     */
    @PostMapping("/addUpdateUnitAuditStatus")
    public ResultData addUpdateUnitAuditStatus(@RequestBody SheHeVo sheHeVo){
        return commontsehe1(sheHeVo.getT_mapping_unit(),sheHeVo.getAudit(),UNIT_SHEHE.getName(),UNIT_SHEHE.getType());



    }



    /**
     * @author: dz
     * @createtime: 2020/7/18 10:09
     * @param:
     * @desc: 生成注册单位审核后的记录
     */
    @PostMapping("/addRegisterUnitAuditStatus")
    public ResultData addRegisterUnitAuditStatus(@RequestBody SheHeVo sheHeVo){
      return commontsehe1(sheHeVo.getT_mapping_unit(),sheHeVo.getAudit(),REGUNIT_SHEHE.getName(),REGUNIT_SHEHE.getType());

    }

    /**
     * @author: dz
     * @createtime: 2020/7/18 15:04
     * @param:
     * @desc: 项目进度审核
     */
    
    @PostMapping("/addProjectFowardAuditStatus")
    public ResultData addProjectFowardAuditStatus(@RequestBody ProjectVo projectVo){
        return commontsehe2(projectVo.getMapping_project(),projectVo.getAudit(),PROJECT_FORWARD.getName(),PROJECT_FORWARD.getType());

    }

    /**
     * @author: dz
     * @createtime: 2020/7/18 15:05
     * @param:
     * @desc: 项目登记审核
     */

    @PostMapping("/addRegProjectAuditStatus")
    public ResultData addRegProjectAuditStatus(@RequestBody ProjectVo projectVo){
        return commontsehe2(projectVo.getMapping_project(),projectVo.getAudit(),REGPROJECT_SHENHE.getName(),REGPROJECT_SHENHE.getType());

    }


    /**
     * @author: dz
     * @createtime: 2020/7/18 15:07
     * @param:
     * @desc: 项目成果汇交审核
     */

    @PostMapping("/addProjectResultAuditStatus")
    public ResultData addProjectResultAuditStatus(@RequestBody ProjectVo projectVo){
        return commontsehe2(projectVo.getMapping_project(),projectVo.getAudit(),PROJECT_RESULT.getName(),PROJECT_RESULT.getType());

    }


    /**
     * @author: dz
     * @createtime: 2020/7/18 11:29
     * @param:
     * @desc: 单位通用审核方法
     */

    public ResultData commontsehe1(T_mapping_unit mapping_unit,T_audit audit,String Name,Integer type){
        Integer integer = mapping_unitService.updateMappingUnit(mapping_unit);
        if (integer>0) {
            T_mapping_unit mapping_unit1 = mapping_unitService.selectOne(mapping_unit);
            audit.setId(Long.valueOf(FileNameUtils.getFileName()));
            audit.setName(Name);
            audit.setType(type);

            audit.setUserId(mapping_unit1.getUserId());
            audit.setStatus(0);
            audit.setCreateTime(DateUtils.getCurrentDate());

            audit.setSubmitTime(mapping_unit1.getCreateTime());
            Integer integer1 = auditService.addAuditStatus(audit.getId(), audit.getName(), audit.getType(), audit.getUserId(), audit.getStatus(), audit.getSubmitTime(), audit.getAuditTime(), mapping_unit.getId(), audit.getCreateTime());
            return reponseInsert(integer1);
        }
        return operationFailed();
    }



    /**
     * @author: dz
     * @createtime: 2020/7/18 15:12
     * @param:
     * @desc: 项目通用审核方法
     */

    public ResultData commontsehe2(T_mapping_project mapping_project, T_audit audit, String Name, Integer type){
        Integer integer = mapping_projectService.updateMappingProject(mapping_project);
        if (integer>0) {
            T_mapping_project mapping_project1 = mapping_projectService.selectOne(mapping_project);
            audit.setId(Long.valueOf(FileNameUtils.getFileName()));
            audit.setName(Name);
            audit.setType(type);

            audit.setUserId(mapping_project1.getUserId());
            audit.setStatus(0);
            audit.setCreateTime(DateUtils.getCurrentDate());

            audit.setAuditTime(mapping_project1.getCreateTime());
            Integer integer1 = auditService.addAuditStatus(audit.getId(), audit.getName(), audit.getType(), audit.getUserId(), audit.getStatus(), audit.getSubmitTime(), audit.getAuditTime(), mapping_project.getId(), audit.getCreateTime());
            return reponseInsert(integer1);
        }
        return operationFailed();
    }



}
