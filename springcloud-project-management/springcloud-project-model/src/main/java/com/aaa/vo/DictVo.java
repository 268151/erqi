package com.aaa.vo;


import com.aaa.model.T_dict;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/6/4 0004
 * Time: 0:16
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DictVo {
    private T_dict dict;
    private Integer pageNum;
    private Integer pageSize;
}
