package com.aaa.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: StatisticsLevelVo
 * @author: 彭于晏
 * @create: 2020-07-20 20:51
 **/
@Data
@Accessors(chain = true)
public class StatisticsLevelVo {
    /**
     * 资质等级
     */
    private String name;
    /**
     * 单位数量
     */
    private Integer utilCount=0;
    /**
     * 技术人员
     */
    private Integer Count=0;
    private Integer chuCount=0;
    private Integer zhongCount=0;
    private Integer gaoCount=0;

    /**
     * shebie 信息
     */
    private Integer GPS=0;

    private Integer ceJu=0;
    private int shuiZhui;
    private int jie;
    private int quan;
    private int rtk;
    private int shu;
    private int shuiWei;
    private int sheng;
    private int dixia;
    private int wuren;
}
