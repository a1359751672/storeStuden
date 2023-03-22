package cn.tedu.storeStuden.controller;

import cn.tedu.storeStuden.entity.District;
import cn.tedu.storeStuden.entity.JsonResult;
import cn.tedu.storeStuden.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/districts")
public class DistrictController {
    @Autowired
    IDistrictService service;

    @RequestMapping("/")
    public JsonResult<List<District>> findDistrict(String parent){
        List<District> list = service.findByParent(parent);
        return JsonResult.getSuccessJR(list);
    }

}
