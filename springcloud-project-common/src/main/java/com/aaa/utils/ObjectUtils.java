package com.aaa.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @description: ObjectUtils
 * @author: 彭于晏
 * @create: 2020-07-16 09:58
 **/
public class ObjectUtils {
    private ObjectUtils(){};

    /**
     * 判断集合是否未空
     * 为空返回true
     */
    public static  boolean CollectionIsNull(Collection collection){
        return collection==null || collection.size()==0;
    }

    /**
     * 判断map是否未null
     * @param map
     * @return
     */
    public static boolean MapIsNull(Map map){
        return map==null || map.size()==0;
    }


}
