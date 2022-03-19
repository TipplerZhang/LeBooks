package com.lebooks.controller.back;

import com.lebooks.entity.Article;
import com.lebooks.service.back.ManageService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateBookInfoServlet", value = "/updateBookInfo.action")
public class UpdateBookInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
