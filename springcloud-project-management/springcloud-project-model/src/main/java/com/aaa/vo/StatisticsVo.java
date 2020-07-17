package com.aaa.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: StatisticsVo
 * @author: 彭于晏
 * @create: 2020-07-17 14:44
 **/
@Data
public class StatisticsVo  implements Serializable {

    /**
     * 当前区域  用于统计图查询
     * 0为外区
     * 1为本地
     */
    private Integer qu;
    /**
     * 更具年份进行查询
     */
    private Integer date;
}
