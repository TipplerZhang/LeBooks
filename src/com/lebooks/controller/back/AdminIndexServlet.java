package com.lebooks.controller.back;

import com.lebooks.entity.User;
import com.lebooks.service.back.AdminService;
import com.lebooks.service.back.ManageService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminIndexServlet", value = "/adminIndex.action")
public class AdminIndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取对应的管理类型
        String manage_type = req.getParameter("manage_type");
        // 获取下拉框搜索条件
        String select_type = req.getParameter("select_type");
        // 获取查询关键字
        String keyword = req.getParameter("keyword");
        // 将用户输入的关键字存储
        req.setAttribute("keyword",keyword);
        // 创建管理层服务对象
        ManageService ms = new ManageService();
        // 按条件查询相应数据
        if(keyword != null){

        }else{
            // 查询所有的用户信息
            List<User> users = ms.getAllUser();
            req.setAttribute("users",users);
        }
        //跳转后台首页
        req.getRequestDispatcher("/WEB-INF/view/back/adminIndex.jsp").forward(req,resp);
    }
}
