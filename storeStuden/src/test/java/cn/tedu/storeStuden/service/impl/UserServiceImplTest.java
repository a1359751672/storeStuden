package cn.tedu.storeStuden.service.impl;

import cn.tedu.storeStuden.common.Constant;
import cn.tedu.storeStuden.entity.User;
import cn.tedu.storeStuden.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    IUserService service;

    @Test
    void regist() {
        User user = new User();
        user.setUsername("2582532130");
        user.setPassword("2582532130");
        service.regist(user);
        System.out.println("添加用户数据成功！");
    }

    @Test
    void login() {
        service.login("Tom", "1234");
    }


    @Test
    void modifyPassword() {
        service.modifyPassword("2582532130","12345","2582532130");
        System.out.println("修改成功");
    }

    @Test
    void changeUserInfo() {
        User user = new User();
        user.setPhone("13577051669");
        user.setEmail("1359751672@qq.com");
        user.setGender(Constant.USER_GANDER_MALE);
        service.changeUserInfo("132134",user);
        user.setId(15);
        System.out.println("修改成功");
    }

    @Test
    void changeAvatar() {
        service.changeAvatar("2582532130","/aaa/a.png");
    }
}