package com.lebooks.service;

import com.lebooks.dao.UserDao;
import com.lebooks.entity.User;

public class UserService {
    private UserDao ud = new UserDao();
    public User getUserByNameAndPass(String loginName, String password) {
        return ud.getUserByNameAndPass(loginName,password);
    }
}
