package com.aaa.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TokenVo implements Serializable {

    private String token;
    private Boolean ifSuccess;

    /**
     * 1.账号不存在
     * 2.密码错误
     * 3.账号被锁定
     */
    private Integer type;
}
