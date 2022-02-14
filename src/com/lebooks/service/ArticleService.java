package com.lebooks.service;

import com.lebooks.dao.ArticleDao;
import com.lebooks.entity.Article;

import java.util.List;

public class ArticleService {

    private ArticleDao articleDao = new ArticleDao();
    // 获取所有的商品信息
    public List<Article> getAllArticle(){
        List<Article> articles = articleDao.getAllArticle();
        return articles;
    }
}
