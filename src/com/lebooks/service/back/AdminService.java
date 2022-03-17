package com.lebooks.service.back;

import com.lebooks.dao.AdminDao;
import com.lebooks.entity.Admin;

public class AdminService {
    private AdminDao ad = new AdminDao();
    public Admin getAdminByNameAndPass(String loginName, String password) {
        return ad.getAdminByNameAndPass(loginName,password);
    }
}
