package com.study.order.repository;

import com.study.order.OrderApplicationTests;
import com.study.order.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;

public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("113423");
        orderMaster.setBuyerAddress("杭州市滨江区钱塘玫瑰湾");
        orderMaster.setBuyerName("徐杨");
        orderMaster.setBuyerOpenid("AJKakjsh");
        orderMaster.setBuyerPhone("1369369789");
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());
        orderMaster.setPayStatus(0);
        orderMaster.setOrderAmount(new BigDecimal(20));
        orderMaster.setOrderStatus(0);
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result != null);
    }
}