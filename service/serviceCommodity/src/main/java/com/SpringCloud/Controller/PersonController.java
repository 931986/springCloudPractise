package com.SpringCloud.Controller;

import com.SpringCloud.base.R;
import com.SpringCloud.entity.Person;
import com.SpringCloud.service.PersonService;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@RestController
@Slf4j
@ComponentScan(basePackages = "com.SpringCloud.mapper")

@RequestMapping("/api/person")

public class PersonController {

//    list,find,delete,save


        @Resource
    private PersonService personService;
    @GetMapping("list")
    public R ListAll(){
          return R.ok().data("listAllPerson",personService.list()).message("200");

    }
    @GetMapping("Get/{personId}")
    public R findBy(@ApiParam(value = "personid",required = true)
                        @PathVariable("personId") int id){
        Person person=personService.findById(id);
        return R.ok().data("listAllPerson",personService.list()).message("200");

    }

    @PostMapping("save")
    public R savePerson(@ApiParam(value = "个人信息",required = true)
                            @RequestBody Person person){
        return R.ok().data("save",personService.savePerson(person)).message("200");

    }
    @DeleteMapping("Delete/{DeleteId}")
    public R DeleteBy(@ApiParam(value = "personid",required = true)
                    @PathVariable("personId") int id){
       personService.removeById(id);
        return R.ok().message("删除成功");
    }



        
}
