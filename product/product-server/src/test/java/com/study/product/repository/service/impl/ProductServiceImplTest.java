package com.study.product.repository.service.impl;

import com.study.product.ProductApplicationTests;
import com.study.product.dto.CartDTO;
import com.study.product.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class ProductServiceImplTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void decreaseStock() {
        CartDTO cartDTO = new CartDTO("123097733", 2);
        productService.decreaseStock(Arrays.asList(cartDTO));
    }
}