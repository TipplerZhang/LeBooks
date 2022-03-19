package com.lebooks.controller.back;

import com.lebooks.entity.Admin;
import com.lebooks.service.back.AdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", value = "/adminLogin.action")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/back/adminLogin.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        // 创建管理员服务对象
        AdminService as = new AdminService();
        Admin admin = as.getAdminByNameAndPass(loginName,password);
        if(admin != null){
            request.getSession().setAttribute("session_admin",admin);
            request.getRequestDispatcher("userManage.action").forward(request,response);
        }else{
            // 跳转登录页面
            request.setAttribute("mess","账号或密码不正确！");
            request.getRequestDispatcher("/WEB-INF/view/back/adminLogin.jsp").forward(request,response);
        }
    }
}
