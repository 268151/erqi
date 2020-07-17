package com.aaa.vo;

import com.aaa.model.T_audit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: dz
 * @createtime: 2020/7/16 10:45
 * @param:
 * @desc: 项目汇总
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class T_auditVo {
    private T_audit t_audit;
    private Integer pageNum;
    private Integer pageSize;
}
