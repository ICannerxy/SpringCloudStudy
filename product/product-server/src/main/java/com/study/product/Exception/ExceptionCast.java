package com.study.product.Exception;

import com.study.product.eunm.ResultEnum;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-06 13:28
 **/
public class ExceptionCast {

    public static void cast(ResultEnum resultEnum) {
        throw new ProduceException(resultEnum);
    }
}
