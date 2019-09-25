package com.dc.plus.mapper;

import com.dc.plus.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Dc
 * @since 2019-09-25
 */
public interface UserMapper extends BaseMapper<User> {

    User getOne(int id);

    @Select("select * from user where id = #{id}")
    List<User> selectUser(@Param("id")int id);
}
