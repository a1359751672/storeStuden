package cn.tedu.storeStuden.service.impl;

import cn.tedu.storeStuden.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    ProductServiceImpl service;

    @Test
    void findHotList() {
        List<Product> list =service.findHotList();
        System.out.println(list);
    }

    @Test
    void findById() {
        Product pr = service.findById(10000019);
        System.out.println(pr);
    }
}