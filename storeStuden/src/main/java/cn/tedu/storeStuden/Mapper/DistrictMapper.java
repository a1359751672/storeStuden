package cn.tedu.storeStuden.Mapper;

import cn.tedu.storeStuden.entity.District;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DistrictMapper {
//    根据编号查询所有省级信息
    Integer getCodeByName(String name);

//    根据父类编号查询信息
    List<District> listByParent(String parent);

}
