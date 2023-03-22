package cn.tedu.storeStuden.Mapper;

import cn.tedu.storeStuden.common.Constant;
import cn.tedu.storeStuden.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired(required = false)
    UserMapper mapper;

    @Test
    void insertUser() {
    User user = new User();
    user.setUsername("test02");
    user.setPassword("test02");
    Integer i = mapper.insertUser(user);
        System.out.println("注册成功，共实效"+i+"行");
    }
    @Test
    void getByName(){
      User user = mapper.getByName("test01");
        System.out.println(user);
    }

    @Test
    void updataUserInfo() {
        User user = new User();
        user.setPhone("13577051669");
        user.setEmail("1359751672@qq.com");
        user.setGender(Constant.USER_GANDER_MALE);
        user.setId(16);
//        mapper.updataUserInfo(user);
        System.out.println("修改成功");
    }

    @Test
    void uploadAvatar() {
        mapper.uploadAvatar(16,"/abc/a.jpg","管理员",new Date());
    }
}