package com.aaa.service;

import com.aaa.base.ResultData;
import com.aaa.model.*;
import com.aaa.vo.StatisticsVo;
import com.aaa.vo.TreeKeys;
import feign.Param;
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
@FeignClient("yangjian")
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

    @PostMapping("/getSpecial")
    public ResultData getSpecial(@RequestBody T_special_post tSpecialPost,@RequestParam("pageNo") Integer pageNo,@RequestParam("PageSize")   Integer PageSize);


    @GetMapping("/insertSpecial")
    public ResultData insertSpecial(@RequestBody T_special_post tSpecialPost);

    @GetMapping("/delSpecial")
    public   ResultData delSpecial(@RequestBody T_special_post tSpecialPost);



    //TODO 抽查


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
