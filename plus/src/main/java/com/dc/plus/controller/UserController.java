package com.dc.plus.controller;


import com.dc.plus.entity.User;
import com.dc.plus.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Dc
 * @since 2019-09-25
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/user")
    public Object getUser() {
        return userService.getAll();
    }
}
