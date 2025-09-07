<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import ="test.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
Student st=(Student)request.getAttribute("st");
out.println("page belongs to:"+st.getName()+"<br>");
out.println("-------------------------"+"<br>");

out.print("Rollno:"+st.getRollno()+"&nbsp;&nbsp;");
out.print("Name:"+st.getName()+"&nbsp;&nbsp;");
out.print("Course:"+st.getCourse()+"&nbsp;&nbsp;");
out.print("TotalMarks:"+st.getTotmrks()+"&nbsp;&nbsp;");
out.print("Per:"+st.getPer()+"&nbsp;&nbsp;");
out.print("Result:"+st.getResult()+"&nbsp;&nbsp;");
%>
<!-- <a href="viewsm">ViewMarks</a> -->  

<a href="ViewStudentMarks.jsp">ViewMarks</a>
<a href="slogout">Logout</a>
</body>
</html>