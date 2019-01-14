package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Path: com.hh.core.entity.z.MallGoodsEntity
 * @Auther: guxin
 * @Date: 2018/12/24 17:29
 * @Description: 商品实体
 */
@Entity
@Table(name = "z_mall_goods")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class MallGoodsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键ID'")
    private Long id;

    @Column(name = "goods_code", columnDefinition = "varchar(50) DEFAULT NULL COMMENT '商品编码'")
    private String goodsCode;

    @Column(name = "goods_name", columnDefinition = "varchar(100) DEFAULT NULL COMMENT '商品名称'")
    private String goodsName;

    @Column(name = "img_url", columnDefinition = "varchar(200) DEFAULT NULL COMMENT '图片地址'")
    private String imgUrl;

    @Column(name = "thum_img_url", columnDefinition = "varchar(200) DEFAULT NULL COMMENT '缩略图'")
    private String thumImgUrl;

    @Column(name = "stock", columnDefinition = "int(11) DEFAULT NULL COMMENT '库存'")
    private Integer stock;

    @Column(name = "unit_price", columnDefinition = "decimal(10,2) DEFAULT NULL COMMENT '单价'")
    private BigDecimal unitPrice;

    @Column(name = "cost_price", columnDefinition = "decimal(10,2) DEFAULT NULL COMMENT '成本价'")
    private BigDecimal costPrice;

    @Column(name = "sale_price", columnDefinition = "decimal(10,2) DEFAULT NULL COMMENT '售价'")
    private BigDecimal salePrice;

    @Column(name = "activity_price", columnDefinition = "decimal(10,2) DEFAULT NULL COMMENT '活动价'")
    private BigDecimal activityPrice;

    @Column(name = "add_time", columnDefinition = "datetime DEFAULT NULL COMMENT '添加时间'")
    private Date addTime;

    @Column(name = "user_id", columnDefinition = "bigint(20) DEFAULT NULL COMMENT '创建人编号'")
    private Long userId;

    @Column(name = "user_name", columnDefinition = "varchar(50) DEFAULT NULL COMMENT '创建人名称'")
    private String userName;

    @Column(name = "des", columnDefinition = "varchar(50) DEFAULT NULL COMMENT '描述'")
    private String des;

    @Column(name = "type", columnDefinition = "int(2) DEFAULT NULL COMMENT ' 卡类型（1.充值卡 2.面值卡）'")
    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getThumImgUrl() {
        return thumImgUrl;
    }

    public void setThumImgUrl(String thumImgUrl) {
        this.thumImgUrl = thumImgUrl;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(BigDecimal activityPrice) {
        this.activityPrice = activityPrice;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
