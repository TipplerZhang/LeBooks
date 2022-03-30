package com.lebooks.service.front;

import com.lebooks.dao.ArticleDao;
import com.lebooks.entity.Article;
import com.lebooks.util.pager.PagerModel;

import java.util.List;

public class ArticleService {

    private ArticleDao articleDao = new ArticleDao();
    // 获取所有的商品信息
    public List<Article> getFAllArticle(String book_birthplace, PagerModel pagerModel){
        book_birthplace = book_birthplace == null ? "%" : book_birthplace + "%";
        // 查询总记录数
        int totalNum = articleDao.getTotalNum(book_birthplace);
        pagerModel.setTotalNum(totalNum);
        List<Article> articles = articleDao.getFAllArticle(book_birthplace,pagerModel);
        return articles;
    }

    public List<Article> getSAllArticle(String book_type, PagerModel pagerModel) {
        book_type = book_type == null ? "%" : book_type + "%";
        // 查询总记录数
        int totalNum = articleDao.getTotalNum(book_type);
        pagerModel.setTotalNum(totalNum);
        List<Article> articles = articleDao.getSAllArticle(book_type,pagerModel);
        return articles;
    }

    public List<Article> getAllArticle(PagerModel pagerModel) {
        // 查询总记录数
        int totalNum = articleDao.getTotalNum(null);
        pagerModel.setTotalNum(totalNum);
        List<Article> articles = articleDao.getAllArticle(pagerModel);
        return articles;
    }

    public List<Article> getRequArticle(String select_type, String keyword, PagerModel pagerModel) {
        keyword = keyword == null ? "%%" :"%" + keyword +"%";
        // 查询符合条件的记录数
        int totalNum = articleDao.getRequTotalNum(select_type,keyword);
        pagerModel.setTotalNum(totalNum);
        List<Article> articles = articleDao.getRequArticle(select_type,keyword);
        return articles;
    }

    public Article getArticleById(String book_id) {
        return articleDao.getArticleById(Integer.valueOf(book_id));
    }
}
