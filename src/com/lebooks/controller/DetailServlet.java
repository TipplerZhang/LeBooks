package com.lebooks.controller;

import com.lebooks.entity.Article;
import com.lebooks.service.ArticleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DetailServlet", value = "/detail.action")
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取商品ID
        String book_id = req.getParameter("book_id");
        //创建商品服务区对象
        ArticleService as = new ArticleService();
        // 根据商品ID获取商品信息
        Article article = as.getArticleById(book_id);
        // 存储商品信息
        req.setAttribute("article",article);
        //跳转商品详情页
        req.getRequestDispatcher("/WEB-INF/view/front/detail.jsp").forward(req,resp);
    }

}
