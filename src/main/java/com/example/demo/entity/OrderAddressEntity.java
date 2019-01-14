package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "z_order_address")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class OrderAddressEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键ID'")
    private Long id;

    @Column(name = "user_id", columnDefinition = "bigint(20) comment '用户编号'")
    private Long userId;

    @Column(name = "province_id", columnDefinition = "int(11) DEFAULT NULL COMMENT '省份编号'")
    private Integer provinceId;

    @Column(name = "city_id", columnDefinition = "int(11) DEFAULT NULL COMMENT '城市编号'")
    private Integer cityId;

    @Column(name = "county_id", columnDefinition = "int(11) DEFAULT NULL COMMENT '地区编号'")
    private Integer countyId;

    @Column(name = "province_name", columnDefinition = "varchar(50) DEFAULT NULL COMMENT '省份名称'")
    private String provinceName;

    @Column(name = "city_name", columnDefinition = "varchar(50) DEFAULT NULL COMMENT '城市名称'")
    private String cityName;

    @Column(name = "county_name", columnDefinition = "varchar(50) DEFAULT NULL COMMENT '地区名称'")
    private String countyName;

    @Column(name = "detailed", columnDefinition = "varchar(100) DEFAULT NULL COMMENT '详细地址'")
    private String detailed;

    @Column(name = "user_name", columnDefinition = "varchar(100) DEFAULT NULL COMMENT '收货人名称'")
    private String userName;

    @Column(name = "mobile", columnDefinition = "varchar(20) DEFAULT NULL COMMENT '手机号'")
    private String mobile;

    @Column(name = "is_delete", columnDefinition = "int(1) DEFAULT NULL COMMENT '是否删除(0.已删除 1.使用中)'")
    private Integer isDelete;

    @Column(name = "is_default", columnDefinition = "int(1) DEFAULT NULL COMMENT '是否为默认地址(0.否 1.是)'")
    private Integer isDefault;

    @Column(name = "add_time", columnDefinition = "datetime DEFAULT NULL COMMENT '创建时间'")
    private Date addTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCountyId() {
        return countyId;
    }

    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
