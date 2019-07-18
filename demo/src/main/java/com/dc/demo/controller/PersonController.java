package com.dc.demo.controller;

import com.dc.demo.dto.PersonMongo;
import com.dc.demo.support.MyController;
import com.dc.demo.domain.User;
import com.dc.demo.service.PersonMongoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@MyController(mapping = "/person")
@Slf4j
public class PersonController {

    @Resource
    private PersonMongoRepository personMongoRepository;

    @RequestMapping("/save")
    public PersonMongo save(){
        PersonMongo  p = new PersonMongo("1","dc",18);
        User u1 = new User(1,"上海","2009");
        User u2 = new User(2,"合肥","2010");
        p.getList().add(u1);
        p.getList().add(u2);
        return personMongoRepository.save(p);
    }

    @RequestMapping("/byName")
    public List<PersonMongo> byName(String name){
        List<PersonMongo> list = personMongoRepository.findByName(name);
        log.info(list.toString());
        return list;
    }

    @RequestMapping("/byAge")
    public List<PersonMongo> byAge(Integer age) {
        List<PersonMongo> list = personMongoRepository.withQueryFindByAge(age);
        log.info(list.toString());
        return list;
    }

}