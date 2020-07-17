package com.aaa.vo;

import com.aaa.model.T_mapping_unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MappingUnitVo {
    private T_mapping_unit mapping_unit;
    private Integer pageNum;
    private Integer pageSize;
}
