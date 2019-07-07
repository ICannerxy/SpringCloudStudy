package com.study.order;

import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-07 10:57
 * 发送MQ消息测试
 **/
public class MqSenderTest extends OrderApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void send() {
        rabbitTemplate.convertAndSend("myQueue", "now:" + new Date());
    }

    @Test
    public void sendOrder() {
        rabbitTemplate.convertAndSend("myOrder","computer", "now:" + new Date());
    }
}
