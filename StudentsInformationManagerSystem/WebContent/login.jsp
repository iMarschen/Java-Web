<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>      
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>insert title</title>  
  </head>  
<body>        
<div style="margin:0 auto;">
	<form action="LoginServlet" method="post">
	<center>
	<tr>
	<td> 用户名：</td>
	<td> <input type="text" name="username"></td>
	</tr>
	<br>
	<tr>
	<td> 密码： </td>
	<td><input type="text" name="password"></td>
	</tr>
	<br>
	<tr>
	<td><input type="submit" value="确定"></td>
	</tr>
	</center>
	</from>
</div>
<%
	if(request.getParameter("ifture")!=null)
	{
	}
%>
</body>  
</html>
