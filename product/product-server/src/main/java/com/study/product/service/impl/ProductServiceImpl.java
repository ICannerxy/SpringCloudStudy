package com.study.product.service.impl;

import com.study.product.dto.CartDTO;
import com.study.product.Exception.ExceptionCast;
import com.study.product.dataobject.ProductInfo;
import com.study.product.eunm.ProductStatusEnum;
import com.study.product.eunm.ResultEnum;
import com.study.product.repository.ProductInfoRepository;
import com.study.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-05 19:26
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;
    /**
     * 查询所有在架商品列表
     */
    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    /**
     * 扣库存
     *
     * @param cartDTOList
     */
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartDTO.getProductId());
            // 判断商品是否存在
            if (!productInfoOptional.isPresent()) {
                ExceptionCast.cast(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = productInfoOptional.get();
            int result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            // 库存是否足够
            if (result < 0) {
                ExceptionCast.cast(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
