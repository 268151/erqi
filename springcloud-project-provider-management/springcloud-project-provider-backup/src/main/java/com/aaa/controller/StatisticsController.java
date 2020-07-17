package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.service.StatisticsService;
import com.aaa.utils.ObjectUtils;
import com.aaa.vo.StatisticsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @description: StatisticsController
 * @author: 彭于晏
 * @create: 2020-07-15 21:58
 **/
@RestController
public class StatisticsController extends BaseController {
    @Autowired
    private StatisticsService  statisticsService;

    /**
     * 统计图1.1
     * @return
     */
    @GetMapping("/getQualification")
    public ResultData getQualification(){
        List<Map<String, Object>> qualification = statisticsService.getQualification();
        if(!ObjectUtils.CollectionIsNull(qualification)){
            return operationSuccess(qualification);
        }
        return operationFailed();
    }

    /**
     * 统计图1.2
     * @return
     */
    @GetMapping("/getNoproject")
    public ResultData getNoproject(){
        List<Map<String, Object>> noproject = statisticsService.getNoproject();
        if(!ObjectUtils.CollectionIsNull(noproject)){
            return operationSuccess(noproject);
        }
        return operationFailed();
    }

    /**
     * 统计图2
     * @param uid
     * @return
     */
    @GetMapping("/getCompanyPeople")
    public ResultData getCompanyPeople(Integer uid){
        List<Map<String, Object>> companyPeople = statisticsService.getCompanyPeople(uid);
        return reponseListStatus(companyPeople);
    }

    /**
     * 统计图3
     * @return
     */
    @GetMapping("/getSheBeiStatisticsAll")
    public ResultData getSheBeiStatisticsAll(StatisticsVo statisticsVo){
        return reponseListStatus(statisticsService.getSheBeiStatisticsAll(statisticsVo));
    }

}
