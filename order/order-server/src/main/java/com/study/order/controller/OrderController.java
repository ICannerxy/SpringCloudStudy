package com.study.order.controller;

import com.study.order.VO.ResultVO;
import com.study.order.convrter.OrderForm2OrderDTOConverter;
import com.study.order.dto.OrderDTO;
import com.study.order.enums.ResultEnum;
import com.study.order.exception.ExceptionCast;
import com.study.order.form.OrderForm;
import com.study.order.service.OrderService;
import com.study.order.utils.ResultVOUtil;
import com.study.product.client.ProductClient;
import com.study.product.common.DecreaseStockInput;
import com.study.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-05 21:56
 **/
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductClient productClient;

    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("[创建订单]参数不正确, orderForm={}", orderForm);
            ExceptionCast.cast(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("[创建订单]购物车信息为空");
            ExceptionCast.cast(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtil.success(map);
    }

    @PostMapping("/getProductList")
    public String getProductList() {
        List<ProductInfoOutput> productInfoOutputList = productClient.listForOrder(Arrays.asList("123097733"));
        log.info("response ==> {}", productInfoOutputList);
        return "OK";
    }

    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock() {
        productClient.decreaseStock(Arrays.asList(new DecreaseStockInput("123097733", 2)));
        return "OK";
    }

    /**
     * 完结订单
     * @param orderId
     * @return
     */
    @PostMapping("/finish")
    public ResultVO<OrderDTO> finish(@RequestParam("orderId") String orderId) {
        return ResultVOUtil.success(orderService.finish(orderId));
    }
}
