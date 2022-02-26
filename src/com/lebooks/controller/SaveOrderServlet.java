package com.lebooks.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SaveOrderServlet", value = "/saveOrder.action")
public class SaveOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取订单总金额
        String totalAmount = req.getParameter("totalAmount");
        req.getRequestDispatcher("/WEB-INF/view/front/articleIndex.jsp").forward(req,resp);
    }
}
