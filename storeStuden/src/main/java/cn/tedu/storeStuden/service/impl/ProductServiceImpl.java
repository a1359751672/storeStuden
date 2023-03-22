package cn.tedu.storeStuden.service.impl;

import cn.tedu.storeStuden.Mapper.ProductMapper;
import cn.tedu.storeStuden.entity.Product;
import cn.tedu.storeStuden.service.IProductService;
import cn.tedu.storeStuden.service.ex.EmptyArgumentException;
import cn.tedu.storeStuden.service.ex.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ProductMapper mapper;


    @Override
    public List<Product> findHotList() {
        List<Product> list = mapper.listHotProduct();
        return list;
    }

    @Override
    public Product findById(Integer id) {
        if (StringUtils.isEmpty(id)){
            throw new EmptyArgumentException("查询数据异常：未传入id信息");
        }
        Product pr = mapper.getById(id);
        if (pr == null){
            throw new RecordNotFoundException("查询异常：未查询到该商品");
        }
        return pr;
    }
}
