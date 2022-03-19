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
        // 创建管理层对象
        ManageService ms = new ManageService();
        // 接受前台传来的修改数据
        Article article = new Article();
        int book_id = Integer.valueOf(request.getParameter("book_id"));
        String book_name = request.getParameter("book_name");
        article.setBook_id(book_id);
        article.setBook_name(request.getParameter("book_name"));
        article.setBook_price(request.getParameter("book_price"));
        article.setBook_author(request.getParameter("book_author"));
        article.setBook_description(request.getParameter("book_description"));
        article.setBook_image(request.getParameter("book_image"));
        article.setBook_reserve(Integer.valueOf(request.getParameter("book_reserve")));
        article.setBook_press(request.getParameter("book_press"));
        article.setBook_birthplace(request.getParameter("book_birthplace"));
        article.setBook_type(request.getParameter("book_type"));
        boolean flag = ms.editBookInfo(article);
        if (flag){
            request.getRequestDispatcher("/WEB-INF/view/back/bookManage.jsp").forward(request,response);
        }
    }
}
