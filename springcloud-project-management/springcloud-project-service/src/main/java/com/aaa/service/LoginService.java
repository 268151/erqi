package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.base.ResultData;
import com.aaa.mapper.T_userMapper;
import com.aaa.model.T_user;
import com.aaa.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginService extends BaseService<T_user> {

    @Autowired
    private T_userMapper userMapper;

    /**
     * @author: dz
     * @createtime: 2020/7/15 16:25
     * @param: user
     * @desc: 执行登录操作
     */

    public TokenVo doLogin(T_user user){
        TokenVo tokenVo = new TokenVo();
        T_user user1 = new T_user();
        // 1.判断User是否为null
        if(null != user) {
            user1.setUsername(user.getUsername());
            T_user user2 = super.selectOne(user1);
            // 2.判断user2是否为null
            if(null == user2) {
                tokenVo.setIfSuccess(false).setType(1);
                return tokenVo;
            } else {
                // 用户名OK，查询密码
                user1.setPassword(user.getPassword());
                T_user user3 = super.selectOne(user1);
                // 3.判断user3是否为null
                if(null == user3) {
                    tokenVo.setIfSuccess(false).setType(2);
                    return tokenVo;
                } else {
                    // 登录成功
                    /**
                     *
                     * !!!!!!mybatis是无法检测连接符的，他会把连接符进行转译(\\-)
                     * 需要把连接符替换掉
                     *
                     *
                     */
                    String token = UUID.randomUUID().toString().replaceAll("-","");
                    user3.setToken(token);
                    Integer updateResult = super.update(user3);
                    if(updateResult > 0) {
                        tokenVo.setIfSuccess(true).setToken(token);
                    } else {
                        tokenVo.setIfSuccess(false).setType(4);
                        return tokenVo;
                    }
                }
            }
        } else {
            tokenVo.setIfSuccess(false).setType(4);
            return tokenVo;
        }
        return tokenVo;
    }

}
