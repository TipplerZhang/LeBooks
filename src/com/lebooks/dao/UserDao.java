package com.lebooks.dao;

import com.lebooks.entity.User;

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
                user.setUsername(rs.getString("username"));
                user.setUser_account(rs.getString("user_account"));
                user.setUser_address(rs.getString("user_address"));
                user.setUser_birth(rs.getString("user_birth"));
                user.setUser_password("user_password");
                user.setUser_email("user_email");
                user.setUser_phone("user_phone");
                user.setUser_sex("user_sex");
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return null;
    }
}
