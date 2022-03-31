package com.lebooks.dao;

import com.lebooks.entity.Admin;
import com.lebooks.util.pager.PagerModel;

import java.util.ArrayList;
import java.util.List;


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
                admin.setAdmin_grade(rs.getInt("admin_grade"));
                return admin;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return null;
    }

    public List<Admin> getRequAdmin(String select_type, String keyword) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select * from tab_admin where "+select_type+" like'"+keyword+"'";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
            // 创建Admin对象数组来存储数据
            List<Admin> admins = new ArrayList<>();
            while (rs.next()){
                Admin admin= new Admin();
                admin.setAdmin_id(rs.getInt("admin_id"));
                admin.setAdmin_account(rs.getString("admin_account"));
                admin.setAdmin_sex(rs.getString("admin_sex"));
                admin.setAdmin_name(rs.getString("admin_name"));
                admin.setAdmin_email(rs.getString("admin_email"));
                admin.setAdmin_phone(rs.getString("admin_phone"));
                admin.setAdmin_grade(rs.getInt("admin_grade"));
                admins.add(admin);
            }
            return admins;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return null;
    }

    public List<Admin> getALLAdmin(PagerModel pagerModel) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select * from tab_admin limit ?,?";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            pstm.setInt(1,pagerModel.getStartSize());
            pstm.setInt(2,pagerModel.getPageSize());
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
            // 创建Admin对象数组来存储数据
            List<Admin> admins = new ArrayList<>();
            while (rs.next()){
                Admin admin= new Admin();
                admin.setAdmin_id(rs.getInt("admin_id"));
                admin.setAdmin_account(rs.getString("admin_account"));
                admin.setAdmin_sex(rs.getString("admin_sex"));
                admin.setAdmin_name(rs.getString("admin_name"));
                admin.setAdmin_email(rs.getString("admin_email"));
                admin.setAdmin_phone(rs.getString("admin_phone"));
                admin.setAdmin_grade(rs.getInt("admin_grade"));
                admins.add(admin);
            }
            return admins;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return null;
    }

    public boolean deleteAdmin(int admin_id) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "delete FROM tab_admin where admin_id = ?";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setInt(1,admin_id);
            pstm.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return false;
    }

    public Admin getAdminById(int admin_id) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select * from tab_admin where admin_id = ?";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setInt(1,admin_id);
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
            Admin admin= new Admin();
            if (rs.next()){
                admin.setAdmin_id(rs.getInt("admin_id"));
                admin.setAdmin_account(rs.getString("admin_account"));
                admin.setAdmin_sex(rs.getString("admin_sex"));
                admin.setAdmin_name(rs.getString("admin_name"));
                admin.setAdmin_email(rs.getString("admin_email"));
                admin.setAdmin_phone(rs.getString("admin_phone"));
                admin.setAdmin_grade(rs.getInt("admin_grade"));
                admin.setAdmin_address(rs.getString("admin_address"));
                admin.setAdmin_birth(rs.getString("admin_birth"));
            }
            return admin;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return null;
    }

    public int getTotalNum() {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select count(*) from tab_admin";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return 0;
    }

    public int getRequTotalNum(String select_type, String keyword) {
        try{
            // 获取数据源
            this.getConn();
            // 准备SQL语句
            String sql = "select count(*) from tab_admin where "+select_type+" like'"+keyword+"'";
            // 进行查询
            this.pstm = conn.prepareStatement(sql);
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = pstm.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return 0;
    }
}
