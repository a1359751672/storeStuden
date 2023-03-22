package cn.tedu.storeStuden.Mapper;

import cn.tedu.storeStuden.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
//    查询热销商品
    List<Product> listHotProduct();
//    商品详情信息
    Product getById(Integer id);
}
