package com.lebooks.controller.front;

import com.lebooks.entity.User;
import com.lebooks.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/front/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 将解码格式设置成UTF-8
        request.setCharacterEncoding("utf8");
        // 创建用户服务层对象
        UserService us = new UserService();
        // 获取用户信息
        String user_email = request.getParameter("registerEmail");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 注册的时候应校验账号是否存在，建议使用异步请求方式

        // 保存用户信息
        User user = new User();
        user.setUsername(username);
        user.setUser_password(password);
        user.setUser_email(user_email);
        if (us.saveUser(user) == true){
            request.getSession().setAttribute("session_user",user);
            request.getRequestDispatcher("index.action").forward(request,response);
        }
    }
}
