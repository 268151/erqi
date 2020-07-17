package com.aaa.service;

import com.aaa.base.ResultData;
import com.aaa.model.LoginLog;
import com.aaa.model.T_user;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: dz
 * @createtime: 2020/7/15 16:17
 * @param:
 * @desc:
 */
@FeignClient(value = "")
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

    /**
     * 获取菜单
     * @param uid
     * @return
     */
    @GetMapping("/getMenu")
    public ResultData getMenu(@Param("uid") Integer uid);

    /**
     * 获取权限树
     * @return
     */
    @GetMapping("/getTree")
    public ResultData getTree();





}
