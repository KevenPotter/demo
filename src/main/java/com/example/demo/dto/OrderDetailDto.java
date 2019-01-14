package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDetailDto {

    private String userName;
    private String mobile;
    private String deliveryAddress;
    private String goodsName;
    private BigDecimal tradePrice;
    private Integer quantity;
    private BigDecimal freightPrice;
    private BigDecimal actualPayment;
    private String trackingNum;
    private Date logisticsCreationTime;
    private String imgUrl;
    private String orderId;
    private Date addTime;
    private String consumerTelephone;

    public String getUserName() {
        return userName;
    }

    public OrderDetailDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public OrderDetailDto setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public OrderDetailDto setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public OrderDetailDto setGoodsName(String goodsName) {
        this.goodsName = goodsName;
        return this;
    }

    public BigDecimal getTradePrice() {
        return tradePrice;
    }

    public OrderDetailDto setTradePrice(BigDecimal tradePrice) {
        this.tradePrice = tradePrice;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderDetailDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public OrderDetailDto setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
        return this;
    }

    public BigDecimal getActualPayment() {
        return actualPayment;
    }

    public OrderDetailDto setActualPayment(BigDecimal actualPayment) {
        this.actualPayment = actualPayment;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public OrderDetailDto setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getTrackingNum() {
        return trackingNum;
    }

    public OrderDetailDto setTrackingNum(String trackingNum) {
        this.trackingNum = trackingNum;
        return this;
    }

    public Date getLogisticsCreationTime() {
        return logisticsCreationTime;
    }

    public OrderDetailDto setLogisticsCreationTime(Date logisticsCreationTime) {
        this.logisticsCreationTime = logisticsCreationTime;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public OrderDetailDto setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public Date getAddTime() {
        return addTime;
    }

    public OrderDetailDto setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }

    public String getConsumerTelephone() {
        return consumerTelephone;
    }

    public OrderDetailDto setConsumerTelephone(String consumerTelephone) {
        this.consumerTelephone = consumerTelephone;
        return this;
    }
}
