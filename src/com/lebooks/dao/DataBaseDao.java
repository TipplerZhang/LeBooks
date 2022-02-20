package com.lebooks.dao;

import java.sql.*;

public class DataBaseDao {
    //	驱动字符串
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    //	连接字符串
    private static final String url = "jdbc:mysql://localhost:3306/le_booksdb?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
    //	用户名
    private static final String username = "root";
    //	密码
    private static final String password = "258258";
    static Connection conn = null;			//	连接对象
    static Statement sm = null; 			//	Statement对象
    static ResultSet rs = null;			//	结果集对象
    //	在构造函数中实现连接

    public static void getConn(){
        try {
            Class.forName(driver);
            //	getConnection(String url):尝试建立与给定数据库URL的连接。
            conn = DriverManager.getConnection(url,username,password);
        }catch(ClassNotFoundException e) {
            //	自动生成捕获块
            e.printStackTrace();
        }catch(SQLException e) {
            //	TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //	实现查询并返回结果集
    public static ResultSet getResult(String sql) {
        try {
            //	createStatement():创建一个 Statement对象，用于将SQL语句发送到数据库。
            sm = conn.createStatement();
            //	executeQuery(String sql):执行给定的SQL语句，该语句返回单个 ResultSet对象。
            rs = sm.executeQuery(sql);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    //	实现增删改
    public static void myUpdate(String sql) {
        try {
            sm = conn.createStatement();
            //	executeUpdate(String sql):	执行给定的SQL语句，这可能是 INSERT ， UPDATE ，或 DELETE语句，或者不返回任何内容，如SQL DDL语句的SQL语句。
            sm.executeUpdate(sql);
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    //	实现关闭资源
    public static void close() {
        try {
            if(rs != null) {
                rs.close();
            }
            if(sm !=null) {
                sm.close();
            }
            if(conn != null) {
                conn.close();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
