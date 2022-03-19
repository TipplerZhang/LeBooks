package com.lebooks.dao;

import com.lebooks.entity.Article;
import com.lebooks.entity.Order;
import com.lebooks.entity.ShopCart;
import com.lebooks.entity.User;

import java.util.ArrayList;
import java.util.List;

public class OrderDao extends DataBaseDao {
    // 保存所有提交的订单
    public boolean saveOrder(User user, String order_time, ShopCart cart) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "insert into tab_order(order_name,order_amount,order_price,order_time,order_receiver_id,order_address,order_status) value (?,?,?,?,?,?,?)";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setString(1,cart.getCart_book_name());
            this.pstm.setInt(2,cart.getCart_book_amount());
            this.pstm.setString(3,cart.getCart_book_price());
            this.pstm.setString(4,order_time);
            this.pstm.setInt(5,user.getUser_id());
            this.pstm.setString(6,user.getUser_address());
            this.pstm.setString(7,"已付款");
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            pstm.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return false;
    }

    public List<Order> getAllOrderByUserId(User user) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select * from tab_order where order_receiver_id = ?";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setInt(1,user.getUser_id());
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
            // 创建Article对象接受数据
            List<Order> orders = new ArrayList<>();
            while (rs.next()){
                Order order = new Order();
                order.setOrder_id(rs.getInt("order_id"));
                order.setOrder_name(rs.getString("order_name"));
                order.setOrder_price(rs.getString("order_price"));
                order.setOrder_amount(rs.getInt("order_amount"));
                order.setOrder_time(rs.getString("order_time"));
                order.setOrder_receiver_id(rs.getInt("order_receiver_id"));
                order.setOrder_address(rs.getString("order_address"));
                order.setOrder_status(rs.getString("order_status"));
                orders.add(order);
            }
            return orders;
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return null;
    }

    public List<Order> getRequOrder(String select_type, String keyword) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select * from tab_order where "+select_type+" like'"+keyword+"'";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
            // 创建Order对象存储数据
            List<Order> orders = new ArrayList<>();
            while (rs.next()){
                Order order = new Order();
                order.setOrder_id(rs.getInt("order_id"));
                order.setOrder_name(rs.getString("order_name"));
                order.setOrder_price(rs.getString("order_price"));
                order.setOrder_amount(rs.getInt("order_amount"));
                order.setOrder_time(rs.getString("order_time"));
                order.setOrder_receiver_id(rs.getInt("order_receiver_id"));
                order.setOrder_address(rs.getString("order_address"));
                order.setOrder_status(rs.getString("order_status"));
                orders.add(order);
            }
            return orders;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return null;
    }

    public List<Order> getAllOrder() {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select * from tab_order ";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
            // 创建Order对象存储数据
            List<Order> orders = new ArrayList<>();
            while (rs.next()){
                Order order = new Order();
                order.setOrder_id(rs.getInt("order_id"));
                order.setOrder_name(rs.getString("order_name"));
                order.setOrder_price(rs.getString("order_price"));
                order.setOrder_amount(rs.getInt("order_amount"));
                order.setOrder_time(rs.getString("order_time"));
                order.setOrder_receiver_id(rs.getInt("order_receiver_id"));
                order.setOrder_address(rs.getString("order_address"));
                order.setOrder_status(rs.getString("order_status"));
                orders.add(order);
            }
            return orders;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return null;
    }
}
