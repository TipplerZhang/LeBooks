package com.lebooks.dao;

import com.lebooks.entity.Admin;


public class AdminDao extends DataBaseDao{
    public Admin getAdminByNameAndPass(String loginName, String password) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select * from tab_admin where admin_email = ? and admin_password = ?";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setString(1,loginName);
            this.pstm.setString(2,password);
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
            // 创建User对象用于封装数据
            if (rs.next()){
                Admin admin= new Admin();
                admin.setAdmin_id(rs.getInt("admin_id"));
                admin.setAdmin_account(rs.getString("admin_account"));
                admin.setAdmin_password(rs.getString("admin_password"));
                admin.setAdmin_name(rs.getString("admin_name"));
                admin.setAdmin_email(rs.getString("admin_email"));
                admin.setAdmin_address(rs.getString("admin_address"));
                admin.setAdmin_permission(rs.getString("admin_permission"));
                return admin;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return null;
    }
}
