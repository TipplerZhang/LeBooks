package com.lebooks.controller.back;

import com.lebooks.entity.Admin;
import com.lebooks.service.back.ManageService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminInfoServlet", value = "/adminInfo.action")
public class AdminInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建管理层服务对象
        ManageService ms = new ManageService();
        // 获取Session中管理员的信息
        Admin session_admin = (Admin) request.getSession().getAttribute("session_admin");
        Admin admin = ms.getAdminById(session_admin.getAdmin_id());
        request.setAttribute("admin",admin);
        //跳转管理员信息详情页
        request.getRequestDispatcher("/WEB-INF/view/back/adminInfo.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
