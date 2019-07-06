package com.study.product.client;

import com.study.product.common.DecreaseStockInput;
import com.study.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-06 11:01
 **/
@Component
@FeignClient("PRODUCT")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();

    @PostMapping("/product/ListForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);


    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> cartDTOList);
    }
