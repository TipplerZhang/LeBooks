package com.lebooks.service.back;

import com.lebooks.dao.UserDao;
import com.lebooks.entity.User;

import java.util.List;

public class ManageService {
    private UserDao userDao = new UserDao();
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
}
