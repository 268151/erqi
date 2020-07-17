package com.aaa.service;

import com.aaa.base.BaseService;


import com.aaa.mapper.TDictMapper;
import com.aaa.model.T_dict;
import com.aaa.vo.DictVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: dz
 * @createtime: 2020/7/14 15:05
 * @param:
 * @desc:
 */

@Service
public class TDictService extends BaseService<T_dict> {
    @Autowired
    private TDictMapper tDictMapper;
    /**
     * 查询字典数据、带分页、带条件查询
     * @param
     * @return
     */
    public PageInfo<T_dict> selectDictByPage(DictVo dictVo) throws Exception {
        if (dictVo.getPageNum()==null){
            dictVo.setPageNum(1);
        }
        if (dictVo.getPageSize()==null){
            dictVo.setPageSize(10);
        }
        PageInfo<T_dict> tDictPageInfo = super.selectListByPage(dictVo.getDict(), dictVo.getPageNum(), dictVo.getPageSize());
        return tDictPageInfo;
    }

}
