<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7f6;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            width: 60%;
            padding: 30px;
            background-color: #fff;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: center;
            color: #333;
        }

        h2 {
            color: #4CAF50;
            font-size: 24px;
            margin-bottom: 20px;
        }

        .welcome-message {
            font-size: 20px;
            font-weight: bold;
            color: #4CAF50;
            margin: 20px 0;
            padding: 10px;
            background-color: #e8f5e9;
            border-radius: 5px;
        }

        .highlight-message {
            font-size: 18px;
            font-weight: bold;
            color: #fff;
            background-color: #FF5733; /* Orange background */
            padding: 15px;
            border-radius: 8px;
            margin: 20px 0;
        }

        a {
            text-decoration: none;
            color: #fff;
            font-size: 18px;
            margin: 10px 0;
            display: inline-block;
            padding: 12px 30px;
            border-radius: 5px;
            background-color: #4CAF50;
            transition: 100ms;
        }

        a:hover {
            background-color: #45a049;
             transform: scale(1.05);
        }

        /* .logout-link {
            margin-top: 4px;
        } */
    </style>
</head>
<body>
    <div class="container">
        <%
        String name = (String) session.getAttribute("name");
        if (name != null) {
            out.println("<div class='welcome-message'>Welcome Customer: " + name + "</div>");
        }

        String requestMsg = (String) request.getAttribute("nobook");
        if (requestMsg != null) {
            out.println("<div class='highlight-message'>-------------- " + requestMsg + " --------------</div>");
        }
        %>

        <br><a href="showb">Show Books</a>
        <a href="showcart">ShowCart</a>
        <a href="showRecentOrders">RecentOrders</a>
        <div class="logout-link"><a href="clogout">Logout</a></div>
    </div>
</body>
</html>
