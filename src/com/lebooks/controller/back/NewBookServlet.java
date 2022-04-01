package com.lebooks.controller.back;

import com.lebooks.entity.Article;
import com.lebooks.service.back.ManageService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NewBookServlet", value = "/newBook.action")
public class NewBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean flag = Boolean.valueOf(request.getParameter("flag"));
        if(flag){
            request.getRequestDispatcher("/WEB-INF/view/back/newBook.jsp").forward(request,response);
        }else{
            // 创建管理层对象
            ManageService ms = new ManageService();
            // 接受前台传来的修改数据
            Article article = new Article();
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
            int book_reserve = Integer.parseInt(request.getParameter("book_reserve"));
            article.setBook_reserve((int)book_reserve);
            String book_press = request.getParameter("book_press");
            article.setBook_press(book_press);
            String book_birthplace = request.getParameter("book_birthplace");
            article.setBook_birthplace(book_birthplace);
            String book_type = request.getParameter("book_type");
            article.setBook_type(book_type);
            boolean book_flag = ms.newBook(article);
            if (book_flag){
                response.sendRedirect("bookManage.action");
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
