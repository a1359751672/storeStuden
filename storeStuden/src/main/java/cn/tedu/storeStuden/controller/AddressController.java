package cn.tedu.storeStuden.controller;

import cn.tedu.storeStuden.entity.Address;
import cn.tedu.storeStuden.entity.JsonResult;
import cn.tedu.storeStuden.entity.User;
import cn.tedu.storeStuden.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    IAddressService service;

    @RequestMapping("/createAddress")
    public JsonResult<Void> createAddress(Address address, HttpSession session){
        User user = (User) session.getAttribute("user");
        service.createAddress(user.getId(), user.getUsername(), address);
        address.setUserId(user.getId());
        address.setCreatedUser(user.getCreatedUser());
//        address.setModifiedUser(user.getUsername());
//        address.setModifiedTime(new Date());
//        address.setProvinceCode();
        return JsonResult.getSuccessJR();
    }

    @RequestMapping("/list")
    public JsonResult<List<Address>> addressList(HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Address> list = service.finAddressList(user.getId());
        return JsonResult.getSuccessJR(list);
    }
//    删除地址
    @RequestMapping("/remove")
    public JsonResult<Void> removeById(Integer id,HttpSession session){
        User user = (User) session.getAttribute("user");
        service.removeAddress(id, user.getId());
        System.out.println(id);
        return JsonResult.getSuccessJR();
    }

    @RequestMapping("/update")
    public JsonResult<Void> updateInfo(Integer id,Address address,HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user==null){
            return new JsonResult<>(2005,"登录已失效");
        }
        user.setId(user.getId());
        service.updateAddressList(id,user.getId(),address);
        return JsonResult.getSuccessJR();
    }
}
