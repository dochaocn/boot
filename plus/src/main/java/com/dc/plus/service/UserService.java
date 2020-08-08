package com.dc.plus.service;

import com.dc.plus.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Dc
 * @since 2019-09-25
 */
public interface UserService extends IService<User> {

    List<User> getAll();
}
