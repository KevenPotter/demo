package com.example.demo.service;

import com.example.demo.dao.OrderDetailDao;
import com.example.demo.dto.OrderDetailDto;
import com.example.demo.entity.OrderAddressEntity;
import com.example.demo.entity.OrderDetailEntity;
import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.OrderLogisticsEntity;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.result.ApiConstant;
import com.example.demo.result.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrderAddressService orderAddressService;
    @Autowired
    OrderLogisticsService orderLogisticsService;

    /**
     * @param orderDetailEntity {订单详情实体}
     * @author {KevenPotter}
     * @date {}
     * @description {}
     * @description {}
     */
    public void saveOrderDetailEntity(OrderDetailEntity orderDetailEntity) {
        orderDetailRepository.save(orderDetailEntity);
    }

    /**
     * @param orderId {}
     * @return {}
     * @author {KevenPotter}
     * @date {}
     * @description {}
     * @description {}
     */
    public OrderDetailEntity getOrderDetailEntityByOrderId(String orderId) {
        return orderDetailRepository.getByOrderId(orderId).get(0);
    }

    public ApiResult getOrderDetails(String orderId, long userId) {
        OrderEntity orderEntity = ordersService.getOrderByOrderId(orderId);
        if (orderEntity == null) return ApiResult.buildFailure(ApiConstant.CODE_3, "未获取到订单信息");
        List<OrderDetailEntity> orderDetailEntityList = orderDetailRepository.getByOrderId(orderId);
        if (0 == orderDetailEntityList.size()) return ApiResult.buildFailure(ApiConstant.CODE_3, "未获取到订单详情信息");
        OrderDetailEntity orderDetailEntity = orderDetailEntityList.get(0);
        long addressId = orderEntity.getAddressId();
        OrderAddressEntity orderAddressEntity = orderAddressService.getOrderAddressByAddressId(addressId, userId);
        if (orderAddressEntity == null) return ApiResult.buildFailure(ApiConstant.CODE_3, "未获取到该用户的地址信息");
        OrderLogisticsEntity orderLogisticsEntity = orderLogisticsService.getOrderLogisticsEntityByOrderId(orderId);
        orderLogisticsEntity = orderLogisticsEntity == null ? new OrderLogisticsEntity() : orderLogisticsEntity;
        OrderDetailDto orderDetailDto = new OrderDetailDto()
                .setUserName(orderAddressEntity.getUserName())
                .setMobile(orderAddressEntity.getMobile())
                .setDeliveryAddress(orderAddressEntity.getProvinceName() + orderAddressEntity.getCityName() + orderAddressEntity.getCountyName() + orderAddressEntity.getDetailed())
                .setGoodsName(orderDetailEntity.getGoodsName())
                .setTradePrice(orderDetailEntity.getTradePrice())
                .setQuantity(orderDetailEntity.getQuantity())
                .setFreightPrice(orderDetailEntity.getFreightPrice())
                .setActualPayment(orderDetailEntity.getTradePrice().multiply(BigDecimal.valueOf(orderDetailEntity.getQuantity())).add(orderDetailEntity.getFreightPrice()))
                .setImgUrl(orderDetailEntity.getImgUrl())
                .setTrackingNum(orderLogisticsEntity.getTrackingNum())
                .setLogisticsCreationTime(orderLogisticsEntity.getAddTime())
                .setOrderId(orderEntity.getOrderId())
                .setAddTime(orderEntity.getAddTime())
                .setConsumerTelephone("4006508095");
        return ApiResult.buildSussess(orderDetailDto);
    }

}
