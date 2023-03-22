package cn.tedu.storeStuden.service;

import cn.tedu.storeStuden.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductService {
    //    查询热销商品
    List<Product> findHotList();

//    商品详情
    Product findById(Integer id);
}
