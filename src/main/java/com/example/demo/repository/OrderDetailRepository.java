package com.example.demo.repository;

import com.example.demo.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long>, JpaSpecificationExecutor<OrderDetailEntity> {

    /**
     * @param orderId {订单编号}
     * @return {返回订单详情实体}
     * @author {KevenPotter}
     * @date {}
     * @description {}
     * @description {}
     */
    List<OrderDetailEntity> getByOrderId(String orderId);
}
