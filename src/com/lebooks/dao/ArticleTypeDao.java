package com.lebooks.dao;

import com.lebooks.entity.Article;
import com.lebooks.entity.ArticleType;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticleTypeDao {

    public List<ArticleType> getAllType() {
        try{
            // 获取数据源
            DataBaseDao.getConn();
            // 准备SQL语句
            String sql = "select book_birthplace,book_type from tab_books";
            // 进行查询
            ResultSet rs = DataBaseDao.getResult(sql);
            // 创建Article对象接受数据
            List<ArticleType> articleTypes = new ArrayList<>();
            while (rs.next()){
                // 封装商品信息
                ArticleType articleType = new ArticleType();

                articleType.setBook_birthplace(rs.getString("book_birthplace"));

                articleType.setBook_type(rs.getString("book_type"));
                // 将商品信息存放在集合中
                articleTypes.add(articleType);
            }
            return articleTypes;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DataBaseDao.close();
        }

        return null;
    }
}
