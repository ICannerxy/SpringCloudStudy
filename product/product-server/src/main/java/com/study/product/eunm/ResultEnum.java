package com.study.product.eunm;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-06 13:27
 **/
@Getter
@AllArgsConstructor
public enum  ResultEnum {
    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "库存不足"),
    ;

    private int code;

    private String msg;
}
