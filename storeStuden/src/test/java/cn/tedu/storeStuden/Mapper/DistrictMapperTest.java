package cn.tedu.storeStuden.Mapper;

import cn.tedu.storeStuden.entity.District;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DistrictMapperTest {
    @Autowired
    DistrictMapper mapper;


    @Test
    void listByParent() {
        List<District> list = mapper.listByParent("86");
        list.forEach(itme-> System.out.println(itme));
    }

    @Test
    void getCodeByName() {
        Integer code = mapper.getCodeByName("云南省");
        System.out.println(code);
    }
}