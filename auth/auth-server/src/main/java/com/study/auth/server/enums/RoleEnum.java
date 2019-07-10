package com.study.auth.server.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author XuYang
 * @description:
 * @date 2019/7/10  13:20
 */
@Getter
@AllArgsConstructor
public enum  RoleEnum {
    BUYER(1, "买家"),
    SELLER(2, "卖家")
    ;

    private int code;

    private String message;
}
