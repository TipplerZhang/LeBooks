package com.lebooks.controller.front;

import com.lebooks.entity.Order;
import com.lebooks.entity.User;
import com.lebooks.service.front.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowOrderServlet", value = "/showOrder.action")
public class ShowOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 个人订单
        OrderService os = new OrderService();
        User user = (User)request.getSession().getAttribute("session_user");
        if (user != null){
            List<Order> orders = os.findAllOrderByUser(user);
            if (!orders.isEmpty()){
                request.setAttribute("orders",orders);
                request.getRequestDispatcher("/WEB-INF/view/front/order.jsp").forward(request,response);
            }
        }else {
            request.getRequestDispatcher("/WEB-INF/view/front/notLogin.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
