package com.example.demo.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Yan on 7/19/17.
 */
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /*用户的昵称*/
    @Column(name = "wx_name", columnDefinition = "varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL comment '用户的昵称'")
    private String wxName;
    /*用户的标识，对当前公众号唯一*/
    @Column(name = "wx_open_id", columnDefinition = "varchar(255) DEFAULT NULL comment '用户的标识，对当前公众号唯一'")
    private String wxOpenId;
    /*用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。*/
    @Column(name = "wx_icon", columnDefinition = "varchar(255) DEFAULT NULL comment '用户头像'")
    private String wxIcon;
    /**/
    @Column(name = "wx_subscribe_ts", columnDefinition = "datetime DEFAULT NULL comment '用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间'")
    private Date wxSubscribeTs;

    @Column(name = "wx_subscribed", columnDefinition = "bit(1) NOT NULL comment '用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息'")
    private boolean wxSubscribed;
    /**/
    @Column(name = "sex", columnDefinition = "varchar(255) DEFAULT NULL comment '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知'")
    private String sex;
    /**/
    @Column(name = "city", columnDefinition = "varchar(255) DEFAULT NULL comment '用户所在城市'")
    private String city;
    /**/
    @Column(name = "country", columnDefinition = "varchar(255) DEFAULT NULL comment '用户所在国家'")
    private String country;

    @Column(name = "province", columnDefinition = "varchar(255) DEFAULT NULL comment '用户所在省份'")
    private String province;

    @Column(name = "language", columnDefinition = "varchar(255) DEFAULT NULL comment '用户的语言，简体中文为zh_CN'")
    private String language;

    @Column(name = "unionid", columnDefinition = "varchar(255) DEFAULT NULL comment '只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段'")
    private String unionid;

    @Column(name = "remark", columnDefinition = "varchar(255) DEFAULT NULL comment '公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注'")
    private String remark;

    @Column(name = "groupid", columnDefinition = "varchar(255) DEFAULT NULL comment '用户所在的分组ID(兼容旧的用户分组接口)'")
    private String groupid;

    @Column(name = "tagid_list", columnDefinition = "varchar(255) DEFAULT NULL comment '用户被打上的标签ID列表'")
    private String tagidList;

    @Column(name = "subscribe_scene", columnDefinition = "varchar(255) DEFAULT NULL comment '返回用户关注的渠道来源'")
    private String subscribeScene;

    @Column(name = "qr_scene", columnDefinition = "varchar(255) DEFAULT NULL comment '二维码扫码场景(开发者自定义)'")
    private String qr_scene;

    @Column(name = "qr_scene_str", columnDefinition = "varchar(255) DEFAULT NULL comment '二维码扫码场景描述(开发者自定义)'")
    private String qr_scene_str;

    @Column(name = "balance", columnDefinition = "double NOT NULL comment '用户余额'")
    private double balance;

    @Column(name = "coupon", columnDefinition = "double NOT NULL comment '优惠券'")
    private double coupon;

    @Column(name = "credit", columnDefinition = "int(11) NOT NULL comment '信誉'")
    private int credit;

    @Column(name = "is_admin", columnDefinition = "bit(1) NOT NULL comment '是否为管理员'")
    private boolean isAdmin;

    @Column(name = "is_agent", columnDefinition = "bit(1) NOT NULL comment '是否为代理商'")
    private boolean isAgent;

    @Column(name = "is_partner", columnDefinition = "bit(1) NOT NULL comment '是否为合作商'")
    private boolean isPartner;

    @Column(name = "nature", columnDefinition = "int(1) default 0 comment '会员类别（0 普通会员；1 测试用户）'")
    private int nature;
    /*礼金*/
    @Column(name = "virtual_amount", columnDefinition = "decimal(10,2) default 0 comment '虚拟余额'")
    private BigDecimal virtualAmount;
    /**
     * 余额
     */
    @Column(name = "integral", columnDefinition = "int(11) default 0 comment '积分'")
    private Integer integral;
    /**
     * 手机号
     */
    @Column(name = "mobile", columnDefinition = "varchar(20) ")
    private String mobile;
    /**
     * 是否为企业用户（0.否 1.是）
     */
    @Column(name = "is_business_user", columnDefinition = "int(1) default 0")
    private Integer isBusinessUser;
    /**
     * 企业编号
     */
    @Column(name = "business_no", columnDefinition = "varchar(32) ")
    private String businessNo;
    /**
     * 手机号百绑定时间
     */
    @Column(name = "binding_time", columnDefinition = "datetime")
    private Date bindingTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public String getWxIcon() {
        return wxIcon;
    }

    public void setWxIcon(String wxIcon) {
        this.wxIcon = wxIcon;
    }

    public Date getWxSubscribeTs() {
        return wxSubscribeTs;
    }

    public void setWxSubscribeTs(Date wxSubscribeTs) {
        this.wxSubscribeTs = wxSubscribeTs;
    }

    public boolean isWxSubscribed() {
        return wxSubscribed;
    }

    public void setWxSubscribed(boolean wxSubscribed) {
        this.wxSubscribed = wxSubscribed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getTagidList() {
        return tagidList;
    }

    public void setTagidList(String tagidList) {
        this.tagidList = tagidList;
    }

    public String getSubscribeScene() {
        return subscribeScene;
    }

    public void setSubscribeScene(String subscribeScene) {
        this.subscribeScene = subscribeScene;
    }

    public String getQr_scene() {
        return qr_scene;
    }

    public void setQr_scene(String qr_scene) {
        this.qr_scene = qr_scene;
    }

    public String getQr_scene_str() {
        return qr_scene_str;
    }

    public void setQr_scene_str(String qr_scene_str) {
        this.qr_scene_str = qr_scene_str;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCoupon() {
        return coupon;
    }

    public void setCoupon(double coupon) {
        this.coupon = coupon;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isAgent() {
        return isAgent;
    }

    public void setAgent(boolean agent) {
        isAgent = agent;
    }

    public boolean isPartner() {
        return isPartner;
    }

    public void setPartner(boolean partner) {
        isPartner = partner;
    }

    public int getNature() {
        return nature;
    }

    public void setNature(int nature) {
        this.nature = nature;
    }

    public BigDecimal getVirtualAmount() {
        return virtualAmount;
    }

    public void setVirtualAmount(BigDecimal virtualAmount) {
        this.virtualAmount = virtualAmount;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getIsBusinessUser() {
        return isBusinessUser;
    }

    public void setIsBusinessUser(Integer isBusinessUser) {
        this.isBusinessUser = isBusinessUser;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public Date getBindingTime() {
        return bindingTime;
    }

    public void setBindingTime(Date bindingTime) {
        this.bindingTime = bindingTime;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", wxName='" + wxName + '\'' +
                ", wxOpenId='" + wxOpenId + '\'' +
                ", wxIcon='" + wxIcon + '\'' +
                ", wxSubscribeTs=" + wxSubscribeTs +
                ", wxSubscribed=" + wxSubscribed +
                ", sex='" + sex + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", language='" + language + '\'' +
                ", unionid='" + unionid + '\'' +
                ", remark='" + remark + '\'' +
                ", groupid='" + groupid + '\'' +
                ", tagidList='" + tagidList + '\'' +
                ", subscribeScene='" + subscribeScene + '\'' +
                ", qr_scene='" + qr_scene + '\'' +
                ", qr_scene_str='" + qr_scene_str + '\'' +
                ", balance=" + balance +
                ", coupon=" + coupon +
                ", credit=" + credit +
                ", isAdmin=" + isAdmin +
                ", isAgent=" + isAgent +
                ", isPartner=" + isPartner +
                '}';
    }
}
