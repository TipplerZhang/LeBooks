package com.lebooks.service;

import com.lebooks.dao.ShopCartDao;
import com.lebooks.entity.Article;
import com.lebooks.entity.Order;
import com.lebooks.entity.ShopCart;
import com.lebooks.entity.User;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    // 保存订单
    ShopCartDao cartDao = new ShopCartDao();
    public List<ShopCart> saveOrder( String articleInfo) {
        // 取出购物车中对应的订单id
        articleInfo = articleInfo.substring(1);
        // 按照# 进行划分
        String[] aInfos = articleInfo.split("#");
        List<ShopCart> carts = new ArrayList<>();
        for(int i=0; i<aInfos.length; i++){
            ShopCart cart = new ShopCart();
            cartDao.findShopCartByCartId(cart,Integer.valueOf(aInfos[i]));
            carts.add(cart);
        }
        return carts;
    }
}
