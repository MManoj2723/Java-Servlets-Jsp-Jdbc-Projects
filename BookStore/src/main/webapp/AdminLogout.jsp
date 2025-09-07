<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

session.removeAttribute("abean");
session.removeAttribute("arraylist");
session.invalidate();
out.println("Admin Logout SuccessFully!!!!");
%>
<%@ include file="home.html" %>
</body>
</html>