package cn.tedu.storeStuden.service.impl;

import cn.tedu.storeStuden.Mapper.DistrictMapper;
import cn.tedu.storeStuden.entity.District;
import cn.tedu.storeStuden.service.IDistrictService;
import cn.tedu.storeStuden.service.ex.EmptyArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class DistrictServiceImpl implements IDistrictService {
    @Autowired
    DistrictMapper mapper;

    @Override
    public Integer findCodeByName(String name) {
        if (StringUtils.isEmpty(name)){
            throw new EmptyArgumentException("省市区不存在");
        }
        Integer code = mapper.getCodeByName(name);
        return code;
    }

    @Override
    public List<District> findByParent(String parent) {
        List<District> list = mapper.listByParent(parent);
        return list;
    }
}
