package com.aaa.mapper;

import com.aaa.model.T_mapping_unit;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


import java.util.List;
import java.util.Map;

@Repository
public interface T_mapping_unitMapper extends Mapper<T_mapping_unit> {

    /**
     * 分页查询+根据name搜索
     * @param
     * @return
     */
   /* List<T_mapping_unit> selectUnitList(String unitName);*/

    Integer UpdateMappingScore(T_mapping_unit mapping_unit);


    Long updateScore(@Param("scorePlus") Integer scorePlus,@Param("scoreSubtract") Integer scoreSubtract,@Param("unitId") Long unitId);


    List<T_mapping_unit>getRomdan(String qu);
}