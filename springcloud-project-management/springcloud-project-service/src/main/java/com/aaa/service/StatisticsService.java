package com.aaa.service;

import com.aaa.mapper.StatisticsMapper;
import com.aaa.vo.StatisticsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description: StatisticsService
 * @author: 彭于晏
 * @create: 2020-07-15 20:40
 **/
@Service
public class StatisticsService {

    @Autowired
    private StatisticsMapper statisticsMapper;
    /**
     * 统计图 1.1  单位资质统计
     */
    public List<Map<String ,Object>> getQualification(){
        return statisticsMapper.getQualification();
    }

    /**
     * 统计图1.2 查询未完成成功的 和已完成的
     */
    public List<Map<String ,Object>> getNoproject(){
        List<Map<String, Object>> noproject = statisticsMapper.getNoproject();
        List<Map<String, Object>> yesproject = statisticsMapper.getYesproject();
        boolean b = noproject.addAll(yesproject);
        return noproject;
    }

    /**
     * 统计图2查询该公司的人员 人员统计
     */
   public List<Map<String ,Object>> getCompanyPeople(Integer userid){
        List<Map<String, Object>> companyPeople = statisticsMapper.getCompanyPeople(userid);
        List<Map<String, Object>> companyShebei = statisticsMapper.getCompanySpe(userid);
       List<Map<String, Object>> companyPro = statisticsMapper.getCompanyPro(userid);
       companyPeople.addAll(companyShebei);
       companyPeople.addAll(companyPro);
        return companyPeople;
    }

    /**
     * 统计图3
     */
   public List<Map<String,Object>> getSheBeiStatisticsAll(@RequestBody StatisticsVo statisticsVo ){
        List<Map<String, Object>> personnelStatistics = statisticsMapper.getPersonnelStatistics( statisticsVo);
        List<Map<String, Object>> sheBeiStatistics = statisticsMapper.getSheBeiStatistics(statisticsVo);
       List<Map<String, Object>> zhiStatistics = statisticsMapper.getZhiStatistics(statisticsVo);
       personnelStatistics.addAll(sheBeiStatistics);
       personnelStatistics.addAll(zhiStatistics);
        return personnelStatistics;
    }





}
