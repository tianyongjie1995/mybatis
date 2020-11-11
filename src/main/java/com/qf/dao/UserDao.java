package com.qf.dao;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User selectById(@Param("uid") Integer id);
    User selectByIdAndUserName(@Param("id")Integer id,@Param("name")String name);

    List<User> selectByUserName(@Param("name")String name);

    int deleteById(@Param("id")Integer id);

    int updateById(User user);

    int insertUser(User user);

    int insertUserGetId(User user);
}
