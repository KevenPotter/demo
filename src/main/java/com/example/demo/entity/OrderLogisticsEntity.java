package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "z_order_logistics")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class OrderLogisticsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键ID'")
    private Long id;

    @Column(name = "order_id", columnDefinition = "varchar(50) DEFAULT NULL COMMENT '订单号'")
    private String orderId;

    @Column(name = "order_detail_id", columnDefinition = "bigint(20) DEFAULT NULL COMMENT '订单详情编号'")
    private Long orderDetailId;

    @Column(name = "tracking_num", columnDefinition = "varchar(50) DEFAULT NULL COMMENT '快递单号'")
    private String trackingNum;

    @Column(name = "tracking_name", columnDefinition = "varchar(50) DEFAULT NULL COMMENT '快递名称'")
    private String trackingName;

    @Column(name = "add_time", columnDefinition = "datetime DEFAULT NULL COMMENT '添加时间'")
    private Date addTime;

    @Column(name = "operate_id", columnDefinition = "bigint(20) DEFAULT NULL COMMENT '操作人编号'")
    private Long operateId;

    @Column(name = "operate_name", columnDefinition = "varchar(50) DEFAULT NULL COMMENT '操作人名称'")
    private String operateName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getTrackingNum() {
        return trackingNum;
    }

    public void setTrackingNum(String trackingNum) {
        this.trackingNum = trackingNum;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Long getOperateId() {
        return operateId;
    }

    public void setOperateId(Long operateId) {
        this.operateId = operateId;
    }

    public String getOperateName() {
        return operateName;
    }

    public void setOperateName(String operateName) {
        this.operateName = operateName;
    }

    public String getTrackingName() {
        return trackingName;
    }

    public void setTrackingName(String trackingName) {
        this.trackingName = trackingName;
    }
}
