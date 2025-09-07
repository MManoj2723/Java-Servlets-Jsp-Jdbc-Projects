<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>v
<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
out.println("Welcome Admin:"+ab.getFname()+"<br>");
%>
<a href="Student.html">AddStudent</a>
<a href="view">ViewAllStudents</a>
<a href="logout">Logout</a>

</body>
</html>