package cn.tedu.storeStuden.service;

import cn.tedu.storeStuden.entity.Address;

import java.util.List;

public interface IAddressService {
//    添加收货地址
    void createAddress(Integer userId, String username, Address address);
//    根据用户id查询收货地址信息
    List<Address> finAddressList(Integer uid);
//////    根据id修改收货地址信息
    void updateAddressList(Integer id,Integer uid,Address address);
//    删除收货地址
    void removeAddress(Integer id,Integer uid);
}
