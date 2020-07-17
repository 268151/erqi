package com.aaa.vo;

import com.aaa.model.T_mapping_project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: dz
 * @createtime: 2020/7/15 20:05
 * @param:
 * @desc: 项目表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MappingProjectVo {
    private T_mapping_project mapping_project;
    private Integer pageNum;
    private Integer pageSize;

}
