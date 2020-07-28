package com.aaa.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @description: MenuVo
 * @author: 彭于晏
 * @create: 2020-07-27 10:49
 **/
@Data
@Accessors(chain = false)
public class MenuVo {
    private Integer id;
    private String title;
    private String href;
    private String icon;
    private List<MenuVo> list;
}
