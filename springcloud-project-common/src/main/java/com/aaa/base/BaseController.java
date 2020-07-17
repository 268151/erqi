package com.aaa.base;

import com.aaa.utils.ObjectUtils;
import org.springframework.stereotype.Controller;

import java.util.Collection;

import static com.aaa.status.LoginStatus.*;
import static com.aaa.status.OperationStatus.*;

/**
 * 统一controller
 * 所以的controller都需要继承这个controller，进行统一返回
 *
 * eg:
 *         登录成功和失败
 *         code:200 msg:登录成功
 *         code:400 msg:登录失败，系统异常
 *         code:201 msg:用户已经存在
 *         code:401 msg:用户不存在
 *         code:402 msg:密码错误
 *         code:405 msg:用户退出异常
 */
public class BaseController {
    /**
     * 登录成功，使用系统消息
     * @return
     */
    protected ResultData loginSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 登录成功，返回自定义消息
     * @param msg
     * @return
     */
    protected ResultData loginSuccess(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 登录成功，返回数据信息，使用系统消息
     * @param data
     * @return
     */
    protected ResultData loginSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }


    /**
     * 登录成功，返回数据信息，自定义消息
     * @param msg
     * @param data
     * @return
     */
    protected ResultData loginSuccess(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * 登录失败，使用系统消息
     * @return
     */
    protected ResultData loginFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }

    /**
     * 登录失败，使用系统消息，详细解释说明
     * @param detail
     * @return
     */
    protected ResultData loginFailed(String detail) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }



    /**
     * 用户已经存在，使用系统消息
     * @return
     */
    protected ResultData loginUser() {
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(USER_EXIST.getMsg());
        return resultData;
    }

    /**
     * 用户不存在，使用系统消息
     * @return
     */
    protected ResultData loginNotUser( ) {
        ResultData resultData = new ResultData();
        resultData.setCode(USER_NOT_EXIST.getCode());
        resultData.setMsg(USER_NOT_EXIST.getMsg());
        return resultData;
    }


    /**
     * 密码错误，使用系统消息
     * @return
     */
    protected ResultData loginPwdError( ) {
        ResultData resultData = new ResultData();
        resultData.setCode(PASSWORD_WRONG.getCode());
        resultData.setMsg(PASSWORD_WRONG.getMsg());
        return resultData;
    }



    /**
     * 用户退出异常，使用系统消息
     * @return
     */
    protected ResultData loginOutError( ) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGOUT_WRONG.getCode());
        resultData.setMsg(LOGOUT_WRONG.getMsg());
        return resultData;
    }



    /**
     * 操作成功，返回系统消息
     * @param
     * @throws
     **/
    protected ResultData operationSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      操作成功，返回系统消息
     * @param
     * @date 2020/7/9
     * @return com.aaa.lee.base.ResultData
     * @throws
     **/
    protected ResultData operationSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * 返回集合的请求
     * @param data
     * @return
     */
    protected ResultData reponseListStatus(Collection data){
        if(!ObjectUtils.CollectionIsNull(data)){
         return operationSuccess(data);
        }
        return operationFailed();
    }

    /**
     *   操作失败，返回系统消息
     * @param
     * @throws
     **/
    protected ResultData operationFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(FAILED.getMsg());
        return resultData;
    }
    /**
     * @author Seven Lee
     * @description
     *      操作失败，返回系统消息
     * @param
     * @date 2020/7/9
     * @return com.aaa.lee.base.ResultData
     * @throws
     **/
    protected ResultData operationFailed(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * 删除操作成功
     * @return
     */
    protected ResultData deleteSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_OPERATION.getCode());
        resultData.setMsg(DELETE_OPERATION.getMsg()+SUCCESS.getMsg());
        return resultData;
    }


    /**
     * 删除操作失败
     * @return
     */
    protected ResultData deleteFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_OPERATION.getCode());
        resultData.setMsg(DELETE_OPERATION.getMsg()+FAILED.getMsg());
        return resultData;
    }

    protected ResultData  reponseDel(Integer id){
        if(id!=null&&id>0){
            return  deleteSuccess();
        }
        return deleteFailed();
    }

    /**
     * 更新成功操作
     * @return
     */
    protected ResultData updateSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_OPERATION.getCode());
        resultData.setMsg(UPDATE_OPERATION.getMsg()+SUCCESS.getMsg());

        return resultData;
    }


    /**
     * 更新失败操作
     * @return
     */
    protected ResultData updateFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_OPERATION.getCode());
        resultData.setMsg(UPDATE_OPERATION.getMsg()+FAILED.getMsg());
        return resultData;
    }

    protected ResultData  reponseupdate(Integer id){
        if(id!=null&&id>0){
            return  updateSuccess();
        }
        return updateFailed();
    }
    /**
     * 新增成功操作
     * @return
     */
    protected ResultData insertSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_OPERATION.getCode());
        resultData.setMsg(INSERT_OPERATION.getMsg()+SUCCESS.getMsg());
        return resultData;
    }

    protected ResultData  reponseInsert(Integer id){
        if(id!=null&&id>0){
            return  insertSuccess();
        }
        return insertFailed();
    }

    /**
     * 新增失败操作
     * @return
     */
    protected ResultData insertFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_OPERATION.getCode());
        resultData.setMsg(INSERT_OPERATION.getMsg()+FAILED.getMsg());
        return resultData;
    }

    /**
     * 路由过滤成功操作
     * @return
     */
    protected ResultData zullSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_SUCCESS.getCode());
        resultData.setMsg(ZUUL_FILTER_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 路由过滤失败操作
     * @return
     */
    protected ResultData zullFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_FAILED.getCode());
        resultData.setMsg(ZUUL_FILTER_FAILED.getMsg());
        return resultData;
    }


    /**
     * token值存在
     * @return
     */
    protected ResultData tokenSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_SUCCESS.getCode());
        resultData.setMsg(ZUUL_FILTER_TOKEN_SUCCESS.getMsg());
        return resultData;
    }


    /**
     * token值不存在
     * @return
     */
    protected ResultData tokenFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_FAILED.getCode());
        resultData.setMsg(ZUUL_FILTER_TOKEN_FAILED.getMsg());
        return resultData;
    }

    /**
     * request对象为null
     * @return
     */
    protected ResultData requestStatus() {
        ResultData resultData = new ResultData();
        resultData.setCode(REQUEST_IS_NULL.getCode());
        resultData.setMsg(REQUEST_IS_NULL.getMsg());
        return resultData;
    }








    // TODO 代码未完善，记得补充


}
