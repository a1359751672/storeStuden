package cn.tedu.storeStuden.service;

import cn.tedu.storeStuden.entity.User;

import java.util.Date;

//用户模块的业务接口
public interface IUserService {
//用户注册
    void regist(User user);

//    用户登录
     User login(String username,String password);


    //    修改密码
     Integer modifyPassword(String username, String oldPassword, String newPassword);

//     修改个人信息
    Integer changeUserInfo(String username,User user);

//    上传头像
    void changeAvatar(String username,String avatar);
}
