package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User doLogin(User user) {
        return userDao.doLogin(user);
    }

    public int doRegister(User user) {
        return userDao.doRegister(user);
    }

    public User findByUserName(String uname) {
        return userDao.findByUserName(uname);
    }
}
