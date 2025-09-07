<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="beans.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7f6;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 50%;
            margin: 50px auto;
            padding: 30px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: center;
        }

        .highlight-message {
            font-size: 20px;
            font-weight: bold;
            color: #fff;
            background-color: #4CAF50; /* Green background */
            padding: 20px;
            border-radius: 8px;
            margin: 20px 0;
        }

        .info {
            font-size: 16px;
            color: #333;
        }

        .info a {
            color: #4CAF50;
            text-decoration: none;
        }

        .info a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <%
        RegistrationBean rb = (RegistrationBean) request.getAttribute("rb");
        String str = (String) request.getAttribute("msg");
        out.println("<div class='info'>" + "<br>------------------" + str + "-----------------<br></div>");
        %>

        <!-- Highlighted Message for Customer -->
        <div class="highlight-message">
            Hi: <%= rb.getName() %>, please remember the ID: <%= rb.getCId() %> for login purposes.
        </div>

        <%@ include file="CustomerLogin.html" %>
    </div>
</body>
</html>
