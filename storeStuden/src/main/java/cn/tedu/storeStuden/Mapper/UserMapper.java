package cn.tedu.storeStuden.Mapper;

import cn.tedu.storeStuden.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface UserMapper {
//    添加用户信息
    Integer insertUser(User user);
//    根据用户名查询用户信息
    User getByName(String username);

    //    根据账号密码相同时，修改密码
    Integer updataPassword(Integer id, String password,Date modifiedTime,String modifiedUser);

//    登录账号时，修改个人信息
    Integer updataUserInfo(User user);

//    上传头像
    Integer uploadAvatar(Integer id,String avatar,String modifiedUser, Date modifiedTime);

}
