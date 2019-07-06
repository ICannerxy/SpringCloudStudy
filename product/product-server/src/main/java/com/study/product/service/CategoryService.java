package com.study.product.service;

import com.study.product.dataobject.ProductCategory;

import java.util.List;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-05 19:33
 **/
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
