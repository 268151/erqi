package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.model.T_check_person;

import com.aaa.utils.ObjectUtils;
import com.aaa.utils.RandomList;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckPersonService extends BaseService<T_check_person> {
    public static List<T_check_person> listcheck;

    public static void setListcheck(List<T_check_person> listcheck) {
        CheckPersonService.listcheck = listcheck;
    }


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
    /**
     * 随机抽查的人
     * @param scale
     * @return
     */
    public List<T_check_person> RandomPerson(Double scale){
        if(ObjectUtils.CollectionIsNull(listcheck)) {
            T_check_person tperson=new T_check_person();
            List<T_check_person> romdan = selectList(tperson);
            if (ObjectUtils.CollectionIsNull(romdan)) {
                return null;
            }
            listcheck= RandomList.randomList(scale,romdan);
        }
        return listcheck;
    }

}
