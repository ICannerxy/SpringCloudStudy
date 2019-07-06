package com.study.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-06 11:01
 **/
@RestController
public class MsgController {

    @GetMapping("/msg")
    public String msg() {
        return "this is product msg";
    }
}
