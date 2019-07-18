package com.dc.demo.controller;

import com.dc.demo.support.MyController;
import com.dc.demo.domain.User;
import com.dc.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@MyController(mapping = "/user/", name = "userController")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public Object login(){
        log.info(this.getClass().getName() + "-----login()");
        List<User> list = new ArrayList<>();
        list.add(new User(1,"1","dc1"));
        list.add(new User(2,"2","dc2"));
        list.add(new User(3,"3","dc3"));
        return list;
    }

    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public Object insert(User user){
        log.info(this.getClass().getName() + "-----insert()");
        userService.insert(user);
        return true;
    }
}
