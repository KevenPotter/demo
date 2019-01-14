package com.example.demo.repository;

import com.example.demo.entity.OrderLogisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLogisticsRepository extends JpaRepository<OrderLogisticsEntity, Long>, JpaSpecificationExecutor<OrderLogisticsEntity> {
    List<OrderLogisticsEntity> getByOrderId(String orderId);
}
