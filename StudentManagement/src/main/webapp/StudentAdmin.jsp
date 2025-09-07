<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="test.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

Student st=(Student)session.getAttribute("st");
out.println("Welcome Student:"+st.getName()+"<br>");
%>
<a href="viewd">ViewDetails</a><br>
<a href="slogout">Logout</a>
</body>
</html>