package com.study.order.service;

import com.study.order.dto.OrderDTO;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-05 21:57
 **/
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
