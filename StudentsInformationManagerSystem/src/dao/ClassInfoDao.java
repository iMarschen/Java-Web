package dao;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
import java.util.ArrayList;  
import java.util.List;  


import bean.ClassInfoBean;  
  
public class ClassInfoDao {  
  
	String CLASSFORNAME="com.mysql.jdbc.Driver";
	String SERVANDDB="jdbc:mysql://localhost:3306/studentsystem?useSSL=false";
	String USER="root";
	String PWD="root";
   
  
    public void  addClassInfo(ClassInfoBean bean) {  
        Connection conn = null;  
        Statement stmt = null; 
        String cid,cname;
        try {
			Class.forName(CLASSFORNAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        try {  
            // 获取数据库连接  
            conn = DriverManager  
                    .getConnection(SERVANDDB,USER,PWD);  
            // 整理一条SQL语句 
           // System.out.println(bean.getCid());
            cid=bean.getCid().toString();
            cname=bean.getCname();
            String sql = "INSERT INTO class_info (cid,cname) VALUES ('"+cid+"','"  
                    + cname + "')";  
            // 创建SQL执行对象  
            stmt = conn.createStatement();  
            // 执行sql语句  
            int row = stmt.executeUpdate(sql);  
            if (row != 1) {  
                throw new RuntimeException("新增班级失败！");  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {  
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
        }  
    }  
  
    public List<ClassInfoBean> findAll() {  
  
        Connection conn = null;  
        Statement stmt = null;  
        List<ClassInfoBean> classList= new ArrayList<ClassInfoBean>();  
        try {
			Class.forName(CLASSFORNAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        try {  
            // 获取连接  
            conn = DriverManager  
                    .getConnection(SERVANDDB,USER,PWD);  
            // 整理一条SQL语句  
            String sql = "select cid,cname from class_info";  
            // 创建执行sql的对象  
            stmt = conn.createStatement();  
            //执行sql语句  
            ResultSet rs =stmt.executeQuery(sql);  
            //遍历结果集  
            while(rs.next()){  
                int cid =rs.getInt("cid");  
                String cname=rs.getString("cname");  
                ClassInfoBean bean = new ClassInfoBean();  
                bean.setCid(cid);  
                bean.setCname(cname);  
                classList.add(bean);  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return classList;  
    }  
   
  
}  
