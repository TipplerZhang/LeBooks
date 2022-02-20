package com.lebooks.service;

import com.lebooks.dao.ArticleDao;
import com.lebooks.entity.Article;

import java.util.List;

public class ArticleService {

    private ArticleDao articleDao = new ArticleDao();
    // 获取所有的商品信息
    public List<Article> getFAllArticle(String book_birthplace){
        book_birthplace = book_birthplace == null ? "%" : book_birthplace + "%";
        List<Article> articles = articleDao.getAllArticle(book_birthplace);
        return articles;
    }

    public List<Article> getSAllArticle(String book_type) {
        book_type = book_type == null ? "%" : book_type + "%";
        List<Article> articles = articleDao.getAllArticle(book_type);
        return articles;
    }
}
