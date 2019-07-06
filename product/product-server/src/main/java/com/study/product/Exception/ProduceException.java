package com.study.product.Exception;

import com.study.product.eunm.ResultEnum;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-06 13:25
 **/
public class ProduceException extends RuntimeException {

    private int code;

    public ProduceException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public ProduceException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

}
