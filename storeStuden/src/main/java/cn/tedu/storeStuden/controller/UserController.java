package cn.tedu.storeStuden.controller;

import cn.tedu.storeStuden.common.Constant;
import cn.tedu.storeStuden.entity.JsonResult;
import cn.tedu.storeStuden.entity.User;
import cn.tedu.storeStuden.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService service;

//    注册用户信息
    @RequestMapping("/regist")
    public JsonResult<Void> regist(User user){
        service.regist(user);
        return new JsonResult<>(1000,"OK");
    }

//    用户登录
    @RequestMapping("/login")
    public JsonResult<Void> login(String username, String password, HttpServletRequest req){
        User user = service.login(username, password);
        HttpSession session = req.getSession();
        session.setAttribute("user",user);
        return JsonResult.getSuccessJR();
    }

//
    @RequestMapping("/findUserInfo")
    public JsonResult<User> findUserInfo(HttpServletRequest req){
//        获取用户对应的session对象，如果不存在则不创建新的session对象
        HttpSession session = req.getSession(false);
//        未登录
        if (session == null||session.getAttribute("user")==null){
            return Constant.JR_NOT_LOGGEDIN;
        }
        User user = (User) session.getAttribute("user");
        return JsonResult.getSuccessJR(user);
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        获取登录对象并销毁
        req.getSession().invalidate();
//       重定向 退出登录回到login页面
        resp.sendRedirect("/web/login.html");
    }

        @RequestMapping("/modifyPassword")
        public JsonResult<Void> modifyPassword(String oldPassword, String newPassword,HttpSession session){
            User user =(User) session.getAttribute("user");
            if (user==null){
                return new JsonResult<>(2005,"登录已失效");
            }
            service.modifyPassword(user.getUsername(), oldPassword,newPassword);
            return JsonResult.getSuccessJR();
        }

//        修改个人信息
    @RequestMapping("/changeUserInfo")
    public JsonResult<User> changeUserInfo(User user,HttpSession session){
        User u = (User) session.getAttribute("user");
        if (u==null){
            return new JsonResult<>(2005,"登录已失效");
        }
        user.setId(u.getId());
        user.setModifiedUser(u.getModifiedUser());
        service.changeUserInfo(u.getUsername(),user);
        return JsonResult.getSuccessJR(u);
    }

//    上传头像
//    @RequestMapping("/changeAvatar")
//    public JsonResult<Void> changeAvatar(Integer id,String avatar,String modifiedUser, Date modifiedTime,HttpSession session){
//
//    }
}
