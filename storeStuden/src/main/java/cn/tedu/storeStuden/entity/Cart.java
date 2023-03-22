package cn.tedu.storeStuden.entity;

import java.math.BigInteger;
import java.util.Date;

public class Cart {
    private Integer id;
    private Integer userId;
    private Integer productId;
    private BigInteger price;
    private Integer num;
    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;

    public Cart(Integer id, Integer userId, Integer productId, BigInteger price, Integer num, String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.price = price;
        this.num = num;
        this.createdUser = createdUser;
        this.createdTime = createdTime;
        this.modifiedUser = modifiedUser;
        this.modifiedTime = modifiedTime;
    }

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", price=" + price +
                ", num=" + num +
                ", createdUser='" + createdUser + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
