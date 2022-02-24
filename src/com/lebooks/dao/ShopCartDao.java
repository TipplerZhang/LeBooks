package com.lebooks.dao;

import com.lebooks.entity.ShopCart;

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
            ShopCart cart = new ShopCart();
            if (rs.next()){
                cart.setCart_book_amount(rs.getInt("cart_book_amount"));
            }
            return cart ;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return null;
    }
    // 更新购物车中已有订单的数量
    public void updateShopCart(int user_id, int article_id, int article_amount) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "update tab_cart set cart_book_amount = ? where cart_user_id = ? and cart_book_id = ?";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setInt(1,article_amount);
            this.pstm.setInt(2,user_id);
            this.pstm.setInt(3,article_id);
            pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
    }
}
