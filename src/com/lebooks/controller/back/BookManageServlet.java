package com.lebooks.controller.back;

import com.lebooks.entity.Article;
import com.lebooks.service.back.ManageService;
import com.lebooks.util.pager.PagerModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookManageServlet", value = "/bookManage.action")
public class BookManageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取对应的管理类型
        String manage_type = request.getParameter("manage_type");
        // 获取下拉框搜索条件// 获取查询关键字
       String keyword = request.getParameter("keyword");
       // 将用户输入的关键字存储
       request.setAttribute("keyword",keyword);
        // 创建分页实体
        PagerModel pagerModel = new PagerModel();
        // 获取页码
        String pageIndex = request.getParameter("pageIndex");
        if(pageIndex != null && !pageIndex.equals("")){
            pagerModel.setPageIndex(Integer.valueOf(pageIndex));
        }
        // 创建管理层服务对象
         ManageService ms = new ManageService();
       // 按条件查询相应数据
       if(keyword != null){
             List<Article> articles = ms.getRequArticle(manage_type,keyword);
             request.setAttribute("articles",articles);
        }else{
            // 查询所有的图书信息
           List<Article> articles = ms.getAllArticle(pagerModel);
            request.setAttribute("articles",articles);
           request.setAttribute("pageModel",pagerModel);
         }
        //跳转后台首页
       request.getRequestDispatcher("/WEB-INF/view/back/bookManage.jsp").forward(request,response);
        String select_type = request.getParameter("select_type");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
