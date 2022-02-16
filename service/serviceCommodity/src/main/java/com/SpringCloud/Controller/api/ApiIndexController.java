package com.SpringCloud.Controller.api;


import com.SpringCloud.base.R;
import com.SpringCloud.entity.Commodity;
import com.SpringCloud.entity.Person;
import com.SpringCloud.service.CollectService;
import com.SpringCloud.service.CommodityService;
import com.SpringCloud.service.PersonService;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@ComponentScan(basePackages = "com.SpringCloud.mapper")
@RequestMapping("/api/index")
public class ApiIndexController {
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private PersonService personService;
    @PostMapping("/indexGet")
    public R GetHotCommodity(){
     List<Commodity> commodityList= commodityService.selectHotCommodity();//商品

     List<Person> PersonList=personService.selectHotPerson();   //商家或者店铺或者个人
        List<Person> SubjectList=personService.selectHotSubject();  //最火的类别

        return null;
    }


}
