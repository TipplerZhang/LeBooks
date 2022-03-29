package com.lebooks.controller.front;

import com.lebooks.entity.User;
import com.lebooks.service.front.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditUserInfoServlet", value = "/editUserInfo.action")
public class EditUserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户ID
        int user_id = Integer.valueOf(request.getParameter("user_id"));
        // 创建用户服务对象
        UserService us = new UserService();
        User user = us.getUserById(user_id);
        request.setAttribute("user",user);
        //跳转用户信息编辑页
        request.getRequestDispatcher("/WEB-INF/view/front/editUserInfo.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
