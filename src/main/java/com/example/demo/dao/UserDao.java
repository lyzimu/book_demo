package com.example.demo.dao;

import com.example.demo.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {

    public User doLogin(User user);

    int doRegister(User user);

    User findByUserName(String uname);
}
