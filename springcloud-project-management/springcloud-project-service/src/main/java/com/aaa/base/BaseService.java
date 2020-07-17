package com.aaa.base;

import com.aaa.utils.Map2BeanUtils;
import com.aaa.utils.SpringContextUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.aaa.staticproperties.OrderStatic.ASC;
import static com.aaa.staticproperties.OrderStatic.DESC;

/**
 * 通用Service
 */
public abstract class BaseService<T> {

    //全局变量
    private Class<T> cache=null;

    @Autowired
    private Mapper<T> mapper;


   protected Mapper getMapper(){

        return mapper;
    }

    /*public ResultData insertDta(T t){
        int insert = mapper.insert(t);
        if (insert>0){
            return new ResultData().setCode("300").setMsg("数据插入成功");
        }
        return null;
    }*/

    /**
     * 新增
     * @param t
     * @return
     */
    public Integer add(T t){
        return mapper.insert(t);
    }


    /**
     * 根据主键进行删除
     * @param t
     * @return
     */
    public Integer delete(T t){
        return mapper.deleteByPrimaryKey(t);
    }

    /**
     * 根据主键进行批量删除
     * @param ids
     * @return
     */
    public Integer deleteByIds(List<Integer> ids){
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", ids)).build();
        return mapper.deleteByExample(example);
    }

    /**
     * 更新操作
     * @param t
     * @return
     */
    public Integer update(T t){
        return mapper.updateByPrimaryKeySelective(t);
    }

    /**
     *批量更新数据
     * @param t
     * @param ids
     * @return
     */
    public Integer batchUpdate(T t,Integer[] ids){
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", Arrays.asList(ids))).build();
        return mapper.updateByExample(t,example);
    }


    /**
     * 查询一条数据，
     * @param t
     * @return
     */
    public T selectOne(T t){
        return mapper.selectOne(t);
    }

    /**
     * 查询一条数据，用与模糊查询
     * @param where
     * @param orderByFiled
     * @param fileds
     * @return
     */
    public T selectOneByFiled(Sqls where,String orderByFiled,String... fileds){
       return (T)selectByFileds(null,null,where,orderByFiled,null,fileds).get(0);
    }


    /**
     * 通过条件查询一个列表
     * @param where
     * @param orderByFiled
     * @param fileds
     * @return
     */
    public List<T> selectListByFiled(Sqls where,String orderByFiled,String... fileds){
      return  selectByFileds(null,null,where,orderByFiled,null,fileds);
    }

    /**
     * 实现条件查询的分页
     * @param pageNo
     * @param pageSize
     * @param where
     * @param orderFiled
     * @param fileds
     * @return
     */
    public PageInfo<T> selectListByPageAndFiled(Integer pageNo, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        return new PageInfo<T>(selectByFileds(pageNo, pageSize, where, orderFiled, null, fileds));
    }

    /**
     * 查询集合，条件查询
     * @param t
     * @return
     */
    public List<T> selectList(T t) {
        return mapper.select(t);
    }


    /**
     * 查询集合，分页查询
     * @param t
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<T> selectListByPage(T t, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<T> select = mapper.select(t);
        PageInfo<T> pageInfo = new PageInfo<T>(select);
        return pageInfo;
    }

    /**
     * map转换实体类型
     * @param map
     * @return
     */
    public T newInstance(Map map) {
        return (T) Map2BeanUtils.map2Bean(map, getTypeArguement());
    }


    /**
     * 实现查询通用
     * 可以用于分页，可以用于排序，还可以用于多条件查询
     *   orderByFiled:是所要排序的字段
     * @return
     */
    private List<T> selectByFileds(Integer pageNo,Integer pageSize,Sqls where,String orderByFiled,String orderWord,String... fileds){
        Example.Builder builder=null;
        if (null == fileds || fileds.length == 0){
            //查询所有数据
            builder = Example.builder(getTypeArguement());
        }else {
            builder=Example.builder(getTypeArguement()).select(fileds);
        }

        if (where!=null){
            builder=builder.where(where);
        }
        if(orderByFiled != null) {
            // 说明我需要对某个字段进行排序
            if(DESC.equals(orderWord.toUpperCase())) {
                // 说明需要倒序
                builder = builder.orderByDesc(orderByFiled);
            } else if(ASC.equals(orderWord.toUpperCase())) {
                builder = builder.orderByAsc(orderByFiled);
            } else {
                builder = builder.orderByDesc(orderByFiled);
            }
        }
        Example example = builder.build();
        // 实现分页
        if(pageNo != null & pageSize != null) {
            PageHelper.startPage(pageNo, pageSize);
        }
        return getMapper().selectByExample(example);
    }

    /**
     * 获取子类泛型类型
     * @return
     */
    public Class<T> getTypeArguement(){
        if(null == cache){
            cache = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return cache;
    }

    /**
     * @description
     * 获取spring容器/获取spring的上下文
     * 在项目开始运行的时候，会去加载spring配置，
     * 如果你们项目需要在项目启动的时候也加载自己的配置文件
     * 在spring的源码中有一个必须要看的方法(init())
     * init()--->就是在项目启动的时候去加载spring的配置
     * 如果你的项目中也需要把某一些配置一开始就托管给spring
     * 需要获取到spring的上下文(ApplicationContext)
     * @param
     **/
    public ApplicationContext getApplicationContext() {




        return SpringContextUtils.getApplicationContext();
    }




}
