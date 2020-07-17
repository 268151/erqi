package com.aaa.vo;

import com.aaa.model.T_score;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ScoreVo {
    private T_score score;
    private Integer pageNum;
    private Integer pageSize;
}
