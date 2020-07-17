package com.aaa.mapper;

import com.aaa.model.T_role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface T_roleMapper extends Mapper<T_role> {

    /**
     * 删除所有角色id有关的id
     * @param roleid
     * @return
     */
    @Delete("delete from t_role_menu where ROLE_ID =#{roleid}")
    int delByRoleid(Integer roleid);

    /**
     * 添加角色有关的支援
     * @param roleid
     * @param menuid
     * @return
     */
    @Insert("insert into t_role_menu values (#{roleid},#{mentid})")
    int InsertRoleMenu(@Param("roleid") Integer roleid, @Param("mentid") Integer menuid);

    /**
     * 获取权限树被选中的id
     * @param rid
     * @return
     */
    @Select(" select MENU_ID from t_role_menu where ROLE_ID=#{rid} ")
     List<Integer> getcheckedNode(Integer rid);

}