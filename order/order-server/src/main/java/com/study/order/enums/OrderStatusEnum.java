package com.study.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-05 21:44
 **/
@Getter
@AllArgsConstructor
public enum  OrderStatusEnum {
    NEW(0,"新订单"),

    FINISHED(1,"完结"),

    CANCLE(2,"取消"),
    ;

    private Integer code;

    private String message;

}

