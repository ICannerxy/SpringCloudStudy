package com.study.product.VO;

import lombok.Data;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-05 19:35
 **/
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /*提示信息*/
    private String msg;

    /*具体数据*/
    private T data;

}
