package com.study.product.utils;

import com.study.product.VO.ResultVO;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-05 20:53
 **/
public class ResultVOUtil {

    public static ResultVO<Object> success(Object obj) {
        ResultVO resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(obj);
        return resultVO;
    }

}
