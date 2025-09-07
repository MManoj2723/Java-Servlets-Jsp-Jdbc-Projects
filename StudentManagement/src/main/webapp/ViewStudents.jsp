<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="test.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

ArrayList<Student> al=
			(ArrayList<Student>)session.getAttribute("ArrayList");
			
			Iterator<Student> itr=al.iterator();
			while(itr.hasNext()){
				Student st=itr.next();
			out.println(st.getRollno()+"&nbsp&nbsp"
					+st.getName()+"&nbsp&nbsp"
					+st.getCourse()+"&nbsp&nbsp"
					+st.getTotmrks()+"&nbsp&nbsp"
					+st.getPer()+"&nbsp&nbsp"
					+st.getResult()+"&nbsp&nbsp"+
			"<a href='viewm?rollno="+st.getRollno()+"'>ViewMarks</a><br>" );
			out.println("<br>");
	
		}	
%>


</body>
</html>








