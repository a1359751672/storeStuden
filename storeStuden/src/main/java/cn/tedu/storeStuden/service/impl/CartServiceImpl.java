package cn.tedu.storeStuden.service.impl;

import cn.tedu.storeStuden.Mapper.CartMapper;
import cn.tedu.storeStuden.Mapper.ProductMapper;
import cn.tedu.storeStuden.Mapper.UserMapper;
import cn.tedu.storeStuden.entity.Cart;
import cn.tedu.storeStuden.entity.CartVO;
import cn.tedu.storeStuden.entity.Product;
import cn.tedu.storeStuden.entity.User;
import cn.tedu.storeStuden.service.ICartService;
import cn.tedu.storeStuden.service.ex.InsertException;
import cn.tedu.storeStuden.service.ex.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired(required = false)
    CartMapper mapper;

    @Autowired(required = false)
    UserMapper UserMapper;

    @Autowired
    ProductMapper productMapper;




//    添加一条购物车记录
    @Override
    public void createdCart(Integer productId, Integer num, Integer userId, String username){
//        查询用户是否登录
        User u = UserMapper.getByName(username);
        if (u==null){
            throw new InsertException("添加数据失败：未登录，请先登录");
        }
//       查看商品是否存在
        Product pr = productMapper.getById(productId);
        if (pr==null){
            throw new InsertException("添加异常：未查询到该商品");
        }
//        基于用户id和商品id查询购物车记录
        Cart cart = mapper.getByUidAndPid(userId, productId);
        if (cart == null){
            Cart c1 = new Cart(null,userId,productId,pr.getPrice(),num,username,new Date(),username,new Date());
            Integer row = mapper.insertCart(c1);
            if (row!=1){
                throw new InsertException("添加数据失败");
            }
        }else {
            int newNum = cart.getNum()+num;
            Integer row = mapper.UpdateNum(cart.getId(),newNum,username,new Date());
            if (row!=1){
                throw new InsertException("更新数据失败");
            }
        }
    }

    @Override
    public List<CartVO> findCartList(Integer uid) {
        List<CartVO> listCart = mapper.listCart(uid);
        if (listCart==null){
            throw new RecordNotFoundException("查询购物车列表失败：未查询到记录");
        }
        return listCart;
    }

}
