package com.study.order.exception;

import com.study.order.enums.ResultEnum;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-05 22:17
 **/
public class OrderException extends RuntimeException {

    private int code;

    public OrderException(int code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
