package com.example.demo.service;

import com.example.demo.dao.OrderLogisticsDao;
import com.example.demo.entity.OrderLogisticsEntity;
import com.example.demo.repository.OrderLogisticsRepository;
import com.example.demo.result.ApiConstant;
import com.example.demo.result.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(rollbackFor = Exception.class)
public class OrderLogisticsService {

    @Autowired
    private OrderLogisticsRepository orderLogisticsRepository;
    @Autowired
    private OrderLogisticsDao orderLogisticsDao;


    public OrderLogisticsEntity getOrderLogisticsEntityByOrderId(String orderId) {
        List<OrderLogisticsEntity> orderLogisticsEntityList = orderLogisticsRepository.getByOrderId(orderId);
        if (0 == orderLogisticsEntityList.size()) return null;
        return orderLogisticsEntityList.get(0);
    }
}
