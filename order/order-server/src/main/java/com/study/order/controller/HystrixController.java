package com.study.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-10 19:43
 **/
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {


    //@HystrixCommand(fallbackMethod = "fallback")
    // 超时配置
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })

    // 断路器
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 设置熔断
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //10次请求
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 断路器开启时长
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //阈值,10次请求有6次以上就开启熔断
//    })
    @HystrixCommand
    @GetMapping("/getProductInfoList")
    public String getProductList(@RequestParam("number")Integer number) {
        if (number % 2 == 0) {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.postForObject("http://localhost:8112/product/ListForOrder",
                    Arrays.asList("143296935"), String.class);
        }

        throw new RuntimeException("故意出错");
    }

    public String fallback() {
        return "太拥挤了,请稍后再试~~";
    }

    public String defaultFallback() {
        return "默认提示,太拥挤了";
    }
}
