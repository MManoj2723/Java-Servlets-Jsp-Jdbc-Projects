<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="test.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
out.println("Page belongs to admin:"+ab.getFname()+"<br>");
out.println("-----------------------------"+"<br>");
Student st = (Student)request.getAttribute("st");
%>
<form action="update" method="post">
<input type="hidden" name="rollno" value=<%=st.getRollno()%>>
CoreJava: <input type="text" name="cjava" value=<%=st.getMk().getcJava()%>><br>
AdvJava: <input type="text" name="adjava" value=<%=st.getMk().getAdJava()%>><br>
UI: <input type="text" name="ui" value=<%=st.getMk().getUi()%>><br>
DB: <input type="text" name="db" value=<%=st.getMk().getDb()%>><br>
Tools: <input type="text" name="tools" value=<%=st.getMk().getTools()%>><br>
<input type="submit" value="UpdateMarks">
</form>

</body>
</html>