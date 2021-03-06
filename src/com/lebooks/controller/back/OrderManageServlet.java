package com.lebooks.controller.back;

import com.lebooks.entity.Order;
import com.lebooks.service.back.ManageService;
import com.lebooks.util.pager.PagerModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderManageServlet", value = "/orderManage.action")
public class OrderManageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取对应的管理类型
        String manage_type = request.getParameter("manage_type");
        // 获取下拉框搜索条件
        String select_type = request.getParameter("select_type");
        // 获取查询关键字
        String keyword = request.getParameter("keyword");
        // 将用户输入的关键字存储
        request.setAttribute("keyword",keyword);
        // 创建管理层服务对象
        ManageService ms = new ManageService();
        // 创建分页实体
        PagerModel pagerModel = new PagerModel();
        // 获取页码
        String pageIndex = request.getParameter("pageIndex");
        if(pageIndex != null && !pageIndex.equals("")){
            pagerModel.setPageIndex(Integer.valueOf(pageIndex));
        }
        // 按条件查询相应数据
        if(keyword != null){
            List<Order> orders = ms.getRequOrder(select_type,keyword,pagerModel);
            request.setAttribute("orders",orders);
        }else{
            List<Order> orders = ms.getAllOrder(pagerModel);
            request.setAttribute("orders",orders);
        }
        request.setAttribute("pagerModel",pagerModel);
        //跳转后台首页
        request.getRequestDispatcher("/WEB-INF/view/back/orderManage.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
