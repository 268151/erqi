package com.aaa.base;

import com.aaa.utils.ObjectUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.util.Sqls;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class CommonController<T> extends BaseController {
    /**
     * 钩子函数
     * 新增之前去执行某些操作
     *
     * 下单操作:
     * 需求
     * 在购物车中当点击立即下单按钮的时候--->跳转下单页面(选择地址，选择优惠券...)
     * 把购物车中的这个商品删除
     * deleteCart(List<Integer> id);--->是优先于insertOrder前置执行
     * insertOrder(Order oder);
     * @param map
     */
    protected void beforeAdd(Map map) {
        // TODO AddMethod Before to do something
    }


    /**
     *  钩子函数
     *  是在新增之后去执行
     *
     *  int result = insertOrder(Order order)
     *  if(result > 0) {
     *  insertOrderDetail(OrderDetail orderDetail);
     *  }
     * @param map
     */
    protected void afterAdd(Map map) {
        // TODO AddMethod After to do something
    }


    public abstract BaseService<T> getBaseService();


    /**
     * 通用的新增方法
     * 因为咱们目前市面上所有的公司实现的全是异步了
     * 就是说前端向后端所传递的数据都是json格式
     *  之前在controller的方法中接收固定的实体类，是因为你知道前端给你传递的类型就是这个实体类
     *  但是既然要做通用，前端所传递的类型就不会固定了--->所以使用Map类型来统一接收
     * @param map
     * @return
     */
    public ResultData add(@RequestBody Map map) {
        // 因为根据咱们的封装规则，在service中是需要传递泛型的，就意味着service需要接收固定的实体类
        // 但是controller是一个Map类型
        beforeAdd(map);
        // 1.Map转实体类
        T instance = getBaseService().newInstance(map);
        // 2.通用service
        Integer addResult = getBaseService().add(instance);
        if(addResult > 0) {
            afterAdd(map);
            return super.operationSuccess();
        }
        return super.operationFailed();
    }


    /**
     * 删除操作
     * @param map
     * @return
     */
    public ResultData delete(@RequestBody Map map) {
        T instance = getBaseService().newInstance(map);
        Integer deleteResult = getBaseService().delete(instance);
        if(deleteResult > 0) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }


    /**
     * 批量删除
     * @param ids
     * @return
     */
    public ResultData batchDelete(@RequestParam("ids[]") Integer[] ids) {
        Integer deleteResult = getBaseService().deleteByIds(Arrays.asList(ids));
        if(deleteResult > 0) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }



    /**
     * 更新操作
     * @param map
     * @return
     */
    public ResultData update(@RequestBody Map map) {
        // 1.Map转实体类
        T instance = getBaseService().newInstance(map);
        // 2.通用service
        Integer addResult = getBaseService().update(instance);
        if(addResult > 0) {
            return operationSuccess();
        }
        return operationFailed();
    }

    /**
     * 批量更新
     * @param map
     * @param ids
     * @return
     */
  /*  public ResultData batchUpdate(@RequestBody Map map,@RequestParam("ids[]") Integer[] ids){
        // 1.Map转实体类
        T instance = getBaseService().newInstance(map);
        Integer batchUpdate = getBaseService().batchUpdate(instance, ids);
        if (batchUpdate>0){
            return super.operationSuccess();
        }
        return super.operationFailed();
    }*/


    /**
     * 查询一条数据
     * @param map
     * @return
     */
    public ResultData selectOne(@RequestBody Map map){
        // 1.Map转实体类
        T instance = getBaseService().newInstance(map);
        T selectOne = getBaseService().selectOne(instance);
        if (null != selectOne){
            return super.operationSuccess(selectOne);
        }
        return super.operationFailed();
    }


    /**
     * 查询一条数据，用与模糊查询
     * @param where
     * @param orderByFiled
     * @param fileds
     * @return
     */
   /* public ResultData selectOneByFiled(Sqls where, @RequestParam("orderByFiled")String orderByFiled,@RequestParam("fileds") String... fileds){
        T selectOneByFiled = getBaseService().selectOneByFiled(where, orderByFiled, fileds);
        if (selectOneByFiled!=null){
            return super.operationSuccess();
        }
        return super.operationFailed();
    }*/

    /**
     * 通过条件查询一个列表
     * @param where
     * @param orderByFiled
     * @param fileds
     * @return
     */
   /* public ResultData selectListByFiled(Sqls where,@RequestParam("orderByFiled")String orderByFiled,@RequestParam("fileds") String... fileds){
        List<T> selectListByFiled = getBaseService().selectListByFiled(where, orderByFiled, fileds);
        if (selectListByFiled!=null){
            return super.operationSuccess();
        }
        return super.operationFailed();
    }*/

    /**
     * 实现条件查询的分页
     * @param pageNo
     * @param pageSize
     * @param where
     * @param orderFiled
     * @param fileds
     * @return
     */
    /*public ResultData selectListByPageAndFiled(@RequestParam("pageNo")Integer pageNo,@RequestParam("pageSize") Integer pageSize, Sqls where, @RequestParam("orderFiled") String orderFiled,@RequestParam("fileds") String... fileds){
        PageInfo<T> tPageInfo = getBaseService().selectListByPageAndFiled(pageNo, pageSize, where, orderFiled,fileds);
        if (tPageInfo!=null){
            return super.operationSuccess();
        }
        return super.operationFailed();
    }*/

    /**
     * 查询集合，条件查询
     * @param map
     * @return
     */
    public ResultData selectList(@RequestBody Map map){
        // 1.Map转实体类
        T instance = getBaseService().newInstance(map);
        List<T> selectList = getBaseService().selectList(instance);
        if (selectList.size()>0){
            return super.operationSuccess(selectList);
        }
        return super.operationFailed("未找到查询结果");
    }

    /**
     * 查询集合，分页查询
     * @param map
     * @param
     * @param
     * @return
     */
    public ResultData selectListByPage(@RequestBody Map map){
        // 1.Map转实体类
        Integer pageNo= Integer.parseInt(map.get("pageNo").toString());
        Integer pageSize= Integer.parseInt(map.get("pageNo").toString());
        map.put("pageNo",pageNo);
        map.put("pageSize",pageSize);
        T instance = getBaseService().newInstance(map);
        PageInfo<T> selectListByPage = getBaseService().selectListByPage(instance,pageNo,pageSize);
        List<T> resultList = selectListByPage.getList();
        if(resultList.size() > 0) {
            return operationSuccess(selectListByPage);
        }
        return operationFailed("未找到查询结果");
    }

    /**
     * @author Seven Lee
     * @description
     *      不带条件的分页查询
     * @date 2020/3/11
     * @return java.lang.Object
     * @throws
     **/
    public ResultData getListByPage( @RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
        PageInfo<T> pageInfo =getBaseService().selectListByPage(null,pageNo,pageSize);
        List<T> resultList = pageInfo.getList();
        if(resultList.size() > 0) {
            return operationSuccess(pageInfo);
        }
        return operationFailed("未找到查询结果");
    }

    /**
     * 通用分页
     * @param t
     * @param pageNo
     * @param pageSize
     * @return
     */
    public ResultData getAllBypage( T t,int pageNo, int pageSize){
        PageInfo<T> tPageInfo = getBaseService().selectListByPage(t, pageNo, pageSize);

        if(tPageInfo==null){
            return operationFailed();
        }
        if(!ObjectUtils.CollectionIsNull(tPageInfo.getList())){
            return operationSuccess(tPageInfo);
        }
        return operationFailed();

    }

    /**
     * 通用的查询方法
     * @param map
     * @return
     */
    public ResultData getAllBypageMap( Map map){
        Integer pageNo=1;
        Integer pageSize=5;
        if(map.get("pageNo")!=null&&map.get("pageSize")!=null){
             pageNo=Integer.valueOf(map.get("pageNo").toString());
             pageSize=Integer.valueOf(map.get("pageSize").toString());
        }
        ResultData resultData = selectListByPage(map);
        return resultData;

    }






}
