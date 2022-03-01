package com.lebooks.service;

import com.lebooks.dao.UserDao;
import com.lebooks.entity.User;

public class UserService {
    private UserDao ud = new UserDao();
    public User getUserByNameAndPass(String loginName, String password) {
        return ud.getUserByNameAndPass(loginName,password);
    }

    public boolean saveUser(User user) {
        try{
            return ud.saveUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public String getUserByEmail(String registerEmail) {
        boolean flag = ud.getUserByEmail(registerEmail);
        return flag ? "用户已存在" : "";
    }
}
