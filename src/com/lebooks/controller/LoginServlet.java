package com.lebooks.controller;

import com.lebooks.entity.User;
import com.lebooks.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
// 跳转至登录页面 以及 处理登录请求
@WebServlet(name = "LoginServlet", value = "/login.action")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/front/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String loginName = request.getParameter("loginName");
       String password = request.getParameter("password");
       // 创建用户服务对象
        UserService us = new UserService();
        User user = us.getUserByNameAndPass(loginName,password);
        if(user == null){
            // 跳转涛登录页面
            request.setAttribute("mess","账号或密码不正确！");
            request.getRequestDispatcher("/WEB-INF/view/front/login.jsp").forward(request,response);
        }else {
            request.getSession().setAttribute("session_user",user);
            request.getRequestDispatcher("index.action").forward(request,response);

        }

    }

}
