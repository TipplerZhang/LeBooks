package com.lebooks.controller;

import com.lebooks.entity.ShopCart;
import com.lebooks.entity.User;
import com.lebooks.service.ShopCartService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteShopCartServlet", value = "/deleteShopCart.action")
public class DeleteShopCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建购物车服务层对象
        ShopCartService scs = new ShopCartService();
        // 获取页面传递的参数
        // 商品ID
        int cart_id = Integer.valueOf(req.getParameter("cart_id"));
        if(scs.deleteShopCart(cart_id)){
            ShowShopCartServlet sscs = new ShowShopCartServlet();
            sscs.service(req,resp);
        }
    }
}
