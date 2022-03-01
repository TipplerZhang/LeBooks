package com.lebooks.controller.front;

import com.lebooks.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

// 用户账号校验
@WebServlet(name = "UserInfoValidServlet", value = "/validUser.action")
public class UserInfoValidServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            UserService us = new UserService();
            // 获取登录名
            String registerEmail = request.getParameter("registerEmail");
            String result = us.getUserByEmail(registerEmail);
            response.setCharacterEncoding("utf-8");
            PrintWriter pw = response.getWriter();
            pw.write(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
