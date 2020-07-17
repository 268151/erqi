package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.service.IProjectService;

import com.aaa.vo.StatisticsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * @description: StatisticsController
 * @author: 彭于晏
 * @create: 2020-07-15 21:58
 **/
@RestController
public class StatisticsController extends BaseController {
    @Autowired
    private IProjectService statisticsService;

    /**
     * 统计图1.1
     * @return
     */
    @GetMapping("/getQualification")
    public ResultData getQualification(){
      return statisticsService.getQualification();
    }

    /**
     * 统计图1.2
     * @return
     */
    @GetMapping("/getNoproject")
    public ResultData getNoproject(){
      return statisticsService.getNoproject();
    }

    /**
     * 统计图2
     * @param uid
     * @return
     */
    @GetMapping("/getCompanyPeople")
    public ResultData getCompanyPeople(@RequestParam("uid") Integer uid){
        return statisticsService.getCompanyPeople(uid);
    }

    /**
     * 统计图3
     * @return
     */
    @GetMapping("/getSheBeiStatisticsAll")
    public ResultData getSheBeiStatisticsAll(StatisticsVo statisticsVo){
        return statisticsService.getSheBeiStatisticsAll(statisticsVo);
    }

}
