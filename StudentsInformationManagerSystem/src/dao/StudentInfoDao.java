package dao;  
  
import java.math.BigDecimal;  
import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
import java.util.ArrayList;  
import java.util.List;  
  
import util.DBUtil;  
import bean.ClassInfoBean;  
import bean.StudentInfoBean;  
  
public class StudentInfoDao {  
      
    public void addStudentInfo(StudentInfoBean bean) {  
        Connection conn = null;  
        PreparedStatement pstmt = null;  
        try {  
            // 获取数据库连接  
            conn=DBUtil.getConnection();  
            // 整理一条SQL语句  
            String sql = "INSERT INTO student_info (sno,sname,ssex,sage,cid,sbalance) VALUES (?,?,?,?,?,?)";  
                // 创建SQL执行对象  
                pstmt=conn.prepareStatement(sql);  
                // 给预处理对象赋值 
                pstmt.setInt(1, bean.getSno());
                pstmt.setString(2, bean.getSname());  
                pstmt.setString(3, bean.getSsex());  
                pstmt.setInt(4, bean.getSage());  
                pstmt.setInt(5, bean.getCid());  
                pstmt.setBigDecimal(6, BigDecimal.ZERO);  
                //执行SQL语句  
                int row=pstmt.executeUpdate();  
                if (row != 1) {  
                    throw new RuntimeException("新增学生信息失败！");  
                }  
  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }finally{  
                DBUtil.release(conn, pstmt, null);  
            }  
    }  
  
    public List<StudentInfoBean> findAllStudentByClassId(int cid) {  
  
        Connection conn = null;  
        PreparedStatement pstmt = null;  
        ResultSet rs =null;  
        List<StudentInfoBean> stuList= new ArrayList<StudentInfoBean>();  
        try {  
            // 获取连接  
            conn = DBUtil.getConnection();  
            // 整理一条SQL语句  
            //String sql = "SELECT sno,sname,ssex,sage,sbalance from student_info where cid=?";  
            // 创建执行sql的对象  
            pstmt = conn.prepareStatement("SELECT cid,sno,sname,ssex,sage,sbalance from student_info where cid=?");  
            //执行sql语句  
            pstmt.setInt(1, cid);  
            rs =pstmt.executeQuery();  
            //遍历结果集  
            while(rs.next()){  
                int scid =rs.getInt("cid");  
                int sno=rs.getInt("sno");  
                String name=rs.getString("sname");  
                String ssex=rs.getString("ssex");  
                int sage=rs.getInt("sage");  
                BigDecimal sbalance =rs.getBigDecimal("sbalance");  
                //封装成学生Bean对象  
                StudentInfoBean bean = new StudentInfoBean();  
                bean.setCid(scid);  
                bean.setSno(sno);  
                bean.setSname(name);  
                bean.setSage(sage);  
                bean.setSsex(ssex);  
                bean.setSbalance(sbalance);  
                //添加到队列中  
                stuList.add(bean);  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }finally{  
            DBUtil.release(conn, pstmt, rs);  
        }  
        return stuList;  
    }  
  
} 
