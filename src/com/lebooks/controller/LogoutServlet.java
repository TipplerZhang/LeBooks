package com.lebooks.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
// 用户退出
@WebServlet(name = "LogoutServlet", value = "/logout.action")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 将session中的用户信息清除
        req.getSession().removeAttribute("session_user");
        // 跳转到首页
        req.getRequestDispatcher("index.action").forward(req,resp);
    }
}
