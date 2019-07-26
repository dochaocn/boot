package com.dc.product.service.impl;

import com.dc.api.service.UserService;
import com.dc.product.dao.UserDao;
import com.dc.api.domain.User;
import com.dc.product.support.IdSingleton;
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
