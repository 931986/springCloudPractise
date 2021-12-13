package com.SpringCloud.mapper;

import com.SpringCloud.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMapper extends BaseMapper<Person> {

}
