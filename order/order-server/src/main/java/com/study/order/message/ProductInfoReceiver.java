package com.study.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.study.order.enums.ResultEnum;
import com.study.order.exception.ExceptionCast;
import com.study.order.utils.JsonUtil;
import com.study.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-07 16:11
 **/
@Component
@Slf4j
public class ProductInfoReceiver {

    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) {
        //message => ProductInfoOutput
        List<ProductInfoOutput> productInfoOutputList = JsonUtil.fromJson(message,
                new TypeReference<List<ProductInfoOutput>>() {});
        log.info("从队列【{}】接收到消息：{}", "productInfo", productInfoOutputList);
        if (CollectionUtils.isEmpty(productInfoOutputList)) {
            ExceptionCast.cast(ResultEnum.CART_EMPTY);
        }
        //存储到redis中
        for (ProductInfoOutput productInfoOutput : productInfoOutputList) {
            stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE, productInfoOutput.getProductId()),
                    String.valueOf(productInfoOutput.getProductStock()));
        }
    }
}
