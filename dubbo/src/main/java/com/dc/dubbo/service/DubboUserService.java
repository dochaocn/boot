package com.dc.dubbo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dc.demo.domain.User;
import com.dc.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class DubboUserService {

    @Reference
    private UserService userService;

    public void hello() {
        userService.insert(new User());
    }
}
