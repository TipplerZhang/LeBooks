package com.lebooks.service.front;

import com.lebooks.dao.OrderDao;
import com.lebooks.dao.ShopCartDao;
import com.lebooks.entity.Order;
import com.lebooks.entity.ShopCart;
import com.lebooks.entity.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OrderService {
    OrderDao orderDao = new OrderDao();
    ShopCartDao cartDao = new ShopCartDao();
    // 提交订单
    public List<ShopCart> submitOrder( String articleInfo) {
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
    // 保存订单
    public List<Order> saveOrder(User user, String articleInfo) {
        // 取出购物车中对应的订单id
        articleInfo = articleInfo.substring(1);
        // 按照# 进行划分
        String[] aInfos = articleInfo.split("#");
        List<ShopCart> carts = new ArrayList<>();
        // 设置订单提交时间
        String order_time;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(int i=0; i<aInfos.length; i++){
            order_time = formatter.format(calendar.getTime());
            ShopCart cart = new ShopCart();
            // 获取对应订单信息
            cartDao.findShopCartByCartId(cart,Integer.valueOf(aInfos[i]));
            // 保存对应订单信息
            boolean flag = orderDao.saveOrder(user,order_time,cart);
            //添加订单成功后，删除购物车对应商品
            if(flag == true){
                ShopCartService shopCartService = new ShopCartService();
                shopCartService.deleteShopCart(cart.getCart_id());
            }
        }
        return orderDao.getAllOrderByUserId(user);
    }

    public List<Order> findAllOrderByUser(User user) {
        return orderDao.getAllOrderByUserId(user);
    }
}
