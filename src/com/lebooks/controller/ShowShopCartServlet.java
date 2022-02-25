package com.lebooks.controller;

import com.lebooks.service.ShopCartService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
// 展示购物车中商品信息
@WebServlet(name = "ShowShopCartServlet", value = "/showShopCart.action")
public class ShowShopCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShopCartService scs = new ShopCartService();
        req.getRequestDispatcher("/WEB-INF/view/front/shopcart.jsp").forward(req,resp);
    }
}
