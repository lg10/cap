package cn.hoook.util.database;

import java.sql.*;
import java.util.ResourceBundle;

public class DatabaseConnection {
    //数据库连接信息
    private static final String DBDRIVER = ResourceBundle.getBundle("jdbc").getString("jdbc.driver");
    private static final String DBURL = ResourceBundle.getBundle("jdbc").getString("jdbc.url");
    private static final String DBUSER= ResourceBundle.getBundle("jdbc").getString("jdbc.user");
    private static final String DBPASSWORD = ResourceBundle.getBundle("jdbc").getString("jdbc.password");
    private static Connection conn = null;
    //加载数据库信息
//    public DatabaseConnection(){
//        try {
//            Class.forName(DBDRIVER);
//            this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
    //连接数据库
    public static Connection getConn(){
        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    //判断数据库连接是否存在
    public static void closeDB() {
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

