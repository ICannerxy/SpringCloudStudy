package com.study.order.exception;

import com.study.order.enums.ResultEnum;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-05 22:21
 **/
public class ExceptionCast {

    public static void cast(ResultEnum resultEnum) {
        throw new OrderException(resultEnum.getCode(), resultEnum.getMessage());
    }

    public static void cast(int code, String message) {
        throw new OrderException(code, message);
    }
}
