package com.lebooks.service;

import com.lebooks.dao.ShopCartDao;
import com.lebooks.entity.ShopCart;

import java.util.List;


public class ShopCartService {
    ShopCartDao cartDao = new ShopCartDao();
    // 根据用户信息以及商品ID查询购物车详情表  判断该商品是否存在于用户的购物车当中
    public ShopCart getShopCartByUserIdAndArticleId(int user_id, int article_id) {

        return cartDao.getShopCartByUserIdAndArticleId(user_id,article_id);
    }
    // 进行更新操作
    public void updateShopCart(int user_id, int article_id, int article_amount, String sum) {
        cartDao.updateShopCart(user_id,article_id,article_amount,sum);
    }
    // 进行添加操作
    public void addShopCart(int user_id, int article_id, int article_amount,String price,String book_name) {
        cartDao.addShopCart(user_id,article_id,article_amount,price,book_name);
    }
    // 根据用户ID获取购物车中商品信息
    public List<ShopCart> findAllShopCartByUserId(int user_id) {
        List<ShopCart> carts = cartDao.findAllShopCartByUserId(user_id);
        return carts;
    }
}
