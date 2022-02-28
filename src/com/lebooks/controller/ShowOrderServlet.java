package com.lebooks.controller;

import com.lebooks.entity.Order;
import com.lebooks.entity.User;
import com.lebooks.service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowOrderServlet", value = "/showOrder.action")
public class ShowOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService os = new OrderService();
        User user = (User)request.getSession().getAttribute("session_user");
        List<Order> orders = os.findAllOrderByUser(user);
        if (!orders.isEmpty()){
            request.setAttribute("orders",orders);
            request.getRequestDispatcher("/WEB-INF/view/front/order.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
