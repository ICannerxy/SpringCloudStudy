package com.study.order.message;

import com.study.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-07 12:35
 **/
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    @StreamListener(StreamClient.OUTPUT)
    public void process(OrderDTO message) {
        log.info("StreamReceiver: {}", message);
    }
}
