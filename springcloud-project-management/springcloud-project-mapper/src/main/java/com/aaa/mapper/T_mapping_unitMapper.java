package com.aaa.mapper;

import com.aaa.model.T_mapping_unit;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;


import java.util.List;

public interface T_mapping_unitMapper extends Mapper<T_mapping_unit> {

    /**
     * 分页查询+根据name搜索
     * @param unitName
     * @return
     */
   /* List<T_mapping_unit> selectUnitList(String unitName);*/


/**
 * @author: dz
 * @createtime: 2020/7/18 9:27
 * @param:
 * @desc: 修改分值
 */


    Long updateScore(@Param("scorePlus") Integer scorePlus,@Param("scoreSubtract") Integer scoreSubtract,@Param("unitId") Long unitId);


    /**
     * @author: dz
     * @createtime: 2020/7/18 11:03
     * @param:
     * @desc: 查询单位修改待审核数据
     */

    List<T_mapping_unit> selectUpdateAuditStatus(String unit_name);


    /**
     * @author: dz
     * @createtime: 2020/7/18 11:04
     * @param:
     * @desc: 查询单位注册待审核数据
     */
    List<T_mapping_unit> selectRegistAuditStatus(String unit_name);


    /**
     * @author: dz
     * @createtime: 2020/7/18 15:29
     * @param:
     * @desc: 白名单
     */

    List<T_mapping_unit> selectByWhite();


    /**
     * @author: dz
     * @createtime: 2020/7/18 15:29
     * @param:
     * @desc: 黑名单
     */

    List<T_mapping_unit> selectByBlack();



}