package com.study.order.controller;

import com.study.order.dto.OrderDTO;
import com.study.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-07 12:37
 **/
@RestController
public class SendMessageController {

    @Autowired
    private StreamClient client;

//    @GetMapping("/sendMessage")
//    public void process() {
//        String message = "now " + new Date();
//        client.output().send(MessageBuilder.withPayload(message).build());
//    }

    @GetMapping("/sendMessage")
    public void process() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123245542");
        client.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
