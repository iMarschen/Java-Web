<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ page import="java.util.List"%>  
<%@ page import="bean.StudentInfoBean"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>新增学生信息页面</title>  
<style type="text/css">  
tr {  
    text-align: center;  
}  
</style>  
</head>  
<body>  
    <div style="margin: 0 auto; margin-top: 40px;">  
        <form action="addStuInfoReq?reqType=ADD_STU_INFO" method="POST">  
            <center>  
                <table width="40%" ; border="1" ; bgcolor="#66FFFF">  
                    <caption style="margin-bottom: 20px">新增学生信息</caption>  
                    <tr>
                    	<td>学生学号：</td>
                    	<td> <input  type="text" name="stuSno"></td>
                    </tr>
                    <tr>  
                        <td>学生姓名：</td>  
                        <td><input type="text" name="stuSname"></td>  
                    </tr>  
                    <tr>  
                        <td>学生性别：</td>  
                        <td><select width="300px" name="stuSsex">  
                                <option>m</option>  
                                <option>f</option>  
                        </select></td>  
                    </tr>  
                    <tr>  
                        <td>学生年龄：</td>  
                        <td><input type="text" name="stuSage"> <input  
                            type="hidden" name="classId"  
                            value="<%=request.getParameter("cid")%>"></td>  
                    </tr>  
                    <tr>  
                        <td><input type="reset" value="重置"></td>  
                        <td><input type="submit" value="确定"></td>  
                    </tr>  
                </table>  
            </center>  
        </form>  
    </div>  
  
    <div style="margin: 0 auto; margin-top: 40px;">  
        <center>  
            <table width="80%" ; border="1" ; bgcolor="#66FFFF">  
                <caption style="margin-bottom: 20px">学生信息列表</caption>  
                <tr>  
                    <th>班级</th>  
                    <th>学号</th>  
                    <th>姓名</th>  
                    <th>性别</th>  
                    <th>年龄</th>  
                    <th>成绩</th> 
                </tr>  
                <%  
                    List<StudentInfoBean> stuInfo=(List<StudentInfoBean>)request.getAttribute("allStudentInfo");  
                    for(StudentInfoBean stu: stuInfo){  
                %>  
                <tr>  
                    <td><%=stu.getCid()%></td>  
                    <td><%=stu.getSno()%></td>  
                    <td><%=stu.getSname()%></td>  
                    <td><%=stu.getSsex()%></td>  
                    <td><%=stu.getSage()%></td>  
                    <td><%=stu.getSbalance()%></td>
                </tr>  
                <%  
                    }  
                %>  
            </table>  
        </center>  
    </div> 
</body>  
</html>  
