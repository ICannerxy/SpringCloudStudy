package com.study.auth.server.enums;

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
    SUCCESS(0, "成功"),
    PARAM_ERROR(1, "参数错误"),
    CART_EMPTY(2, "购物车为空"),
    LOGIN_FAIL(4, "登录失败"),
    ROLE_ERROR(5, "角色权限错误"),
    ORDER_NOT_EXIST(6,"订单不存在"),
    ORDER_STATUS_ERROR(7, "订单状态错误"),
    ;

    private int code;

    private String message;
}
