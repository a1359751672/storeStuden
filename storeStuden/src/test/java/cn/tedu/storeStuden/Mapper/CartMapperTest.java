package cn.tedu.storeStuden.Mapper;

import cn.tedu.storeStuden.entity.Cart;
import cn.tedu.storeStuden.entity.CartVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CartMapperTest {
@Autowired
CartMapper mapper;
    @Test
    void insertCart() {
        Cart cart = new Cart();
        cart.setUserId(19);
        cart.setProductId(10000019);
        cart.setPrice(BigInteger.valueOf(5426));
        cart.setNum(2);
        mapper.insertCart(cart);
    }

    @Test
    void getByUidAndPid() {
        Cart ca = mapper.getByUidAndPid(18, 10000018);
        System.out.println(ca);
    }

    @Test
    void updateNum() {
        mapper.UpdateNum(1,3,"test",new Date());
    }

    @Test
    void listCart() {
        List<CartVO> l = mapper.listCart(16);
        l.forEach(System.out::println);
    }
}