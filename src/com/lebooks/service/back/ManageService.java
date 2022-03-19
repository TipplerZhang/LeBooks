package com.lebooks.service.back;

import com.lebooks.dao.ArticleDao;
import com.lebooks.dao.UserDao;
import com.lebooks.entity.Article;
import com.lebooks.entity.User;

import java.util.List;

public class ManageService {
    private UserDao userDao = new UserDao();
    private ArticleDao articleDao = new ArticleDao();
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    public List<User> getRequUser(String select_type, String keyword) {
        return userDao.getRequUser(select_type,keyword);
    }

    public List<Article> getRequArticle(String select_type, String keyword) {
        keyword = keyword == null ? "%%" :"%" + keyword +"%";
        List<Article> articles = articleDao.getRequArticle(select_type,keyword);
        return articles;
    }

    public List<Article> getAllArticle() {
        List<Article> articles = articleDao.getAllArticle();
        return articles;
    }

    public boolean deleteBook(int book_id) {
        return articleDao.deleteBook(book_id);
    }
}
