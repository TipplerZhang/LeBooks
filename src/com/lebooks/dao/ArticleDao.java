package com.lebooks.dao;

import com.lebooks.entity.Article;
import com.lebooks.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {

    //获取所有商品信息
    public List<Article> getAllArticle() {
        try{
            // 获取数据源
            DataBaseDao.getConn();
            // 准备SQL语句
            String sql = "select * from tab_books";
            // 进行查询
            ResultSet rs = DataBaseDao.getResult(sql);
            // 创建Article对象接受数据
            List<Article> articles = new ArrayList<>();
            while (rs.next()){
                // 封装商品信息
                Article article = new Article();
                article.setBook_id(rs.getInt("book_id"));
                article.setBook_name(rs.getString("book_name"));
                article.setBook_birthplace(rs.getString("book_birthplace"));
                article.setBook_reserve(rs.getInt("book_reserve"));
                article.setBook_type(rs.getString("book_type"));
                article.setBook_press(rs.getString("book_press"));
                article.setBook_author(rs.getString("book_author"));
                article.setBook_image(rs.getString("book_image"));
                article.setBook_description(rs.getString("book_description"));
                article.setBook_price(rs.getString("book_price"));

                // 将商品信息存放在集合中
                articles.add(article);
            }
            return articles;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DataBaseDao.close();
        }

        return null;
    }
}
