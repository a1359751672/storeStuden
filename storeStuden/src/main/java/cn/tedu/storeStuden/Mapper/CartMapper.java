package cn.tedu.storeStuden.Mapper;

import cn.tedu.storeStuden.entity.Cart;
import cn.tedu.storeStuden.entity.CartVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface CartMapper {
//    添加购物车
    Integer insertCart(Cart cart);
//    基于用户id和商品id查询购物车记录
    Cart getByUidAndPid(Integer uid,Integer pid);
//    基于商品id更新购物车数量
    Integer UpdateNum(Integer id, Integer num, String username, Date modifiedTime);
//    根据id查询购物车信息
    List<CartVO> listCart(Integer uid);
}
