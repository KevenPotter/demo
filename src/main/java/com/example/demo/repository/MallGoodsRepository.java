package com.example.demo.repository;

import com.example.demo.entity.MallGoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MallGoodsRepository extends JpaRepository<MallGoodsEntity, Long>, JpaSpecificationExecutor<MallGoodsEntity> {

    List<MallGoodsEntity> getById(Long id);

}
