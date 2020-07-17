package com.aaa.utils;

import java.util.Random;
import java.util.UUID;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/5/15 16:33
 * @Description
 **/
public class IdUtils {

    private IdUtils() {}

    /**
     * @author Seven Lee
     * @description
     *      获取uuid
     * @date 2020/5/15
     * @return java.lang.String
     * @throws
    **/
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }


    /**
     * @date:  2020/6/2
     * @author: 秀仔
     * @Description
     * 获取Long类型的id
     * @param []
     * @return java.lang.String
     * @throws
     */
    public static Long getLongID() {
        // 1.获取系统当前时间的毫秒数
        Long timeMillis = System.currentTimeMillis();
        // 2.创建Random对象
        Random random = new Random();
        // 3.做一个随机数，随机区间是0-9999之间随机
        Integer randomNum = random.nextInt(9999);
        //随机数不足四位自动补充0
        String idString = timeMillis + String.format("%04d", randomNum);
        long id = Long.parseLong(idString);
        // 5.返回Long类型id
        return id;
    }


}
