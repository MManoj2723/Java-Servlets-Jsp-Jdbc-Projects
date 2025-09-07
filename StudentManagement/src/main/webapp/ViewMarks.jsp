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

AdminBean ab=(AdminBean)session.getAttribute("abean");
out.println("page belongs to admin:"+ab.getFname()+"<br>");
out.println("-----------------------------"+"<br>");
Student st=(Student)request.getAttribute("st");

out.println("Rollno:"+st.getRollno()+"<br>"
		+"CoreJava:"+st.getMk().getcJava()+"<br>"
		+"AdJava:"+st.getMk().getAdJava()+"<br>"
		+"Ui:"+st.getMk().getUi()+"<br>"
		+"DB:"+st.getMk().getDb()+"<br>"
		+"Tools:"+st.getMk().getTools()+"<br>");
%>
<%-- <a href="editmrks?rollno=<%=st.getRollno()%>">EditMarks</a> --%>
<a href="editmrks?rollno=<%=st.getRollno()%>">EditMarks</a>
<a href="Student.html">AddStudent</a>
<a href="view">ViewAllStudents</a>
<a href="logout">Logout</a>

</body>
</html>