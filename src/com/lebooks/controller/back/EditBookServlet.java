package com.lebooks.controller.back;

import com.lebooks.entity.Article;
import com.lebooks.service.back.ManageService;
import com.lebooks.service.front.ArticleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditBookServlet", value = "/editBook.action")
public class EditBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取商品ID
        String book_id = request.getParameter("book_id");
        //创建商品服务区对象
        ArticleService as = new ArticleService();
        // 根据商品ID获取商品信息
        Article article = as.getArticleById(book_id);
        // 存储商品信息
        request.setAttribute("article",article);
        //跳转商品详情页
        request.getRequestDispatcher("/WEB-INF/view/back/editBook.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
