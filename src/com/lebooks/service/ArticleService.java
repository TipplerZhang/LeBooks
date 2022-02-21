package com.lebooks.service;

import com.lebooks.dao.ArticleDao;
import com.lebooks.entity.Article;

import java.util.List;

public class ArticleService {

    private ArticleDao articleDao = new ArticleDao();
    // 获取所有的商品信息
    public List<Article> getFAllArticle(String book_birthplace){
        book_birthplace = book_birthplace == null ? "%" : book_birthplace + "%";
        List<Article> articles = articleDao.getFAllArticle(book_birthplace);
        return articles;
    }

    public List<Article> getSAllArticle(String book_type) {
        book_type = book_type == null ? "%" : book_type + "%";
        List<Article> articles = articleDao.getSAllArticle(book_type);
        return articles;
    }

    public List<Article> getAllArticle() {
        List<Article> articles = articleDao.getAllArticle();
        return articles;
    }

    public List<Article> getRequArticle(String select_type, String keyword) {
        keyword = keyword == null ? "%%" :"%" + keyword +"%";
        List<Article> articles = articleDao.getRequArticle(select_type,keyword);
        return articles;
    }

    public Article getArticleById(String id) {
        return articleDao.getArticleById(Integer.valueOf(id));
    }
}
