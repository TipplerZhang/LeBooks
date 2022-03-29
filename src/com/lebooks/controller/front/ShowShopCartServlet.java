package com.lebooks.controller.front;

import com.lebooks.entity.ShopCart;
import com.lebooks.entity.User;
import com.lebooks.service.front.ShopCartService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

// 展示购物车中商品信息
@WebServlet(name = "ShowShopCartServlet", value = "/showshopcart.action")
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
        User user = (User) req.getSession().getAttribute("session_user");
        if(user != null){
            // 根据用户ID获取购物车中商品信息
            List<ShopCart> carts = scs.findAllShopCartByUserId(user.getUser_id());
            if (carts.isEmpty()){
                req.getRequestDispatcher("/WEB-INF/view/front/shopCartEmpty.jsp").forward(req,resp);
            }else{
                req.setAttribute("carts",carts);
                req.getRequestDispatcher("/WEB-INF/view/front/shopCart.jsp").forward(req,resp);
            }
        }else {
            req.getRequestDispatcher("/WEB-INF/view/front/notLogin.jsp").forward(req,resp);
        }
    }
}
