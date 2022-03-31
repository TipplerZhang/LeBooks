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
        article.setBook_id((int)book_id);
        String book_name = request.getParameter("book_name");
        article.setBook_name(book_name);
        String book_price = request.getParameter("book_price");
        article.setBook_price(book_price);
        String book_author = request.getParameter("book_author");
        article.setBook_author(book_author);
        String book_description = request.getParameter("book_description");
        article.setBook_description(book_description);
        String book_image = request.getParameter("book_image");
        article.setBook_image(book_image);
        int book_reserve = Integer.valueOf(request.getParameter("book_reserve"));
        article.setBook_reserve(book_reserve);
        String book_press = request.getParameter("book_press");
        article.setBook_press(book_press);
        String book_birthplace = request.getParameter("book_birthplace");
        article.setBook_birthplace(book_birthplace);
        String book_type = request.getParameter("book_type");
        article.setBook_type(book_type);
        boolean flag = ms.editBookInfo(article);
        if (flag){
            response.sendRedirect("bookManage.action");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
