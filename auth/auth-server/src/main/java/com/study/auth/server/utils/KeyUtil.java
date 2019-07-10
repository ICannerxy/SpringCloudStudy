package com.study.auth.server.utils;

import java.util.Random;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-05 22:05
 **/
public class KeyUtil {

    /**
     * 生成唯一主键
     * 时间 + 随机数
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
