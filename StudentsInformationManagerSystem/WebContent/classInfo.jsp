<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ page import ="bean.ClassInfoBean" %>  
<%@ page import ="java.util.List" %>  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>班级信息界面</title>
</head>  
<body>  
<div style="margin:0 auto;margin-top: 40px;">  
	<form action="classInfoReq" method="POST">  
		<center>  
			<table width="40%"; border="1"; bgcolor="#66FFFF">  
			<caption style="margin-bottom: 20px">
				新增班级信息
			</caption>  
			<tr>
				<td >班级名称：</td>
				<td><input type="text" name="className"></td>
			</tr> 
			<tr>
				<td>班级序号:</td> 
				<td><input type="text" name="classId"></td>
			</tr> 
			<tr>
				<td><input type="reset" value="重置"></td>
				<td><input type="submit" value="确定"></td>
			</tr>  
			</table>  
		</center>  
	</form>  
</div>  
  
<div style="margin:0 auto;margin-top: 40px;">  
	<center>  
		<table  width="40%"; border="1"; bgcolor="#66FFFF">  
		<caption style="margin-bottom: 20px">
			班级信息列表
		</caption>  
		<tr>
			<th>班级序号</th>
			<th>班级名称</th>
			<th>班级明细</th>
		</tr>  
		<% List<ClassInfoBean> classInfo=(List<ClassInfoBean>)request.getAttribute("classInfo");  
		    if(classInfo!=null && !classInfo.isEmpty()){  
		        for(ClassInfoBean classes : classInfo){  
		            %>             
		            <tr>
		            	<td><%=classes.getCid() %></td>
		            	<td><%=classes.getCname()%></td>
		            	 <td>
		            	 	<a href="<%=request.getContextPath() %>/findAllStudentByClassId?reqType=FIND_STUDENT_BY_CLASS_ID&cid=<%=classes.getCid()%>"
                        	>查看明细
                        	</a>
                        </td> 
		            </tr>  
		<%
			}  
		    }  
		%>  
		</table>  
	</center>  
</div>  
</body>  
</html>
