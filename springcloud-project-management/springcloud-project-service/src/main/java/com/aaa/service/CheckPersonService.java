package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.model.T_check_person;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class CheckPersonService extends BaseService<T_check_person> {

/**
 * @author: dz
 * @createtime: 2020/7/17 16:26
 * @param:
 * @desc: 分页查询抽查人员
 */

    public PageInfo<T_check_person> selectAllCheckPerson(T_check_person check_person,Integer pageNum,Integer pageSize){
        PageInfo<T_check_person> personPageInfo = super.selectListByPage(check_person, pageNum, pageSize);
        return personPageInfo;
    }

    /**
     * @author: dz
     * @createtime: 2020/7/17 16:27
     * @param:
     * @desc: 添加抽查人员
     */

    public Integer addCheckPerson(T_check_person check_person){
        Integer add = super.add(check_person);
        if (add>0 && add!=null){
            return add;
        }
        return 0;
    }

    /**
     * @author: dz
     * @createtime: 2020/7/17 16:41
     * @param:
     * @desc: 修改抽查人员
     */

    public Integer updateCheckPerson (T_check_person check_person){
        Integer update = super.update(check_person);
        if (update>0 && update!=null){
            return update;
        }
        return 0;
    }

    public Integer deleteCheckPerson(T_check_person check_person){
        Integer delete = super.delete(check_person);
        if (delete>0 && delete!=null){
            return delete;
        }
        return 0;

    }

}
