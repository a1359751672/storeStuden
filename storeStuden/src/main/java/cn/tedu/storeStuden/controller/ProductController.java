package cn.tedu.storeStuden.controller;

import cn.tedu.storeStuden.entity.JsonResult;
import cn.tedu.storeStuden.entity.Product;
import cn.tedu.storeStuden.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductServiceImpl service;

    @RequestMapping("/hotList")
    JsonResult<List<Product>> findHotList(){
        List<Product> list = service.findHotList();
        return JsonResult.getSuccessJR(list);
    }
//
    @RequestMapping("/{id}/get")
    public JsonResult<Product> findById(@PathVariable("id") Integer id){
        Product pr = service.findById(id);
        return JsonResult.getSuccessJR(pr);
    }
}
