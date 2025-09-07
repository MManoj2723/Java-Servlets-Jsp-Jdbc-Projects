<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Status</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 50px;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }

    .container {
        background-color: #ffffff;
        padding: 30px 40px;
        border-radius: 10px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        max-width: 600px;
        width: 100%;
        text-align: center;
    }

    p {
        font-size: 18px;
        color: #333;
        margin-bottom: 20px;
    }

    .highlight {
        color: #d9534f;
        font-weight: bold;
    }

    .success {
        color: green;
        font-weight: bold;
    }

    .error {
        color: red;
        font-weight: bold;
    }

    .link-btn {
        display: inline-block;
        margin: 10px 10px 0 10px;
        padding: 10px 20px;
        background-color: #007BFF;
        color: #fff;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s ease;
    }

    .link-btn:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<div class="container">
<%
String invid = (String) request.getAttribute("invid");
String msg = (String) request.getAttribute("msg");
String baddeds = (String) request.getAttribute("baddeds");
String baddedf = (String) request.getAttribute("baddedf");
String bookalreadyincart = (String) request.getAttribute("bookalreadyincart");
String bid = (String) request.getAttribute("bid");

if (invid != null) {
%>
    <p class="error"><%= invid %></p>
<%
} else if (msg != null) {
%>
    <p class="error"><%= msg %> <br> for the Book ID: <span class="highlight"><%= bid %></span></p>
<%
} else if (baddeds != null) {
%>
    <p class="success"><%= baddeds %></p>
    <a class="link-btn" href="showcart">Show Cart</a>
<%
} else if (baddedf != null) {
%>
    <p class="error"><%= baddedf %></p>
<%
} else if (bookalreadyincart != null) {
%>
    <p class="highlight"><%= bookalreadyincart %></p>
    <a class="link-btn" href="showcart">Show Cart</a>
<%
}
%>
    <a class="link-btn" href="showb">Go Back</a>
</div>
</body>
</html>
