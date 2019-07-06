package com.study.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-05 21:49
 **/
@Getter
@AllArgsConstructor
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;

    private int code;

    private String message;
}
