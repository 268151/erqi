package com.aaa.vo;

import com.aaa.model.T_role;
import lombok.Data;

/**
 * @description:
 * @author: 彭于晏
 * @create: 2020-04-13 21:57
 **/
@Data
public class TreeKeys {
    private Integer roleId;
    private Integer []keys;
    private T_role role;
}
