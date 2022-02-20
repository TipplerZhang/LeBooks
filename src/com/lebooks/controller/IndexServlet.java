package com.lebooks.controller;




import com.lebooks.entity.Article;
import com.lebooks.entity.ArticleType;
import com.lebooks.service.ArticleService;
import com.lebooks.service.ArticleTypeService;

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
        // 获取商品第一类型
        String book_birthplace = req.getParameter("book_birthplace");
        // 获取商品第二类型
        String book_type = req.getParameter("book_type");
        //创建商品服务区对象
        ArticleService as = new ArticleService();
        // 创建商品类型服务层对象
        ArticleTypeService ats = new ArticleTypeService();
        if(book_birthplace != null){
            //获取所有的商品
            List<Article> articles1 = as.getFAllArticle(book_birthplace);
            // 将商品信息存放至request对象中
            req.setAttribute("articles",articles1);
        }else if (book_type != null){
            //获取所有的商品
            List<Article> articles2 = as.getSAllArticle(book_type);
            // 将商品信息存放至request对象中
            req.setAttribute("articles",articles2);
        }else{
            List<Article> articles = as.getSAllArticle(null);
            req.setAttribute("articles",articles);
        }

        // 获取商品的一级类型
        List<ArticleType> types = ats.getAllType();
        // 将商品类型信息存放至request对象
        req.setAttribute("types",types);
        //跳转首页
        req.getRequestDispatcher("/WEB-INF/view/front/articleIndex.jsp").forward(req,resp);
    }
}
