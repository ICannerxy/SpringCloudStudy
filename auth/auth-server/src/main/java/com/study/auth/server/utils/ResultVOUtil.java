package com.study.auth.server.utils;


import com.study.auth.server.VO.ResultVO;
import com.study.auth.server.enums.ResultEnum;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-05 20:53
 **/
public class ResultVOUtil {

    public static <T> ResultVO success(T obj) {
        ResultVO<T> resultVO = new ResultVO<>(ResultEnum.SUCCESS);
        resultVO.setData(obj);
        return resultVO;
    }

    public static ResultVO success() {
        return new ResultVO<>(ResultEnum.SUCCESS);
    }

    public static <T> ResultVO error(ResultEnum resultEnum) {
        ResultVO<T> resultVO = new ResultVO<>(resultEnum);
        return resultVO;
    }

}
