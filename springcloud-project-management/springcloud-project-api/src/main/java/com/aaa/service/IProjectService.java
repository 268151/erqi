package com.aaa.service;

import com.aaa.base.ResultData;
import com.aaa.model.*;

import com.aaa.vo.*;

import com.aaa.vo.StatisticsVo;
import com.aaa.vo.TreeKeys;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



/**
 * @author: dz
 * @createtime: 2020/7/15 16:17
 * @param:
 * @desc:
 */
@FeignClient("yangjiang")
public interface IProjectService {

    /**
     * @author: dz
     * @createtime: 2020/7/15 16:19
     * @param: user
     * @desc: 执行登录操作
     */

    @PostMapping("/doLogin")
    ResultData doLogin(@RequestBody T_user user);

    @PostMapping("/addLoginLog")
    Integer addLoginLog(@RequestBody LoginLog loginLog);


    //TODO 角色操作 有关角色的增删改查   权限树

    /**
     * 获取菜单
     * @param uid
     * @return
     */
    @GetMapping("/getMenu")
    public ResultData getMenu(@RequestParam("uid") Integer uid);

    /**
     * 获取权限树
     * @return
     */
    @GetMapping("/getTree")
    public ResultData getTree();


    @PostMapping("/role/getRole")
    public ResultData getRole(@RequestBody T_role t_role);

    @PostMapping("/role/updateResource")
    public ResultData updateResource(@RequestBody TreeKeys treeKeys);


    @GetMapping("/role/getCheckNode")
    public ResultData getCheckNode(@RequestParam("rid") Integer rid);

    @GetMapping("/getSysMenu")
    public ResultData getSysMenu();


    //TODO 统计图api


    @GetMapping("/getQualification")
    public ResultData getQualification();

    @GetMapping("/getNoproject")
    public ResultData getNoproject();

    @GetMapping("/getCompanyPeople")
    public ResultData getCompanyPeople(@RequestParam("uid") Integer uid);

    @GetMapping("/getSheBeiStatisticsAll")
    public ResultData getSheBeiStatisticsAll(@RequestBody StatisticsVo statisticsVo);

    //TODO  特殊人员

    @GetMapping("/getSpecial")
    public ResultData getSpecial(@RequestBody T_special_post tSpecialPost, @RequestParam("pageNo") Integer pageNo, @RequestParam("PageSize") Integer PageSize);


    @PostMapping("/insertSpecial")
    public ResultData insertSpecial(@RequestBody T_special_post tSpecialPost);

    @PostMapping("/delSpecial")
    public   ResultData delSpecial(@RequestBody T_special_post tSpecialPost);


    //TODO 项目

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
                                        @RequestParam(value = "userId") Long userId);



    @PostMapping("/allProject")
    public ResultData selectProjectByPage(@RequestBody MappingProjectVo mappingProjectVo);

    @GetMapping("/selectProResultResource")
    public ResultData selelctPRR(@RequestParam("id") Long id);

    @PostMapping("/ByUserIdProject")
    public ResultData selectProjectByUserId(@RequestBody MappingProjectVo mappingProjectVo,@RequestParam("user_id") Long user_id,@RequestParam("projectType") String projectType);
    //TODO 审核
    /**
     * @author: dz
     * @createtime: 2020/7/22 19:54
     * @param:
     * @desc: 查询审核记录
     */
    @PostMapping("/allaudit")
    public ResultData selectAdit(@RequestBody T_audit audit, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);


    @PostMapping("/addUpdateUnitAuditStatus")
    public ResultData addUpdateUnitAuditStatus(@RequestBody SheHeVo heVo);


    @PostMapping("/addRegisterUnitAuditStatus")
    public ResultData addRegisterUnitAuditStatus(@RequestBody SheHeVo sheHeVo);


    /**
     * @author: dz
     * @createtime: 2020/7/22 21:14
     * @param:
     * @desc:
     */


    @PostMapping("/addProjectFowardAuditStatus")
    public ResultData addProjectFowardAuditStatus(@RequestBody ProjectVo projectVo);

    /**
     * @author: dz
     * @createtime: 2020/7/22 21:14
     * @param:
     * @desc: 项目登记审核
     */

    @PostMapping("/addRegProjectAuditStatus")
    public ResultData addRegProjectAuditStatus(@RequestBody ProjectVo projectVo);


    /**
     * @author: dz
     * @createtime: 2020/7/22 21:14
     * @param:
     * @desc: 项目成果汇交审核
     */

    @PostMapping("/addProjectResultAuditStatus")
    public ResultData addProjectResultAuditStatus(@RequestBody ProjectVo projectVo);


    //TODO DICT

    @PostMapping("/alldict")
    public ResultData selectDictByPage(@RequestBody DictVo dictVo);


    //TODO 单位
    @PostMapping("/selectUnitList")
    public ResultData selectUnitList(@RequestBody T_mapping_unit mapping_unit,@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize);


    @PostMapping("/updateUnit")
    public ResultData updateUint(@RequestBody T_mapping_unit mapping_unit);


    @GetMapping("/selUpdateAuditStatus")
    public ResultData selUpdateAuditStatus(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize,@RequestParam("unit_name")String unit_name);

    @GetMapping("/selectRegisterAuditStatus")
    public ResultData selectRegisterAuditStatus(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize,@RequestParam("unit_name")String unit_name);

    //TODO 抽查



    @PostMapping("/selectByWhite")
    public ResultData selectByWhite(@RequestBody MappingUnitVo mappingUnitVo);

    @PostMapping("/selectByBlack")
    public ResultData selectByBlack(@RequestBody MappingUnitVo mappingUnitVo);


    @PostMapping("/allcheckperson")
    public ResultData selectCheckPersonBypage(@RequestBody T_check_person check_person, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @PostMapping("/addCheckPersons")
    public ResultData addCheckPerson(@RequestBody T_check_person check_person);

    @PostMapping("/updateCheckPersons")
    public ResultData updateCheckPerson(@RequestBody T_check_person check_person);

    @PostMapping("/delCheckPersons")
    public ResultData delCheckPerson(@RequestBody T_check_person check_person);

    @GetMapping("/getRandomUnitlimitCheck")
    public ResultData  getRandomUnitlimitCheck(@RequestParam Integer  pageNum, @RequestParam Integer pageSize);

    @GetMapping("/getRandomUnitinitCheck")
    public ResultData  getRandomUnitinitCheck(@RequestParam Double scale,@RequestParam Integer  pageNum,@RequestParam Integer pageSize);


    //TODO 特殊人才

    @PostMapping("/getPrincipalAll")
    public ResultData getAllBypage1(  @RequestBody T_principal t_principal, @RequestParam("pageNo") int pageNo,  @RequestParam("pageNo")int pageSize);

    @PostMapping("/insertPrincipalall")
    public  ResultData insertPrincipalall(@RequestBody T_principal t_principal);
    @PostMapping("updatePrincipalall")
    public  ResultData updatePrincipalall(@RequestBody T_principal t_principal);

    }

