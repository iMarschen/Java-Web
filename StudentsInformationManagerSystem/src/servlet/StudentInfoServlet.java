package servlet;  
  
import java.io.IOException;  
import java.math.BigDecimal;  
import java.util.List;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import bean.StudentInfoBean;  
import dao.StudentInfoDao;  
  
public class StudentInfoServlet extends HttpServlet{  
      
    private static final long serialVersionUID = 1L;  
  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        this.doPost(req, resp);  
    }  
      
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        //设置编码防止响应乱码  
        req.setCharacterEncoding("UTF-8");  
        //获取请求类型  
        String reqType=req.getParameter("reqType");  
          
        if("FIND_STUDENT_BY_CLASS_ID".equals(reqType)){  
            //获取客户端输入的参数  
            int cid=Integer.parseInt(req.getParameter("cid"));  
            //创建学生数据库操作对象  
            StudentInfoDao dao = new StudentInfoDao();  
            List<StudentInfoBean> allStudentInfo=dao.findAllStudentByClassId(cid);  
            //保存查询到的学生信息  
            req.setAttribute("allStudentInfo", allStudentInfo);  
            //将查询结果交给jsp处理  
            req.getRequestDispatcher("/studentInfo.jsp").forward(req, resp);  
        }  
        if("ADD_STU_INFO".equals(reqType)){  
            //获取客户端输入的参数  
            int cid=Integer.parseInt(req.getParameter("classId"));  
            String stuname=req.getParameter("stuSname");  
            String stusex=req.getParameter("stuSsex");  
            int stuage=Integer.parseInt(req.getParameter("stuSage"));  
            int sno=Integer.parseInt(req.getParameter("stuSno"));
            StudentInfoBean bean =new StudentInfoBean();  
            bean.setCid(cid);  
            bean.setSbalance(BigDecimal.ZERO);  
            bean.setSage(stuage);  
            bean.setSname(stuname);  
            bean.setSsex(stusex); 
            bean.setSno(sno);
            //创建学生数据库操作对象  
            StudentInfoDao dao = new StudentInfoDao();  
            dao.addStudentInfo(bean);  
            List<StudentInfoBean> allStudentInfo=dao.findAllStudentByClassId(cid);  
            //保存查询到的学生信息到req作用域中  
            req.setAttribute("allStudentInfo", allStudentInfo);  
            //将查询结果交给jsp处理  
            req.getRequestDispatcher("/studentInfo.jsp?cid="+cid+"").forward(req, resp);  
        }  
          
    }  
}  
