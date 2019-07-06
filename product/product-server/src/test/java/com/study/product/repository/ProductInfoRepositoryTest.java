package com.study.product.repository;

import com.study.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfos = productInfoRepository.findByProductStatus(0);
        Assert.assertTrue(productInfos.size() > 0);
    }

    @Test
    public void findByProductIdIn() {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductIdIn(Arrays.asList("143296932", "164873498"));
        Assert.assertTrue(productInfoList.size() > 0);
    }
}