<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="test.AdminBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
out.println("Page belongs to:"+ab.getFname()+"<br>"); 
out.println("------------------------"+"<br>");
String msg=(String)request.getAttribute("msg");
out.println(msg+"<br>");
%>
<a href="Student.html">AddStudent</a>
<a href="view">ViewAllStudents</a>
<a href="logout">Logout</a>
</body>
</html>