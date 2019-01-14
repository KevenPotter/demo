package com.example.demo.repository;

import com.example.demo.entity.OrderAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderAddressRepository extends JpaRepository<OrderAddressEntity, Long>, JpaSpecificationExecutor<OrderAddressEntity> {

    //查询用户所有收货地址
    List<OrderAddressEntity> findOrderAddressEntitiesByUserIdAndIsDelete(Long userId, Integer isDelete);

    //查询用户默认地址
    OrderAddressEntity findOrderAddressEntitiesByUserIdAndIsDefault(Long userId, Integer isDefault);

    /**
     * @param addressId {}
     * @param userId    {}
     * @return {}
     * @author {}
     */
    List<OrderAddressEntity> getByIdAndUserId(Long addressId, Long userId);

}
