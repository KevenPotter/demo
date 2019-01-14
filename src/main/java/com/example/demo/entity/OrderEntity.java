package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Path: com.hh.core.entity.z.OrderEntity
 * @Auther: guxin
 * @Date: 2018/12/24 17:44
 * @Description: 订单实体
 */
@Entity
@Table(name = "z_order")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "order_id", columnDefinition = "varchar(50) NOT NULL COMMENT '订单号'")
    private String orderId;

    @Column(name = "user_id", columnDefinition = "bigint(20) DEFAULT NULL COMMENT '用户编号'")
    private Long userId;

    @Column(name = "user_name", columnDefinition = "varchar(50) DEFAULT NULL COMMENT '用户名称'")
    private String userName;

    @Column(name = "address_id", columnDefinition = "bigint(20) DEFAULT NULL COMMENT '地址编号'")
    private Long addressId;

    @Column(name = "add_time", columnDefinition = "datetime DEFAULT NULL COMMENT '创建时间'")
    private Date addTime;

    @Column(name = "all_price", columnDefinition = "decimal(10,2) DEFAULT NULL COMMENT '订单总金额'")
    private BigDecimal allPrice;

    @Column(name = "goods_all_price", columnDefinition = "decimal(10,2) DEFAULT NULL COMMENT '商品总金额'")
    private BigDecimal goodsAllPrice;

    @Column(name = "goods_fact_price", columnDefinition = "decimal(10,2) DEFAULT NULL COMMENT '商品实际价格'")
    private BigDecimal goodsFactPrice;

    @Column(name = "coupon_price", columnDefinition = "decimal(10,2) DEFAULT NULL COMMENT '优惠卷金额'")
    private BigDecimal couponPrice;

    @Column(name = "freight_price", columnDefinition = "decimal(10,2) DEFAULT NULL COMMENT '运费'")
    private BigDecimal freightPrice;

    @Column(name = "order_status", columnDefinition = "int(2) DEFAULT NULL COMMENT '订单状态(0.待支付 1.已付款[代发货] 2.已发货[待收货] 3.已收货[订单完成])'")
    private Integer orderStatus;

    @Column(name = "confirm_time", columnDefinition = "datetime DEFAULT NULL COMMENT '确认收货时间'")
    private Date confirmTime;

    @Column(name = "deleted", columnDefinition = "bit(1) NOT NULL comment '用户是否取消订单[0:未取消订单,1:已取消订单]'")
    private boolean deleted;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public BigDecimal getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(BigDecimal allPrice) {
        this.allPrice = allPrice;
    }

    public BigDecimal getGoodsAllPrice() {
        return goodsAllPrice;
    }

    public void setGoodsAllPrice(BigDecimal goodsAllPrice) {
        this.goodsAllPrice = goodsAllPrice;
    }

    public BigDecimal getGoodsFactPrice() {
        return goodsFactPrice;
    }

    public void setGoodsFactPrice(BigDecimal goodsFactPrice) {
        this.goodsFactPrice = goodsFactPrice;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderId='" + orderId + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", addressId=" + addressId +
                ", addTime=" + addTime +
                ", allPrice=" + allPrice +
                ", goodsAllPrice=" + goodsAllPrice +
                ", goodsFactPrice=" + goodsFactPrice +
                ", couponPrice=" + couponPrice +
                ", freightPrice=" + freightPrice +
                ", orderStatus=" + orderStatus +
                ", confirmTime=" + confirmTime +
                ", isDeleted=" + deleted +
                '}';
    }
}
