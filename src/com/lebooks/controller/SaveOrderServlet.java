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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建OrderService服务层对象
        OrderService os = new OrderService();
        User user = (User)req.getSession().getAttribute("session_user");
        //获取订单总金额
        String totalAmount = req.getParameter("totalAmount");
        req.setAttribute("totalAmount",totalAmount);
        String articleInfo = req.getParameter("articleInfo");
        List<ShopCart> carts = os.saveOrder(articleInfo);
        if(!carts.isEmpty()){
            req.setAttribute("carts",carts);
            req.getRequestDispatcher("/WEB-INF/view/front/checkOrder.jsp").forward(req,resp);
        }else {

        }

    }
}
