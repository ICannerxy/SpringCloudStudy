package com.study.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-07 10:55
 **/
@Component
@Slf4j
public class MqReceiver {

    //1. @RabbitListener(queues = "myQueue")
    //2. 自动创建队列@RabbitListener(queuesToDeclare = @Queue("myQueue"))
    //3. 自动创建队列和交换机
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message) {
        log.info("receive ==> {}", message);
    }

    /**
     * 数码供应商
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",
            value = @Queue("computerOrder")

    ))
    public void processComputer(String message) {
        log.info("computerReceive ==> {}", message);
    }

    /**
     * 水果供应商
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("fruitOrder")

    ))
    public void processFruit(String message) {
        log.info("fruitReceive ==> {}", message);
    }
}
