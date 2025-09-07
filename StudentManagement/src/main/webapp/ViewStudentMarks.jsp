<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Student st=(Student)session.getAttribute("st");
out.print("Rollno:"+st.getRollno()+"&nbsp;&nbsp;");
out.print("Name:"+st.getName()+"&nbsp;&nbsp;");
out.print("Course:"+st.getCourse()+"&nbsp;&nbsp;");
out.print("TotalMarks:"+st.getTotmrks()+"&nbsp;&nbsp;");
out.print("Per:"+st.getPer()+"&nbsp;&nbsp;");
out.print("Result:"+st.getResult()+"&nbsp;&nbsp;");
out.println("<br>"+"--------------------------"+"<br>");
out.print("Cjava:"+st.getMk().getcJava()+"&nbsp;&nbsp;");
out.print("Adjava:"+st.getMk().getAdJava()+"&nbsp;&nbsp;");
out.print("Ui:"+st.getMk().getUi()+"&nbsp;&nbsp;");
out.print("DB:"+st.getMk().getDb()+"&nbsp;&nbsp;");
out.print("Tools:"+st.getMk().getTools()+"&nbsp;&nbsp;");

%>
<a href="slogout">Logout</a>
</body>
</html>