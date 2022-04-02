package com.lebooks.controller.back;

import com.lebooks.entity.Admin;
import com.lebooks.service.back.ManageService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateAdminInfoServlet", value = "/updateAdminInfo.action")
public class UpdateAdminInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建管理层对象
        ManageService ms = new ManageService();
        // 接受前台传来的修改数据
        Admin admin = new Admin();
        int admin_id = Integer.parseInt(request.getParameter("admin_id"));
        admin.setAdmin_id(admin_id);
        String admin_account = request.getParameter("admin_account");
        admin.setAdmin_account(admin_account);
        admin.setAdmin_name(request.getParameter("admin_name"));
        admin.setAdmin_sex(request.getParameter("admin_sex"));
        admin.setAdmin_birth(request.getParameter("admin_birth"));
        admin.setAdmin_email(request.getParameter("admin_email"));
        admin.setAdmin_phone(request.getParameter("admin_phone"));
        admin.setAdmin_address(request.getParameter("admin_address"));
        admin.setAdmin_grade(Integer.parseInt(request.getParameter("admin_grade")));
        boolean flag = ms.updateAdminInfo(admin);
        if (flag){
            response.sendRedirect("adminInfo.action");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
