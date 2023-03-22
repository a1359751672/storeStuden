package cn.tedu.storeStuden.service;


import cn.tedu.storeStuden.entity.CartVO;

import java.util.List;

public interface ICartService {
    //    添加一条购物车记录
    void createdCart(Integer productId, Integer num, Integer userId, String username);

//    购物车列表
    List<CartVO> findCartList(Integer uid);
}
