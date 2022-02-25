package com.lebooks.dao;

import com.lebooks.entity.ShopCart;

import java.util.ArrayList;
import java.util.List;

public class ShopCartDao extends DataBaseDao {
    // 根据用户信息以及商品ID查询购物车详情表  判断该商品是否存在于用户的购物车当中
    public ShopCart getShopCartByUserIdAndArticleId(int user_id, int article_id) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select * from tab_cart where cart_user_id = ? and cart_book_id = ?";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setInt(1,user_id);
            this.pstm.setInt(2,article_id);
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
            if (rs.next()){
                ShopCart cart = new ShopCart();
                cart.setCart_book_amount(rs.getInt("cart_book_amount"));
                return cart ;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return null;
    }
    // 更新购物车中已有订单的数量
    public void updateShopCart(int user_id, int article_id, int article_amount, String sum) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "update tab_cart set cart_book_amount = ? , cart_book_price = ? where cart_user_id = ? and cart_book_id = ?";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setInt(1,article_amount);
            this.pstm.setString(2,sum);
            this.pstm.setInt(3,user_id);
            this.pstm.setInt(4,article_id);
            pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
    }
    // 进行添加操作
    public void addShopCart(int user_id, int article_id, int article_amount,String price,String book_name) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "insert into tab_cart(cart_user_id,cart_book_id,cart_book_amount,cart_book_price,cart_bookname) value (?,?,?,?,?)";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setInt(1,user_id);
            this.pstm.setInt(2,article_id);
            this.pstm.setInt(3,article_amount);
            this.pstm.setString(4,price);
            this.pstm.setString(5,book_name);
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
    }
    // 根据用户ID获取购物车中商品信息
    public List<ShopCart> findAllShopCartByUserId(int user_id) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select * from tab_cart where cart_user_id like ?";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setInt(1,user_id);
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
            List<ShopCart> carts = new ArrayList<>();
            while (rs.next()){
                ShopCart cart = new ShopCart();
                cart.setCart_book_id(rs.getInt("cart_book_id"));
                cart.setCart_book_name(rs.getString("cart_bookname"));
                cart.setCart_book_amount(rs.getInt("cart_book_amount"));
                cart.setCart_book_price(rs.getString("cart_book_price"));
                // 将商品信息存放进购物车列表
                carts.add(cart);
            }
            return carts;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return null;
    }
}
