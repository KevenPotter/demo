package com.example.demo.dao;

import com.example.demo.page.PageParam;
import com.example.demo.page.PageResult;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

@Repository
public class OrderDetailDao {

    @PersistenceContext
    EntityManager em;

    public PageResult getOrders(PageParam pageParam) {
        Long userId = (Long) pageParam.getParam().get("userId");
        Integer orderStatus = (Integer) pageParam.getParam().get("orderStatus");
        String sql = "SELECT * FROM z_order zo WHERE zo.user_id = " + userId;
        if (-1 != orderStatus) {
            sql += " AND zo.order_status = " + orderStatus;
        }
        sql += " AND zo.deleted IS FALSE ORDER BY zo.add_time DESC limit " + pageParam.getStart() + " , " + pageParam.getLength();
        String countSql = "SELECT count(1) FROM z_order zo WHERE zo.user_id = " + userId;
        Query query = em.createNativeQuery(sql);
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<HashMap<String, String>> orderEntityList = query.getResultList();
        BigInteger totalCount = (BigInteger) em.createNativeQuery(countSql).getSingleResult();
        return new PageResult(orderEntityList, totalCount.intValue(), pageParam.getLength());
    }
}
