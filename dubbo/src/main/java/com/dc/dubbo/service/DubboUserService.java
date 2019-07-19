package com.dc.dubbo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dc.api.service.UserService;
import com.dc.api.domain.User;
import org.springframework.stereotype.Service;

@Service
public class DubboUserService {

    @Reference
    private UserService userService;

    public void hello() {
        userService.insert(new User());
    }
}
