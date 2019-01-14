package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.constant.HttpResponseStatus;
import com.example.demo.entity.MallGoodsEntity;
import com.example.demo.entity.OrderDetailEntity;
import com.example.demo.entity.OrderEntity;
import com.example.demo.result.ApiConstant;
import com.example.demo.result.ApiResult;
import com.example.demo.service.MallGoodsService;
import com.example.demo.service.OrderDetailService;
import com.example.demo.service.OrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@CrossOrigin
@RestController
@RequestMapping(value = "/mall")
public class OrdersResource {

    private static final Logger logger = LoggerFactory.getLogger(OrdersResource.class);


    @Autowired
    OrdersService ordersService;
    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    MallGoodsService mallGoodsService;

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult submitOrders(HttpServletRequest httpServletRequest) {
        String goods_code = httpServletRequest.getParameter("goods_id");
        String number = httpServletRequest.getParameter("number");
        String userId = httpServletRequest.getParameter("user_id");
        String address_id = httpServletRequest.getParameter("address_id");
        String freight = httpServletRequest.getParameter("freight_price");
        if (StringUtils.isEmpty(goods_code.trim()) || StringUtils.isEmpty(number.trim()) || StringUtils.isEmpty(userId.trim()) || StringUtils.isEmpty(address_id.trim()) || StringUtils.isEmpty(freight)) {
            logger.error("Submit order parameters are empty.goods_code is {},number is {},user_id is {},address_id is {},freight is {} .", goods_code, number, userId, address_id, freight);
            return ApiResult.buildFailure(ApiConstant.CODE_1, "请求参数为空");
        }
        return ordersService.submitOrder(Long.valueOf(goods_code), Integer.valueOf(number), Long.valueOf(userId), Long.valueOf(address_id), new BigDecimal(freight));
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    @ResponseBody
    public ApiResult getOrders(HttpServletRequest httpServletRequest) {
        String userId = httpServletRequest.getParameter("user_id");
        String orderStatus = httpServletRequest.getParameter("order_status");
        Integer pageNo = StringUtils.isEmpty(httpServletRequest.getParameter("pageNo")) ? 1 : Integer.valueOf(httpServletRequest.getParameter("pageNo"));
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(orderStatus)) {
            logger.error("Get order parameter is empty . user_id is {},order_status is {} .", userId, orderStatus);
            return ApiResult.buildFailure(ApiConstant.CODE_1, "请求参数为空");
        }
        if (!ordersService.rangeInDefined(Integer.valueOf(orderStatus), -1, 3)) {
            logger.error("Illegal order status appears, please check if the parameters are legal . order_status is {} .", orderStatus);
            return ApiResult.buildFailure(ApiConstant.CODE_11, "出现非法订单状态,请检查参数是否合法");
        }
        return ordersService.getOrders(Long.valueOf(userId), Integer.valueOf(orderStatus), pageNo, 2);
    }

    @RequestMapping(value = "/cancelOrders", method = RequestMethod.POST)
    public ApiResult cancelOrder(HttpServletRequest httpServletRequest) {
        String orderId = httpServletRequest.getParameter("order_id");
        OrderEntity orderEntity = ordersService.getOrderByOrderId(orderId);
        if (orderEntity.getDeleted()) {
            return ApiResult.buildFailure(ApiConstant.CODE_3, "订单已取消,请勿重复操作");
        }
        OrderDetailEntity orderDetailEntity = orderDetailService.getOrderDetailEntityByOrderId(orderId);
        MallGoodsEntity mallGoodsEntity = mallGoodsService.getMallGoodsEntityById(orderDetailEntity.getId());
        synchronized (mallGoodsEntity) {
            mallGoodsEntity.setStock(mallGoodsEntity.getStock() + orderDetailEntity.getQuantity());
            mallGoodsService.saveMallGoodsEntity(mallGoodsEntity);
        }
        orderEntity.setDeleted(true);
        ordersService.save(orderEntity);
        return ApiResult.buildSuccess();
    }

}
