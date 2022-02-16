package com.SpringCloud.service.Impl;

import com.SpringCloud.entity.Person;
import com.SpringCloud.mapper.PersonMapper;
import com.SpringCloud.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

     public Person findById(int id){
         return baseMapper.selectById(id);
    }
    @Override
    public String savePerson(Person person) {
        baseMapper.insert(person);

        return "保存成功";
    }

    @Override
    public List<Person> selectHotPerson() {
        return null;
    }

    @Override
    public List<Person> selectHotSubject() {
        return null;
    }

}
