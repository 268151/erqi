package com.aaa.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: 彭于晏
 * @create: 2020-04-13 16:10
 **/
@Data
@Accessors(chain = false)
public class TreeData implements Serializable {
    private Integer id;
    private String label;
    private List<TreeData> children;
}
