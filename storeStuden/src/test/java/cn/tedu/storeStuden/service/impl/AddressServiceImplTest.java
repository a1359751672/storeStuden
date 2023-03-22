package cn.tedu.storeStuden.service.impl;

import cn.tedu.storeStuden.Mapper.AddressMapper;
import cn.tedu.storeStuden.entity.Address;
import cn.tedu.storeStuden.service.IAddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressServiceImplTest {
    @Autowired
    IAddressService service;

    @Test
    void createAddress() {
        Address address = new Address(null,12,"李某","云南省",1,"文山州",
                2,"文山市", 3,1323,"文山学院新校区","15559759282","0823-121",
                "学校",0, "管理员",new Date(),"管理员",new Date());
        service.createAddress(3,"2582532130",address);
        System.out.println("添加成功");
    }

    @Test
    void finAddressLiset() {
        List<Address> lis = service.finAddressList(16);
        for (Address address:lis){
            System.out.println(address);
        }
    }


    @Test
    void removeAddress() {
        service.removeAddress(29,16);
    }


    @Test
    void testUpdateAddressList() {
        Address address = new Address(32,16,"da龙","云南省",530000,"文山壮族苗族自治州",532600,"文山市",null,1323,"老校区",
                "19872972903","052-4545","公司",0,"2582532130",new Date(),"2582532130",new Date());
        service.updateAddressList(30,16,address);
    }

//    @Test
//    void updateAddressList() {
//        List<Address> address = service.updateAddressList(30,16);
//        System.out.println(address);
//    }
}