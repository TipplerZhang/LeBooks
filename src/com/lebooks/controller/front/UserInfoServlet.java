package com.lebooks.controller.front;

import com.lebooks.entity.User;
import com.lebooks.service.front.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserInfoServlet", value = "/userInfo.action")
public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 用户个人中心
        // 创建用户服务对象
        UserService us = new UserService();
        // 获取Session中User的信息
        User session_user = (User)request.getSession().getAttribute("session_user");
        if (session_user != null){
            User user = us.getUserById(session_user.getUser_id());
            request.setAttribute("user",user);
            //跳转用户信息详情页
            request.getRequestDispatcher("/WEB-INF/view/front/userInfo.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/WEB-INF/view/front/notLogin.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
