package com.aaa.mapper;



import com.aaa.model.T_menu;
import com.aaa.vo.TreeData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @description: ResourcesMapper
 * @author: 彭于晏
 * @create: 2020-07-14 16:59
 **/
@Repository
public interface ResourcesMapper {

    /**
     * 获取一级菜单
     * @param userid
     * @return
     */
    @Select("select tm.* from " +
            "t_user_role ur left join t_role_menu rm on ur.ROLE_ID=rm.ROLE_ID " +
            "join t_menu tm on tm.MENU_ID =rm.MENU_ID " +
            "where tm.PARENT_ID=0 and ur.USER_ID=#{userid}  ")
    List<T_menu>getOneMenu(Integer userid);

    /**
     * 获取子级菜单
     * @param userid
     * @param parentid
     * @return
     */
    @Select("select tm.* from " +
            "t_user_role ur left join t_role_menu rm on ur.ROLE_ID=rm.ROLE_ID " +
            "join t_menu tm on tm.MENU_ID =rm.MENU_ID " +
            "where tm.PARENT_ID=#{parentid} and ur.USER_ID=#{userid}  ")
    List<T_menu>getChildMenu(@Param("userid") Integer userid, @Param("parentid") Integer parentid);

    /**
     * 获取权限树
     * @param pid
     * @return
     */
    @Select("select MENU_ID id,MENU_NAME label from t_menu where PARENT_ID=#{pid} ")
    List<TreeData>getTree(Integer pid);

}
