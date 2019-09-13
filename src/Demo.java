import cn.hoook.util.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {
    private Connection conn=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    public void setedbac(){
        conn = DatabaseConnection.getConn();
        String sql = "SELECT * FROM member ";
        try{
            PreparedStatement ps= conn.prepareStatement(sql);
        //4.执行查询操作,返回结果集
        ResultSet rs=ps.executeQuery();
        if(rs.next()) {
            //rs.getInt(1)  提取结果集中第一个字段,类型与数据库中类型匹配
            System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    public static void main(String[] args) {
        Demo jdbc=new Demo();
        jdbc.setedbac();
    }
}
