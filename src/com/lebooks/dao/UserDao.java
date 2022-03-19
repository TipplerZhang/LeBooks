package com.lebooks.dao;

import com.lebooks.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao extends DataBaseDao {
    public User getUserByNameAndPass(String loginName, String password) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select * from tab_user where user_email = ? and user_password = ?";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setString(1,loginName);
            this.pstm.setString(2,password);
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
            // 创建User对象用于封装数据
            if (rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setUser_account(rs.getString("user_account"));
                user.setUser_address(rs.getString("user_address"));
                user.setUser_password(rs.getString("user_password"));
                user.setUser_email(rs.getString("user_email"));
                user.setUser_phone(rs.getString("user_phone"));
                user.setUser_sex(rs.getString("user_sex"));
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return null;
    }

    public boolean saveUser(User user) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "insert into tab_user(username,user_password,user_email) value (?,?,?)";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setString(1,user.getUsername());
            this.pstm.setString(2,user.getUser_password());
            this.pstm.setString(3,user.getUser_email());
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

    public boolean getUserByEmail(String registerEmail) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select * from tab_user where user_email = ? ";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setString(1,registerEmail);
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
            // 创建User对象用于封装数据
            if (rs.next()){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return false;
    }

    public List<User> getAllUser() {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select * from tab_user ";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
            // 创建User对象数组来存储数据
            List<User> users = new ArrayList<>();
            while(rs.next()){
                // 封装用户信息
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setUser_account(rs.getString("user_account"));
                user.setUser_sex(rs.getString("user_sex"));
                user.setUser_birth(rs.getString("user_birth"));
                user.setUser_email(rs.getString("user_email"));
                user.setUser_address(rs.getString("user_address"));
                user.setUser_phone(rs.getString("user_phone"));

                // 将用户信息存放进集合中
                users.add(user);
            }
            return users;
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return null;
    }

    public List<User> getRequUser(String select_type, String keyword) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select * from tab_user where "+select_type+" like'"+keyword+"'";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
            // 创建User对象数组来存储数据
            List<User> users = new ArrayList<>();
            while(rs.next()){
                // 封装用户信息
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setUser_account(rs.getString("user_account"));
                user.setUser_sex(rs.getString("user_sex"));
                user.setUser_birth(rs.getString("user_birth"));
                user.setUser_email(rs.getString("user_email"));
                user.setUser_address(rs.getString("user_address"));
                user.setUser_phone(rs.getString("user_phone"));

                // 将用户信息存放进集合中
                users.add(user);
            }
            return users;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return null;
    }
}
