package com.example.demo.service;

import com.example.demo.entity.MallGoodsEntity;
import com.example.demo.repository.MallGoodsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Pattern;

@Service
@Transactional
public class MallGoodsService {

    private static Logger logger = LoggerFactory.getLogger(MallGoodsService.class);

    @Autowired
    MallGoodsRepository mallGoodsRepository;

    public MallGoodsEntity getMallGoodsEntityById(Long id) {
        List<MallGoodsEntity> mallGoodsEntityList = mallGoodsRepository.getById(id);
        if (0 == mallGoodsEntityList.size()) {
            return null;
        }
        return mallGoodsEntityList.get(0);
    }

    public void saveMallGoodsEntity(MallGoodsEntity mallGoodsEntity) {
        mallGoodsRepository.save(mallGoodsEntity);
    }
}
