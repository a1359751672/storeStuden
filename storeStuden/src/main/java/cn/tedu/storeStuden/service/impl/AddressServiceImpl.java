package cn.tedu.storeStuden.service.impl;

import cn.tedu.storeStuden.Mapper.AddressMapper;
import cn.tedu.storeStuden.common.Constant;
import cn.tedu.storeStuden.entity.Address;
import cn.tedu.storeStuden.service.IAddressService;
import cn.tedu.storeStuden.service.IDistrictService;
import cn.tedu.storeStuden.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    AddressMapper mapper;

    @Autowired
    IDistrictService service;

    //    添加收获地址
    @Override
    public void createAddress(Integer userId, String username, Address address) {
//非空验证
        if (StringUtils.isEmpty(username)){
            throw new EmptyArgumentException("添加异常：当前用户未登录");
        }
        //根据id查询用户已经已经拥有的收货地址条数
        Integer count = mapper.countByUserId(userId);
        if (count >= Constant.MAX_ADDRESS){
            throw new AddressCountLimitException("添加异常：收货地址已超过限制条数");
        }
        //判断是否首次设置收货地址
        if (count==0){
            address.setIsDefault(Constant.IS_DEFAULT);
        }else{
            address.setIsDefault(Constant.IS_NOT_DEFAULT);
        }
        //补全省市区的编号信息
        Integer provinceCode = service.findCodeByName(address.getProvinceName());//省编号
        Integer cityCode = service.findCodeByName(address.getCityName());//市级编号
        Integer areaCode = service.findCodeByName(address.getAreaName());//区域编号
        //将获取到的编号赋值到address对象中
        address.setProvinceCode(provinceCode);
        address.setCityCode(cityCode);
        address.setAreaCode(areaCode);
        //补全userId
        address.setUserId(userId);
        address.setModifiedUser(username);
        address.setCreatedUser(username);
        address.setModifiedTime(new Date());
        //执行添加语句
        mapper.saveAddress(address);

////        执行添加地址操作
//        address.setCreatedUser(username);
//        address.setModifiedUser(username);

//        Integer row=0;
//        try {
//            row = mapper.saveAddress(address);
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new InsertException("添加异常：查询信息有误");
//        }
//        if (row!=1){
//            throw new InsertException("添加收货地址异常");
//        }

    }

//    查询收货地址信息
    @Override
    public List<Address> finAddressList(Integer uid) {
        List<Address> list = mapper.getAddressByUserId(uid);
        return list;
    }

//修改收货地址
    @Override
    public void updateAddressList(Integer id, Integer uid,Address address) {
        //        非空验证
        if (StringUtils.isEmpty(uid)){
            throw new DeleteException("修改异常：当前用户未登录");
        }
        //补全省市区的编号信息
        Integer provinceCode = service.findCodeByName(address.getProvinceName());//省编号
        Integer cityCode = service.findCodeByName(address.getCityName());//市级编号
        Integer areaCode = service.findCodeByName(address.getAreaName());//区域编号
        //将获取到的编号赋值到address对象中
        address.setProvinceCode(provinceCode);
        address.setCityCode(cityCode);
        address.setAreaCode(areaCode);
        //执行添加语句
        mapper.updateAddressInfo(address);
    }

//    @Override
//    public List<Address> updateAddressList(String username, Integer id, String provinceName, String cityName, String areaName, Address address1) {
//        //非空验证
//        if (StringUtils.isEmpty(username)){
//            throw new EmptyArgumentException("添加异常：当前用户未登录");
//        }
////        根据id对收货地址进行修改
//        Integer count = mapper.updateAddressInfo(id, provinceName, cityName,
//                areaName);
//        //补全省市区的编号信息
//        Integer provinceCode = service.findCodeByName(provinceName);//省编号
//        Integer cityCode = service.findCodeByName(cityName);//市级编号
//        Integer areaCode = service.findCodeByName(areaName);//区域编号
//        //将获取到的编号赋值到address对象中
//        address1.setProvinceCode(provinceCode);
//        address1.setCityCode(cityCode);
//        address1.setAreaCode(areaCode);
//        mapper.updateAddressInfo(id, provinceName, cityName,
//                areaName,address1);
//        return null;
//    }

    @Override
    public void removeAddress(Integer id, Integer uid) {
//        非空验证
        if (StringUtils.isEmpty(uid)){
            throw new DeleteException("删除异常：当前用户未登录");
        }
//        根据id删除地址
       mapper.deleteById(id);
    }
}
