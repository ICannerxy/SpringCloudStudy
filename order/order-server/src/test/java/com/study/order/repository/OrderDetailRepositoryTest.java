package com.study.order.repository;

import com.study.order.OrderApplicationTests;
import com.study.order.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDetailRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void testSave() {

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1236883");
        orderDetail.setCreateTime(new Date());
        orderDetail.setOrderId("113423");
        orderDetail.setProductIcon("//laoiczxlk");
        orderDetail.setProductId("123097733");
        orderDetail.setProductName("慕斯蛋糕");
        orderDetail.setUpdateTime(new Date());
        orderDetail.setProductQuantity(10);
        orderDetail.setProductPrice(new BigDecimal(0.06));
        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertTrue(result != null);
    }


}