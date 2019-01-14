package com.example.demo.controller;

import com.example.demo.result.ApiConstant;
import com.example.demo.result.ApiResult;
import com.example.demo.service.OrderDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping(value = "/mall")
public class OrderDetailResource {

    private static final Logger logger = LoggerFactory.getLogger(OrderDetailResource.class);

    @Autowired
    OrderDetailService orderDetailService;

    @RequestMapping(value = "/orderDetails", method = RequestMethod.GET)
    @ResponseBody
    public ApiResult getOrderDetails(HttpServletRequest httpServletRequest) {
        String orderId = httpServletRequest.getParameter("order_id");
        String userId = httpServletRequest.getParameter("user_id");
        if (StringUtils.isEmpty(orderId) || StringUtils.isEmpty(userId)) {
            logger.error("Submit order parameters are empty.order_id is {},user_id is {} .", orderId, userId);
            return ApiResult.buildFailure(ApiConstant.CODE_1, "请求参数为空");
        }
        return orderDetailService.getOrderDetails(orderId, Long.valueOf(userId));
    }

}

