package com.study.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-07 12:33
 **/
public interface StreamClient {

    String INPUT = "myMessage";
    String OUTPUT = "myMessage1";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();
}
