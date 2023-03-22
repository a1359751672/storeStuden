package cn.tedu.storeStuden.entity;

import java.math.BigInteger;
import java.util.Objects;

//存放在购物车列表对象
public class CartVO {
    private Integer id;
    private Integer pid;
    private String image;
    private String title;
    private BigInteger realPrice;
    private BigInteger price;
    private Integer num;

    @Override
    public String toString() {
        return "CartVO{" +
                "id=" + id +
                ", pid=" + pid +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", realPrice=" + realPrice +
                ", price=" + price +
                ", num=" + num +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartVO cartVO = (CartVO) o;
        return Objects.equals(id, cartVO.id) && Objects.equals(pid, cartVO.pid) && Objects.equals(image, cartVO.image) && Objects.equals(title, cartVO.title) && Objects.equals(realPrice, cartVO.realPrice) && Objects.equals(price, cartVO.price) && Objects.equals(num, cartVO.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pid, image, title, realPrice, price, num);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigInteger getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(BigInteger realPrice) {
        this.realPrice = realPrice;
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
}
