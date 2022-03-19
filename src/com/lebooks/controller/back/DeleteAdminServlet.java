package com.lebooks.controller.back;

import com.lebooks.service.back.ManageService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteAdminServlet", value = "/deleteAdmin.action")
public class DeleteAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建管理层服务对象
        ManageService ms = new ManageService();
        // 获取页面传递的参数
        int admin_id = Integer.valueOf(request.getParameter("admin_id"));
        if (ms.deleteAdmin(admin_id)) {
            AdminManageServlet ams = new AdminManageServlet();
            ams.doGet(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
