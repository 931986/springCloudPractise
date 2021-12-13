package com.SpringCloud.service;

import com.SpringCloud.entity.Person;
import com.baomidou.mybatisplus.extension.service.IService;

public interface PersonService extends IService<Person> {

    public Person findById(int id);
    public  String savePerson(Person person);
}
