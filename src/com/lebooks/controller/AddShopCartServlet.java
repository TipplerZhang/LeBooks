package com.lebooks.controller;

import com.lebooks.entity.ShopCart;
import com.lebooks.entity.User;
import com.lebooks.service.ShopCartService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
// 将商品信息加入至购物车
@WebServlet(name = "AddShopCartServlet", value = "/addshopcart.action")
public class AddShopCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建购物车服务层对象
        ShopCartService scs = new ShopCartService();
        // 获取页面传递的参数
        // 商品ID
        String article_id = request.getParameter("id");
        // 商品购买数量
        String number = request.getParameter("buyNum");
        //商品价格
        String price = request.getParameter("price");
        // 商品名称
        String book_name = request.getParameter("name");
        // 获取用户信息
        User user = (User)request.getSession().getAttribute("session_user");
        // 根据用户信息以及商品ID查询购物车详情表  判断该商品是否存在于用户的购物车当中
        ShopCart shopcart = scs.getShopCartByUserIdAndArticleId(user.getUser_id(),Integer.valueOf(article_id));
        if (shopcart != null){
            // 进行更新操作
            scs.updateShopCart(user.getUser_id(),Integer.valueOf(article_id),Integer.valueOf(number)+shopcart.getCart_book_amount());
        }else {
            // 进行添加操作
            scs.addShopCart(user.getUser_id(),Integer.valueOf(article_id),Integer.valueOf(number),price,book_name);
        }
        response.sendRedirect("/showShopCart.action");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}


