package com.study.product.eunm;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-05 19:28
 **/
@Getter
@AllArgsConstructor
public enum  ProductStatusEnum {

    UP(0,"在架"),
    DOWM(1,"下架"),
    ;

    private int code;

    private String message;


}
