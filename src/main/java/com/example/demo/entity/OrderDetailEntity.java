package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "z_order_detail")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class OrderDetailEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键ID'")
    private Long id;

    @Column(name = "order_id", columnDefinition = "varchar(50) DEFAULT NULL COMMENT '订单号'")
    private String orderId;

    @Column(name = "goods_id", columnDefinition = "bigint(20) DEFAULT NULL COMMENT '商品编号'")
    private Long goodsId;

    @Column(name = "goods_name", columnDefinition = "varchar(50) DEFAULT NULL COMMENT '商品名称'")
    private String goodsName;

    @Column(name = "quantity", columnDefinition = "int(5) DEFAULT NULL COMMENT '购买数量'")
    private Integer quantity;

    @Column(name = "unit_price", columnDefinition = "decimal(10,2) DEFAULT NULL COMMENT '商品价格'")
    private BigDecimal unitPrice;

    @Column(name = "trade_price", columnDefinition = "decimal(10,2) DEFAULT NULL COMMENT '商品实际售价'")
    private BigDecimal tradePrice;

    @Column(name = "freight_price", columnDefinition = "decimal(10,2) DEFAULT NULL COMMENT '运费'")
    private BigDecimal freightPrice;

    @Column(name = "coupon_price", columnDefinition = "decimal(10,2) DEFAULT NULL COMMENT '优惠券金额'")
    private BigDecimal couponPrice;

    @Column(name = "add_time", columnDefinition = "datetime DEFAULT NULL COMMENT '创建时间'")
    private Date addTime;

    @Column(name = "img_url", columnDefinition = "varchar(200) DEFAULT NULL COMMENT '图片地址'")
    private String imgUrl;

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

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(BigDecimal tradePrice) {
        this.tradePrice = tradePrice;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
