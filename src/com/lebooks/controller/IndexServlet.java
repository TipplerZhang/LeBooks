package com.lebooks.controller;

import com.lebooks.entity.Article;
import com.lebooks.service.ArticleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/index.action")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建服务区对象
        ArticleService as = new ArticleService();

        //获取所有的商品
        List<Article> articles = as.getAllArticle();
        // 将商品信息存放至request对象中
        req.setAttribute("Articles",articles);
        //跳转首页
        req.getRequestDispatcher("/WEB-INF/view/front/articleIndex.jsp").forward(req,resp);
    }
}
