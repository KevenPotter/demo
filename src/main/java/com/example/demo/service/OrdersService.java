package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.constant.HttpResponseStatus;
import com.example.demo.dao.OrderDetailDao;
import com.example.demo.entity.MallGoodsEntity;
import com.example.demo.entity.OrderDetailEntity;
import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.page.PageParam;
import com.example.demo.page.PageResult;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.result.ApiConstant;
import com.example.demo.result.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class OrdersService {

    private static Logger logger = LoggerFactory.getLogger(OrdersService.class);

    @Autowired
    MallGoodsService mallGoodsService;
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    OrderDetailDao orderDetailDao;
    @Autowired
    UserService userService;


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public ApiResult submitOrder(Long goods_id, Integer number, Long userId, Long addressId, BigDecimal freight) {
        MallGoodsEntity mallGoodsEntity = mallGoodsService.getMallGoodsEntityById(goods_id);
        if (mallGoodsEntity == null) return ApiResult.buildFailure(ApiConstant.CODE_3, "未获取到商品信息");
        UserEntity userEntity = userService.getUserById(userId);
        OrderEntity orderEntity = new OrderEntity();
        OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
        synchronized (goods_id) {
            // 验证库存是否足够
            if (number > mallGoodsEntity.getStock()) {
                return null;
            }
            mallGoodsEntity.setStock(mallGoodsEntity.getStock() - number);
            mallGoodsService.saveMallGoodsEntity(mallGoodsEntity);
        }
        this.addOrderInformation(orderEntity, mallGoodsEntity, userEntity, orderDetailEntity, number, addressId, freight);
        return new ApiResult();
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    void addOrderInformation(OrderEntity orderEntity, MallGoodsEntity mallGoodsEntity, UserEntity userEntity, OrderDetailEntity orderDetailEntity, Integer number, Long addressId, BigDecimal freight) {
        orderEntity.setOrderId(createOrderId(userEntity.getId()));
        orderEntity.setUserId(userEntity.getId());
        orderEntity.setUserName(userEntity.getWxName());
        orderEntity.setAddressId(addressId);
        orderEntity.setAddTime(new Date());
        orderEntity.setAllPrice(mallGoodsEntity.getUnitPrice().multiply(new BigDecimal(number)).add(freight));
        orderEntity.setGoodsAllPrice(mallGoodsEntity.getUnitPrice().multiply(new BigDecimal(number)));
        orderEntity.setGoodsFactPrice(mallGoodsEntity.getSalePrice().multiply(new BigDecimal(number)));
        orderEntity.setCouponPrice(new BigDecimal(0.0));
        orderEntity.setFreightPrice(freight);
        orderEntity.setOrderStatus(0);
        orderEntity.setConfirmTime(null);
        ordersRepository.save(orderEntity);
        orderDetailEntity.setOrderId(orderEntity.getOrderId());
        orderDetailEntity.setGoodsId(mallGoodsEntity.getId());
        orderDetailEntity.setGoodsName(mallGoodsEntity.getGoodsName());
        orderDetailEntity.setQuantity(number);
        orderDetailEntity.setUnitPrice(mallGoodsEntity.getUnitPrice());
        orderDetailEntity.setTradePrice(mallGoodsEntity.getSalePrice());
        orderDetailEntity.setFreightPrice(freight);
        orderDetailEntity.setAddTime(new Date());
        orderDetailEntity.setCouponPrice(new BigDecimal(0.0));
        orderDetailService.saveOrderDetailEntity(orderDetailEntity);
    }

    /**
     * @param memberId
     * @return
     */
    public String createOrderId(Long memberId) {
        if (memberId == null) {
            return null;
        }
        String orderId = "";
        int length = memberId.toString().length();
        if (length < 10) {
            int size = 10 - length;
            for (int i = 0; i < size; i++) {
                orderId += "0";
            }
        }
        orderId = orderId + memberId + System.currentTimeMillis();
        return orderId;
    }

    /**
     * @param userId
     * @param orderStatus
     * @param pageNo
     * @param size
     * @return
     */
    public ApiResult getOrders(Long userId, Integer orderStatus, Integer pageNo, Integer size) {
        PageParam pageParam = new PageParam();
        pageParam.setStart((pageNo - 1) * size);
        pageParam.setLength(size);
        pageParam.setParam("userId", userId);
        pageParam.setParam("orderStatus", orderStatus);
        PageResult pageResult = orderDetailDao.getOrders(pageParam);
        List<HashMap<String, String>> orderEntityList = (List<HashMap<String, String>>) pageResult.getData();
        List<OrderDetailEntity> orderDetailEntityList = new ArrayList<>(10);
        if (0 == orderEntityList.size()) return ApiResult.buildFailure(ApiConstant.CODE_3, "未获取到目标信息");
        for (HashMap<String, String> orderEntity : orderEntityList) {
            OrderDetailEntity orderDetailEntity = orderDetailService.getOrderDetailEntityByOrderId(orderEntity.get("order_id"));
            orderDetailEntityList.add(orderDetailEntity);
        }
        return ApiResult.buildSussess(orderDetailEntityList);
    }

    public boolean rangeInDefined(int current, int min, int max) {
        return Math.max(min, current) == Math.min(current, max);
    }

    public OrderEntity getOrderByOrderId(String orderId) {
        List<OrderEntity> orderEntityList = ordersRepository.getByOrderId(orderId);
        if (0 == orderEntityList.size()) {
            return null;
        }
        return orderEntityList.get(0);
    }

    public void save(OrderEntity orderEntity) {
        ordersRepository.save(orderEntity);
    }

}
