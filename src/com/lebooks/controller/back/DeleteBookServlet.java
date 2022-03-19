package com.lebooks.controller.back;

import com.lebooks.service.back.ManageService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteBookServlet", value = "/deleteBook.action")
public class DeleteBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建管理层服务对象
        ManageService ms = new ManageService();
        // 获取页面传递的参数
        int book_id = Integer.valueOf(request.getParameter("book_id"));
        if(ms.deleteBook(book_id)){
            BookManageServlet bms = new BookManageServlet();
            bms.doGet(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
