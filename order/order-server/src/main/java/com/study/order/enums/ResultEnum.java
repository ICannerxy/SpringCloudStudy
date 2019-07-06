package com.study.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-05 22:19
 **/
@Getter
@AllArgsConstructor
public enum ResultEnum {

    PARAM_ERROR(1, "参数错误"),
    CART_EMPTY(2, "购物车为空"),
    ;

    private int code;

    private String message;
}
