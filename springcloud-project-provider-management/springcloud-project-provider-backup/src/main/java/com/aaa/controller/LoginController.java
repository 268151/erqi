package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.T_user;
import com.aaa.service.LoginService;
import com.aaa.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.aaa.status.LoginStatus.*;

@RestController
public class LoginController extends CommonController<T_user> {
    @Autowired
    private LoginService loginService;

    @Override
    public BaseService<T_user> getBaseService() {
        return loginService;
    }

    /**
     * @author: dz
     * @createtime: 2020/7/15 16:23
     * @param: user
     * @desc: 执行登录操作
     */

    @PostMapping("/doLogin")
    public ResultData doLogin(@RequestBody T_user user){
        TokenVo tokenVo=loginService.doLogin(user);
        System.out.println(111);
        if(tokenVo.getIfSuccess()) {
            return super.loginSuccess(tokenVo.getToken());
        } else if(tokenVo.getType() == 1) {
            return super.loginFailed(USER_NOT_EXIST.getMsg());
        } else if(tokenVo.getType() == 2) {
            return super.loginFailed(PASSWORD_WRONG.getMsg());
        } else {
            return super.loginFailed(SYSTEM_EXCEPTION.getMsg());
        }
    }


}
