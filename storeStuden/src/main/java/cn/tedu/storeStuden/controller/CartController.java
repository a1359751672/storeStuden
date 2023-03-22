package cn.tedu.storeStuden.controller;

import cn.tedu.storeStuden.entity.CartVO;
import cn.tedu.storeStuden.entity.JsonResult;
import cn.tedu.storeStuden.entity.User;
import cn.tedu.storeStuden.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    ICartService service;

    @RequestMapping("/create")
    public JsonResult<Void> createCart(Integer productId, Integer num, HttpSession session){
        User user = (User) session.getAttribute("user");
        service.createdCart(productId,num,user.getId(),user.getUsername());
        return JsonResult.getSuccessJR();
    }

    @RequestMapping("/list")
    public JsonResult<List> findCartLis(HttpSession session){
        User user = (User) session.getAttribute("user");
        List<CartVO> cartList = service.findCartList(user.getId());
        return JsonResult.getSuccessJR(cartList);
    }

}
