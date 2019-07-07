package com.study.order.controller;

import com.study.order.config.GirlConfig;
import com.study.product.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-06 11:03
 * @RefreshScope: 用于git远端修改配置后自动刷新作用域
 **/
@RestController
@RefreshScope
public class ClientController {

    @Autowired
    private ProductClient productClient;
    @Value("${env}")
    private String env;
    @Autowired
    private GirlConfig girlConfig;

    @RequestMapping("/client")
    public String msg() {
        return productClient.productMsg();
    }

    @RequestMapping("/env")
    public String getEnv() {
        return env;
    }

    @RequestMapping("/girl")
    public String girlPrint() {
        return String.format("姓名:%s,年龄%d", girlConfig.getName(), girlConfig.getAge());
    }
}
