package com.example.demo.service;

import com.example.demo.entity.OrderAddressEntity;
import com.example.demo.repository.OrderAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(rollbackFor = Exception.class)
public class OrderAddressService {

    @Autowired
    private OrderAddressRepository orderAddressRepository;

    public OrderAddressEntity getOrderAddressByAddressId(Long addressId, Long userId) {
        List<OrderAddressEntity> orderAddressEntityList = orderAddressRepository.getByIdAndUserId(addressId, userId);
        if (0 == orderAddressEntityList.size()) return null;
        return orderAddressEntityList.get(0);
    }

}
