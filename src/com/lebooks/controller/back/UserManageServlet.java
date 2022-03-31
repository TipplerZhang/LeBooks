package com.lebooks.controller.back;

import com.lebooks.entity.User;
import com.lebooks.service.back.AdminService;
import com.lebooks.service.back.ManageService;
import com.lebooks.util.pager.PagerModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserManageServlet", value = "/userManage.action")
public class UserManageServlet extends HttpServlet {
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
        // 创建分页实体
        PagerModel pagerModel = new PagerModel();
        // 获取页码
        String pageIndex = req.getParameter("pageIndex");
        if(pageIndex != null && !pageIndex.equals("")){
            pagerModel.setPageIndex(Integer.valueOf(pageIndex));
        }
        // 创建管理层服务对象
        ManageService ms = new ManageService();
        // 按条件查询相应数据
        if(keyword != null){
            List<User> users = ms.getRequUser(select_type,keyword,pagerModel);
            req.setAttribute("users",users);
        }else{
            // 查询所有的用户信息
            List<User> users = ms.getAllUser(pagerModel);
            req.setAttribute("users",users);
        }
        req.setAttribute("pagerModel",pagerModel);
        //跳转后台首页
        req.getRequestDispatcher("/WEB-INF/view/back/manageIndex.jsp").forward(req,resp);
    }
}
