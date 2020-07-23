package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.T_mapping_project;
import com.aaa.service.IProjectService;
import com.aaa.vo.MappingProjectVo;
import com.aaa.vo.ProjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MappingProjectController extends BaseController {
    @Autowired
    private IProjectService resourcesService;


    @PostMapping(value = "/addMappingProject",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultData addMappingProject(@RequestPart(value = "multipartFile",required = false) MultipartFile multipartFile,@RequestParam("refBizType") String refBizType, @RequestParam(value = "coordinateSystem") String coordinateSystem,
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
//        new ProjectVo().setMultipartFiles(multipartFile).setMapping_project(mapping_project).setRefBizType(refBizType);
        return resourcesService.addMappingProject(multipartFile,refBizType,coordinateSystem, meridian, projectType, managementLevel, fundingSource, projectName, heightDatum, entrustUnit
                , acceptUnit, projectAmount, projectLeader, mobilePhone, phone, address, startDate, endDate, acceptanceDepartment
                , acceptanceReport, projectArea, scale, sheetNumber, awardsDepartment, prizeLevel, projectQualityApproval
                , winningTime, acceptanceTime, basicContent, creditStatus, submitStatus, userId);
    }



    @PostMapping("/allProject")
    public ResultData selectProjectByPage( MappingProjectVo mappingProjectVo){
        return resourcesService.selectProjectByPage(mappingProjectVo);
    }


    @GetMapping("/selectProResultResource")
    public ResultData selelctPRR(Long id){
        return resourcesService.selelctPRR(id);
    }

    @PostMapping("/ByUserIdProject")
    public ResultData selectProjectByUserId(MappingProjectVo mappingProjectVo,Long user_id,String projectType){
        return resourcesService.selectProjectByUserId(mappingProjectVo, user_id, projectType);
    }
}
