package com.lebooks.controller.front;

import com.lebooks.entity.User;
import com.lebooks.service.front.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateUserInfoServlet", value = "/updateUserInfo.action")
public class UpdateUserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建管理层对象
        UserService us = new UserService();
        // 接受前台传来的修改数据
        User user = new User();
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        user.setUser_id(user_id);
        user.setUser_account(request.getParameter("user_account"));
        user.setUsername(request.getParameter("username"));
        user.setUser_sex(request.getParameter("user_sex"));
        user.setUser_birth(request.getParameter("user_birth"));
        user.setUser_phone(request.getParameter("user_phone"));
        user.setUser_email(request.getParameter("user_email"));
        user.setUser_address(request.getParameter("user_address"));
        boolean flag = us.updateUserInfo(user);
        if (flag) {
            response.sendRedirect("userInfo.action");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
