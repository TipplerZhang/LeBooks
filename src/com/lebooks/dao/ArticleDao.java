package com.lebooks.dao;

import com.lebooks.entity.Article;
import com.lebooks.util.pager.PagerModel;

import java.util.ArrayList;
import java.util.List;

public class ArticleDao extends DataBaseDao {

    //获取所有商品信息
    public List<Article> getFAllArticle(String book_birthplace, PagerModel pagerModel) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select * from tab_books where book_birthplace like ? limit ?,?";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setString(1,book_birthplace);
            pstm.setInt(2,pagerModel.getStartSize());
            pstm.setInt(3,pagerModel.getPageSize());
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

    public List<Article> getSAllArticle(String book_type, PagerModel pagerModel) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select * from tab_books where book_type like ? limit ?,?";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setString(1,book_type);
            pstm.setInt(2,pagerModel.getStartSize());
            pstm.setInt(3,pagerModel.getPageSize());
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

    public List<Article> getAllArticle(PagerModel pagerModel) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select * from tab_books limit ?,?";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            pstm.setInt(1,pagerModel.getStartSize());
            pstm.setInt(2,pagerModel.getPageSize());
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
    // 根据商品ID查询商品
    public Article getArticleById(Integer valueOf) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select * from tab_books where book_id = ?";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setInt(1,valueOf);
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
            if (rs.next()){
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
                return article;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return null;
    }


    public boolean deleteBook(int book_id) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "delete FROM tab_books where book_id = ?";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setInt(1,book_id);
            pstm.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return false;
    }

    public boolean editBookInfo(Article article) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "update tab_books set book_name = ?, book_birthplace = ?, book_reserve = ?, book_type = ?, book_press = ?, book_author = ?, book_image = ?, book_description = ?, book_price = ? where book_id = ?";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setString(1,article.getBook_name());
            this.pstm.setString(2,article.getBook_birthplace());
            this.pstm.setInt(3,article.getBook_reserve());
            this.pstm.setString(4,article.getBook_type());
            this.pstm.setString(5,article.getBook_press());
            this.pstm.setString(6,article.getBook_author());
            this.pstm.setString(7,article.getBook_image());
            this.pstm.setString(8,article.getBook_description());
            this.pstm.setString(9,article.getBook_price());
            this.pstm.setInt(10,article.getBook_id());
            pstm.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return false;
    }
    // 查询总记录数
    public int getTotalNum(String type) {
        try{
            // 获取数据源
            this.getConn();
            if(type != null){
                // 准备SQL语句
                String sql = "select count(*) from tab_books where book_birthplace like ? or book_type like ?";
                // 进行查询
                this.pstm = conn.prepareStatement(sql);
                this.pstm.setString(1,type);
                this.pstm.setString(2,type);
            }else{
                String sql = "select count(*) from tab_books";
                // 进行查询
                this.pstm = conn.prepareStatement(sql);
            }
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return 0;
    }

    public int getRequTotalNum(String select_type, String keyword) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select count(*) from tab_books where "+select_type+" like'"+keyword+"'";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return 0;
    }

    public boolean newBook(Article article) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "insert into tab_books (book_name,book_birthplace,book_reserve,book_type,book_press,book_author,book_image,book_description,book_price) values (?,?,?,?,?,?,?,?,?);";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setString(1,article.getBook_name());
            this.pstm.setString(2,article.getBook_birthplace());
            this.pstm.setInt(3,article.getBook_reserve());
            this.pstm.setString(4,article.getBook_type());
            this.pstm.setString(5,article.getBook_press());
            this.pstm.setString(6,article.getBook_author());
            this.pstm.setString(7,article.getBook_image());
            this.pstm.setString(8,article.getBook_description());
            this.pstm.setString(9,article.getBook_price());
            pstm.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return false;
    }
}
