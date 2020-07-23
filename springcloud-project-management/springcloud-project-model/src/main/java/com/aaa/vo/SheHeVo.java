package com.aaa.vo;

import com.aaa.model.T_audit;
import com.aaa.model.T_mapping_unit;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.web.bind.annotation.RequestBody;

@Data
@Accessors(chain = true)
public class SheHeVo {
    private T_mapping_unit t_mapping_unit;
    private T_audit audit;
}
