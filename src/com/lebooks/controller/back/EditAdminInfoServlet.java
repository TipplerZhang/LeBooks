package com.lebooks.controller.back;

import com.lebooks.entity.Admin;
import com.lebooks.service.back.ManageService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditAdminInfoServlet", value = "/EditAdminInfoServlet")
public class EditAdminInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取Admin_id
        int admin_id = Integer.valueOf(request.getParameter("admin_id"));
        // 创建管理层服务对象
        ManageService ms = new ManageService();
        Admin admin = ms.getAdminById(admin_id);
        request.setAttribute("admin",admin);
        //跳转管理员信息详情页
        request.getRequestDispatcher("/WEB-INF/view/back/editAdminInfo.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
