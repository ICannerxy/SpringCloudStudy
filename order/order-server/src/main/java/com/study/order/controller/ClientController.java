package com.study.order.controller;

import com.study.product.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-06 11:03
 **/
@RestController
public class ClientController {

    @Autowired
    private ProductClient productClient;

    @RequestMapping("/client")
    public String msg() {
        return productClient.productMsg();
    }
}
