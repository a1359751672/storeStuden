package cn.tedu.storeStuden.service;

import cn.tedu.storeStuden.entity.District;

import java.util.List;

public interface IDistrictService {
    //    基于编号查询名称
    Integer findCodeByName(String name);
    //    基于父级编号查询自己信息
    List<District> findByParent(String parent);
}
