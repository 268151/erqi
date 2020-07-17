package com.aaa.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: xxf
 * @Time: Create in 2020/5/15  22:55
 * @Description:    时间类工具
 */
public class TimeUtils {

    /**
     * @Author xxf
     * @Description 获取系统当前时间并转换为String类型  年月日 时分秒
     * @Date 22:57 2020/5/15
     * @Param []
     * @return java.lang.String
     * @throws
     **/
    public static String getNowTimeYMDHMS() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }

    /**
     * @Author xxf
     * @Description 获取系统当前时间变更转换为String类型 年月日
     * @Date 23:01 2020/5/15
     * @Param []
     * @return java.lang.String
     * @throws
     **/
    public static String getNowTimeYMD() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * @Author xxf
     * @Description 将时间类型转换为String类型  年月日 时分秒
     * @Date 9:25 2020/5/20
     * @Param [data]
     * @return java.lang.String
     * @throws
     **/
    public static String toStringTimeYMDHMS(Date data) {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(data);
    }

    /**
     * @Author xxf
     * @Description     将时间类型转换为String类型    年月日
     * @Date 9:28 2020/5/20
     * @Param [data]
     * @return java.lang.String
     * @throws
     **/
    public static String toStringTimeYMD(Date data) {
        return new SimpleDateFormat("yyyy-MM-dd").format(data);
    }
}
