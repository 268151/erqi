package com.aaa.utils;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @description: PageInfo
 * @author: 彭于晏
 * @create: 2020-07-18 13:42
 **/
@Data
@Accessors(chain = true)
public class PageInfoRandom<T> {

    private Integer pageNum;
    private Integer pageSize;
    private Integer pages;
    private Integer count;
    private List<T> list;

    public PageInfoRandom(List<T> list,Integer pageNum,Integer pageSize){
        this.pageNum=pageNum;
        this.pageSize=pageSize;
        this.count=list.size();
        this.pages =  count % pageSize==0 ? count /pageSize : (count/pageSize)+1;
        int sizes=(pageNum-1)*pageSize+pageSize>count ? count :(pageNum-1)*pageSize+pageSize;
       this.list=list.subList((pageNum-1)*pageSize,sizes);
    }

}
