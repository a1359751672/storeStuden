package cn.tedu.storeStuden.service.impl;

import cn.tedu.storeStuden.entity.CartVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartServiceImplTest {
    @Autowired
    CartServiceImpl service;
    @Test
    void createdCart() {
        service.createdCart(10000017,2,19,"2582532130");
    }

    @Test
    void findCartList() {
        List<CartVO> cartlist = service.findCartList(16);
        System.out.println(cartlist);
    }
}