package com.study.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-06 13:21
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;
}
