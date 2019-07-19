package com.dc.demo.service.impl;

import com.dc.api.service.UserService;
import com.dc.demo.dao.UserDao;
import com.dc.api.domain.User;
import com.dc.demo.support.IdSingleton;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@com.alibaba.dubbo.config.annotation.Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public void insert(User user) {
        user.setId(IdSingleton.getIntegerId());
        log.info(user.toString());
        userDao.insert(user);
    }
}
