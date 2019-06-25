package util;  
  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  

public class DBUtil {  
	static String CLASSFORNAME="com.mysql.jdbc.Driver";
	static String SERVANDDB="jdbc:mysql://localhost:3306/studentsystem?useSSL=false";
	static String USER="root";
	static String PWD="root";
    static{  
        // 加载数据库驱动  
                try {  
                    Class.forName(CLASSFORNAME);  
                } catch (ClassNotFoundException e) {  
                    e.printStackTrace();  
                }  
    }  
      
    public static Connection getConnection() {  
        Connection conn = null;  
        try {  
            // 获取数据库连接  
            conn = DriverManager  
                    .getConnection(SERVANDDB,  
                            USER, PWD);  
    }catch (SQLException e) {  
        e.printStackTrace();  
    }   
        return conn;  
    }  
      
//  关闭相关连接  
    public static void release(Connection conn,Statement stmt ,ResultSet rs){  
        if (conn != null) {  
            try {  
                conn.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
        if (stmt != null) {  
            try {  
                stmt.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
        if(rs!=null){  
            try {  
                rs.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}  
