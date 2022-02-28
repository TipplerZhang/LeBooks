package com.lebooks.controller;

import com.lebooks.entity.ShopCart;
import com.lebooks.entity.User;
import com.lebooks.service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SaveOrderServlet", value = "/saveOrder.action")
public class SaveOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建OrderService服务层对象
        OrderService os = new OrderService();
        //获取订单总金额
        String totalAmount = request.getParameter("totalAmount");
        request.getSession().setAttribute("orderMoney",totalAmount);
        String articleInfo = request.getParameter("articleInfo");
        List<ShopCart> carts = os.saveOrder(articleInfo);
        if(!carts.isEmpty()){
            request.setAttribute("carts",carts);
            request.getRequestDispatcher("/WEB-INF/view/front/checkOrder.jsp").forward(request,response);
        }else{

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建OrderService服务层对象
        OrderService os = new OrderService();
        String articleInfo = request.getParameter("articleInfo");
        List<ShopCart> carts = os.saveOrder(articleInfo);
    }

}
