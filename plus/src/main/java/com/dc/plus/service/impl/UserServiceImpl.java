package com.dc.plus.service.impl;

import com.dc.plus.entity.User;
import com.dc.plus.mapper.UserMapper;
import com.dc.plus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Dc
 * @since 2019-09-25
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {

        List<User> list = new ArrayList<>();

        User user = userMapper.selectById(1);
        log.info(user.toString());


        User u = new User();
        u.setId(2);
        u.setUsername("dc");
        u.setPwd("ss");
        userMapper.insert(u);

        User u1 = userMapper.getOne(1);

        list.add(user);
        list.add(u);
        list.add(u1);
        return list;
    }


}
