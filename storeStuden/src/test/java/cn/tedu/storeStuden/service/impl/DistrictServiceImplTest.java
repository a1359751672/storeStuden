package cn.tedu.storeStuden.service.impl;

import cn.tedu.storeStuden.Mapper.DistrictMapper;
import cn.tedu.storeStuden.entity.District;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DistrictServiceImplTest {
    @Autowired
    DistrictServiceImpl service;

//    @Test
//    void findNameByCode() {
//        String name = service.findNameByCode("120000");
//        System.out.println(name);
//    }

    @Test
    void findByParent() {
        List<District> list = service.findByParent("86");
        list.forEach(itme-> System.out.println(itme));
    }
}