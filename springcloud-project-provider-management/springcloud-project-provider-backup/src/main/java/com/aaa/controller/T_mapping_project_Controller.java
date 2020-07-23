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


    @PostMapping("/allProject")
    public ResultData selectProjectByPage(@RequestBody MappingProjectVo mappingProjectVo) {
        try {
            PageInfo<T_mapping_project> mapping_projectPage = mapping_projectService.selectProjectByPage(mappingProjectVo);
            if (mapping_projectPage.getList().size() > 0 && mapping_projectPage != null) {
                return operationSuccess(mapping_projectPage);
            } else {
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
    public ResultData selelctPRR(Long id) {
        HashMap map = new HashMap();

        map.put("project", mapping_projectService.selectList(id));
        map.put("result", commitService.selectList(id));
        map.put("project", t_resourceService.selectList(id));

        if (map != null && map.size() > 0) {
            return operationSuccess(map);
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
    public ResultData addMappingProject(@RequestPart(value = "multipartFile",required = false) MultipartFile multipartFile, @RequestParam(value = "coordinateSystem") String coordinateSystem,
                                        @RequestParam(value = "meridian") String meridian,
                                        @RequestParam(value = "projectType") String projectType,
                                        @RequestParam(value = "managementLevel") String managementLevel,
                                        @RequestParam(value = "fundingSource") String fundingSource,
                                        @RequestParam(value = "projectName") String projectName,
                                        @RequestParam(value = "heightDatum") String heightDatum,
                                        @RequestParam(value = "entrustUnit",required = false) String entrustUnit,
                                        @RequestParam(value = "acceptUnit",required = false) String acceptUnit,
                                        @RequestParam(value = "projectAmount",required = false) Double projectAmount,
                                        @RequestParam(value = "projectLeader",required = false) String projectLeader,
                                        @RequestParam(value = "mobilePhone",required = false) String mobilePhone,
                                        @RequestParam(value = "phone",required = false) String phone,
                                        @RequestParam(value = "address",required = false) String address,
                                        @RequestParam(value = "startDate") String startDate,
                                        @RequestParam(value = "endDate",required = false) String endDate,
                                        @RequestParam(value = "acceptanceDepartment",required = false) String acceptanceDepartment,
                                        @RequestParam(value = "acceptanceReport",required = false) String acceptanceReport,
                                        @RequestParam(value = "projectArea",required = false) Double projectArea,
                                        @RequestParam(value = "scale",required = false) String scale,
                                        @RequestParam(value = "sheetNumber",required = false) String sheetNumber,
                                        @RequestParam(value = "awardsDepartment",required = false) String awardsDepartment,
                                        @RequestParam(value = "prizeLevel",required = false) String prizeLevel,
                                        @RequestParam(value = "projectQualityApproval",required = false) String projectQualityApproval,
                                        @RequestParam(value = "winningTime",required = false) String winningTime,
                                        @RequestParam(value = "acceptanceTime",required = false) String acceptanceTime,
                                        @RequestParam(value = "basicContent",required = false) String basicContent,
                                        @RequestParam(value = "creditStatus",required = false) String creditStatus,
                                        @RequestParam(value = "submitStatus",required = false) String submitStatus,
                                        @RequestParam(value = "userId") Long userId){
        try{
            T_mapping_project mappingProject = new T_mapping_project();
            mappingProject.setId(new IdWorker().nextId()).setCoordinateSystem(coordinateSystem).setMeridian(meridian).setProjectType(projectType).setManagementLevel(managementLevel).setFundingSource(fundingSource).setProjectName(projectName)
                    .setEntrustUnit(entrustUnit).setAcceptUnit(acceptUnit).setProjectAmount(projectAmount).setProjectLeader(projectLeader).setMobilePhone(mobilePhone).setPhone(phone).setAddress(address).setStartDate(startDate).setEndDate(endDate)
                    .setAcceptanceDepartment(acceptanceDepartment).setAcceptanceReport(acceptanceReport).setProjectArea(projectArea).setScale(scale).setSheetNumber(sheetNumber).setAwardsDepartment(awardsDepartment).setPrizeLevel(prizeLevel)
                    .setProjectQualityApproval(projectQualityApproval).setWinningTime(winningTime).setAcceptanceTime(acceptanceTime).setBasicContent(basicContent).setCreditStatus(creditStatus).setSubmitStatus(submitStatus).setUserId(userId);
            Long addOfResult = mapping_projectService.addMappingProject(mappingProject);
            if (addOfResult==0) {
                return insertFailed();
            }
            Boolean aBoolean = mapping_projectService.beforeToDo(multipartFile,t_resourceService, addOfResult);
            if (aBoolean){
                return insertSuccess();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return insertFailed();
    }
}
