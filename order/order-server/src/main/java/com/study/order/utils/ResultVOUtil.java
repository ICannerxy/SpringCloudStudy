package com.study.order.utils;


import com.study.order.VO.ResultVO;
import com.study.order.enums.ResultEnum;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-05 20:53
 **/
public class ResultVOUtil {

    public static <T>ResultVO success(T obj) {
        ResultVO<T> resultVO = new ResultVO<>(ResultEnum.SUCCESS);
        resultVO.setData(obj);
        return resultVO;
    }

}
