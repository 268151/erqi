package com.aaa.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: RandomList
 * @author: 彭于晏
 * @create: 2020-07-18 15:21
 **/
public class RandomList {

    public static <T>List<T> randomList( Double scale,List<T> romdan) {

        if (scale == 1) {
            Collections.shuffle(romdan);
            return romdan;
        }

        //获取数据
        if (scale < 1 && scale > 0) {
            Collections.shuffle(romdan);
            int size = romdan.size();
            Long i = Math.round(size * scale);
            ArrayList arrayList = new ArrayList();
            for (int j = 0; j < i; j++) {
                arrayList.add(romdan.get(j));
            }
            return  arrayList;
        }

       return null;
}
}
