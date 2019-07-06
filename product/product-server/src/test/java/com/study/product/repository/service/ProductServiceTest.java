package com.study.product.repository.service;

import com.study.product.ProductApplicationTests;
import com.study.product.dataobject.ProductInfo;
import com.study.product.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceTest extends ProductApplicationTests {


    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> upProductInfos = productService.findUpAll();
        Assert.assertTrue(upProductInfos.size() > 0);
    }
}