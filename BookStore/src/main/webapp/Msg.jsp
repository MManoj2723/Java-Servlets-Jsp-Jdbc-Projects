<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Message Display</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
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
            color: #333;
            text-align: center;
        }

        .message {
            background-color: #FFEB3B;
            padding: 20px;
            border-radius: 8px;
            font-size: 22px;
            font-weight: bold;
            color: #333;
            margin-bottom: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        a {
            font-size: 18px;
            color: #4CAF50;
            text-decoration: none;
            border: 2px solid #4CAF50;
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s ease, color 0.3s ease;
        }

        a:hover {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <%
        String str = (String) request.getAttribute("msg");
        if (str != null) {
            out.println("<div class='message'>" + "********** " + str + " **********" + "</div>");
        }
        %>

        <a href="home.html">Go to Home</a>
    </div>
</body>
</html>
