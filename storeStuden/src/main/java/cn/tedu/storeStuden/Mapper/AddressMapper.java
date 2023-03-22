package cn.tedu.storeStuden.Mapper;

import cn.tedu.storeStuden.entity.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {
//    查询用户已有的收获地址
    Integer countByUserId(Integer userId);
//    新增收货地址
    Integer saveAddress(Address address);
//    根据用户id查询对应的收货地址
    List<Address> getAddressByUserId(Integer uid);
//    跟据uid修改收货地址
    Integer updateAddressInfo(Address address);

//    删除功能
    Integer deleteById(Integer id);
}
