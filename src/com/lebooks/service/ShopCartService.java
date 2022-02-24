package com.lebooks.service;

import com.lebooks.dao.ShopCartDao;
import com.lebooks.entity.ShopCart;


public class ShopCartService {
    ShopCartDao cartDao = new ShopCartDao();
    // 根据用户信息以及商品ID查询购物车详情表  判断该商品是否存在于用户的购物车当中
    public ShopCart getShopCartByUserIdAndArticleId(int user_id, int article_id) {

        return cartDao.getShopCartByUserIdAndArticleId(user_id,article_id);
    }
    // 进行更新操作
    public void updateShopCart(int user_id, int article_id, int article_amount) {
        cartDao.updateShopCart(user_id,article_id,article_amount);
    }
}
