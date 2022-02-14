package com.lebooks.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

    //构建数据源
    private static BasicDataSource dataSource = new BasicDataSource();
    static{
        // 指定数据库连接的url地址
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/le_books");
        // 指定数据库驱动
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        // 账号
        dataSource.setUsername("root");
        // 密码
        dataSource.setPassword("258258");
        // 最大保留数
        dataSource.setMaxIdle(5);
        // 超时等待时间
        dataSource.setMaxWaitMillis(3000);
    }

       // 获取连接
    public static Connection getCon(){
        try{
            return dataSource.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //关闭连接
    public static void closeCon(ResultSet rs, PreparedStatement pstm, Connection conn) throws SQLException {
        if(rs != null){
            rs.close();
        }

        if(pstm != null){
            pstm.close();
        }
    }
}
