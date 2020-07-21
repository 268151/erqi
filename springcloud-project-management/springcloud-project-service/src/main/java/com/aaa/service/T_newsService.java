package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.model.T_news;
import com.aaa.utils.DateUtils;
import com.aaa.utils.FileNameUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class T_newsService extends BaseService<T_news> {
/**
 * @author: dz
 * @createtime: 2020/7/20 15:29
 * @param:
 * @desc: 查询信息表
 */

    public PageInfo<T_news> selectAllNews(T_news t_news, Integer pageNo, Integer pageSize) {
        return super.selectListByPage(t_news, pageNo, pageSize);
    }

    /**
     * @author: dz
     * @createtime: 2020/7/20 16:28
     * @param:
     * @desc: 新增
     */

    public Integer addNews(T_news news){
        news.setId(Long.valueOf(FileNameUtils.getFileName()));
        news.setGmtCreate(DateUtils.getCurrentDate());
        return super.add(news);
    }

/**
 * @author: dz
 * @createtime: 2020/7/20 16:31
 * @param:
 * @desc: 修改
 */

    public Integer updateNews(T_news news){

        news.setGmtModified(DateUtils.getCurrentDate());
        return super.update(news);
    }


    /**
     * @author: dz
     * @createtime: 2020/7/20 18:56
     * @param:
     * @desc: 新闻表批量删除
     */

    public Integer delNews(List ids){
        Integer integer = super.deleteByIds(ids);
        if (integer>0){
            return integer;
        }
       return null;
    }
}
