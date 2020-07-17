package com.aaa.mapper;

import com.aaa.model.T_menu;
import com.aaa.vo.TreeData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface T_menuMapper extends Mapper<T_menu> {


    List<T_menu> getChildMenu(@Param("userid") Integer userid, @Param("parentid") Integer parentid);


    List<T_menu>getSysMenu(Integer pid);

    /**
     * 获取权限树
     * @param pid
     * @return
     */
    @Select("select MENU_ID id,MENU_NAME label from t_menu where PARENT_ID=#{pid} ")
    List<TreeData>getTree(Integer pid);

}