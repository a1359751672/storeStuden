package cn.tedu.storeStuden.Mapper;

import cn.tedu.storeStuden.entity.Address;
import cn.tedu.storeStuden.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressMapperTest {
    @Autowired
    AddressMapper mapper;



    @Test
    void countByUserId() {
        Integer count = mapper.countByUserId(16);
        System.out.println("该用户共有"+count+"条收货地址");
    }

    @Test
    void saveAddress() {
        Address address = new Address(null,16,"2582532130","云南省",1,"文山州",
                2,"文山市", 3,1323,"文山学院新校区","15559759282","0823-121",
                "学校",0, "管理员",new Date(),"管理员",new Date());
        Integer row = mapper.saveAddress(address);
        System.out.println("row"+row);
    }

    @Test
    void getAddressByUserId() {
        List<Address> list = mapper.getAddressByUserId(16);
        list.forEach(System.out::println);
    }

    @Test
    void updateAddressInfo() {
        Address address = new Address(32,16,"dengxiaol","云南省",530000,"文山壮族苗族自治州",532600,"文山市",null,1,"新校区",
                "1","1","1",0,"2582532130",new Date(),"2582532130",new Date());
        mapper.updateAddressInfo(address);
    }


//    @Test
//    void   updateAddressInfo() {
//        Address address = new Address(30,16,"小龙","云南省",530000,"文山壮族苗族自治州",532600,"文山市",null,1323,"老校区",
//                "19872972903","052-4545","公司",0,"2582532130",new Date(),"2582532130",new Date());
//        mapper.updateAddressInfo(address);
//    }

}