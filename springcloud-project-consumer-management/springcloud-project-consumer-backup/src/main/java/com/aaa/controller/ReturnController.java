package com.aaa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: ReturnController
 * @author: 彭于晏
 * @create: 2020-07-23 14:28
 **/
@Controller
public class ReturnController {

    @RequestMapping("/projectStatistics")
    public String StatisticsView(){
        return "projectStatistics";
    }

}
