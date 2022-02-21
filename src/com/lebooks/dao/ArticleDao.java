package com.lebooks.dao;

import com.lebooks.entity.Article;
import com.lebooks.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao extends DataBaseDao {

    //获取所有商品信息
    public List<Article> getFAllArticle(String book_birthplace) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select * from tab_books where book_birthplace like ?";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setString(1,book_birthplace);
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
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
            this.close();
        }

        return null;
    }

    public List<Article> getSAllArticle(String book_type) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select * from tab_books where book_type like ?";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setString(1,book_type);
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
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
            this.close();
        }

        return null;
    }

    public List<Article> getAllArticle() {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select * from tab_books ";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
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
            this.close();
        }
        return null;
    }

    public List<Article> getRequArticle(String select_type, String keyword) {
        try{
        // 获取数据源
        this.getConn();
        // 准备SQL语句
        String sql = "select * from tab_books where "+select_type+" like'"+keyword+"'";
        // 进行查询
        this.pstm = conn.prepareStatement(sql);
        //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
        rs = pstm.executeQuery();
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
        this.close();
    }
        return null;
    }
}
