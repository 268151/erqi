package com.aaa.controller;

import com.aaa.annotation.LoginAnnotation;
import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.T_user;
import com.aaa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController extends BaseController {

    @Autowired
    private IProjectService iProjectService;

    /**
     * @author: dz
     * @createtime: 2020/7/15 16:11
     * @param: user
     * @desc: 登录操作
     */

    @PostMapping("/doLogin")
    @LoginAnnotation(opeationType = "登录操作",opeationName = "管理员登录")
    public ResultData doLogin(T_user user){
        return iProjectService.doLogin(user);
    }
}
