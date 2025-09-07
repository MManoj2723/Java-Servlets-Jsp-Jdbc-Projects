<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="test.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

AdminBean ab=(AdminBean)session.getAttribute("abean");
out.println("page belongs to admin:"+ab.getFname()+"<br>");
out.println("----------------"+"<br>");
String str=(String)request.getAttribute("msg");
out.println(str+"<br>");
String str1=(String)request.getAttribute("rollno");
%>
<a href="Student.html">AddStudent</a><br>
<a href="viewm?rollno=<%=str1%>">ViewAllMarks</a><br>
<a href="logout">Logout</a>
</body>
</html>