package com.SpringCloud.service;

import com.SpringCloud.entity.Person;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface PersonService extends IService<Person> {

    public Person findById(int id);
    public  String savePerson(Person person);

    public List<Person> selectHotPerson();

    public List<Person> selectHotSubject();
}
