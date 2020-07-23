package com.aaa.mapper;

import com.aaa.vo.StatisticsVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: 彭于晏
 * @create: 2020-07-15 18:50
 **/
@Repository
public interface StatisticsMapper {

    /**
     * 统计图 1.1  单位资质统计
     */
    @Select("select qualification_level name, count(1)  value from  t_mapping_unit  group by  qualification_level")
    List<Map<String ,Object>> getQualification();

    /**
     * 统计图1.2 查询未完成成功的
     */
    @Select("select CONCAT_WS('','未完成',project_type) name,  count(1) value from t_mapping_project where status=2  group by project_type")
    List<Map<String ,Object>> getNoproject();

    /**
     * 统计图1.2 查询未完成成功的
     */
    @Select("select CONCAT_WS('','已完成',project_type) name,  count(1) value from t_mapping_project where status=3  group by project_type")
    List<Map<String ,Object>> getYesproject();

    /**
     * 统计图2.1 查询该公司的人员 人员统计
     */
    @Select("select  count(1) value,tt.major_type name from t_mapping_unit tu join  t_technicist tt on tu.user_id =tt.user_id  where tt.user_id=#{userid}  group by tt.major_type ")
    List<Map<String ,Object>> getCompanyPeople(Integer userid);

    /**
     * 统计图2.2 查询该公司的设备类型
     */

    @Select("select  count(1) value,te.name  name from t_mapping_unit tu join  t_equipment te on tu.user_id =te.user_id group by te.name where tt.user_id=#{userid}")
    List<Map<String ,Object>> getCompanyShebei(Integer userid);

    @Select("select ('特殊人员') name,count(1)  value from t_special_post where user_id= #{userid}")
    List<Map<String,Object>> getCompanySpe(Integer  userid);

    @Select("select ('项目数量') name, count(1)value   from t_mapping_project where user_id = #{userid}")
    List<Map<String,Object>> getCompanyPro(Integer  userid);

    /**
     * 统计图3.1 这个查询不同等级的人员统计
     */
//    @Select("select  count(1) value,tu.qualification_level ," +
//            "tt.major_type from t_mapping_unit tu join  t_technicist tt " +
//            "on tu.user_id =tt.user_id group by tu.qualification_level ,tt.major_type")
    List<Map<String,Object>> getPersonnelStatistics(StatisticsVo statisticsVo);

    /**
     * 统计图3.2  查询不同等级的设备
     */
//    @Select("select  count(*) value ,tu.qualification_level ,te.name from t_mapping_unit tu join " +
//            " t_equipment te on tu.user_id =te.user_id group by tu.qualification_level ,te.name")
    List<Map<String,Object>> getSheBeiStatistics(StatisticsVo statisticsVo);


    List<Map<String,Object>> getZhiStatistics(StatisticsVo statisticsVo);

}
