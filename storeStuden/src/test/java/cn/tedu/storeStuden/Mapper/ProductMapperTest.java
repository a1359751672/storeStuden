package cn.tedu.storeStuden.Mapper;

import cn.tedu.storeStuden.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductMapperTest {
    @Autowired
    ProductMapper mapper;

    @Test
    void listHotProduct() {
        List<Product> list =mapper.listHotProduct();
        list.forEach(System.out::println);
    }

    @Test
    void getById() {
        Product pr = mapper.getById(10000019);
        System.out.println(pr);
    }
}