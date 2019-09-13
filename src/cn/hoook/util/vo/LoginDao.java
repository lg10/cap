package cn.hoook.util.vo;

import cn.hoook.util.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    public static Connection con = null;
    public static PreparedStatement ps = null;
    public static ResultSet rs = null;
    public static boolean checkLogin(String mid,String password){
        con= DatabaseConnection.getConn();//链接数据库
        String sql = "SELECT mid,password,name,flag FROM member WHERE mid=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,mid);//给mid赋值，用于上述查询语句中“？”
        rs = ps.executeQuery();//执行查询语句
            String pwd = rs.getString("password");//找到数据库中mid对对应的密码
            System.out.println(password);
            if(pwd.equals(password)){//数据库中pwd和jsp中传回password比较
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {     //这里是一些操作数据库之后的一些关闭操作
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
                rs = null;
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
                ps = null;
            }
        }
        return false;
    }
}

