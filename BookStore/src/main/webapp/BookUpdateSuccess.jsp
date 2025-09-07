<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="beans.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7f6;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            margin-top: 50px;
        }

        h1 {
            text-align: center;
            color: #4CAF50;
        }

        .info {
            text-align: center;
            font-size: 16px;
            color: #555;
            margin-bottom: 20px;
        }

        .highlight-message {
            text-align: center;
            font-size: 24px;
            font-weight: bold;
            color: #ff5733; /* You can change this color as needed */
            background-color: #f8e6e1; /* Light background to make it pop */
            padding: 15px;
            border-radius: 8px;
            margin-bottom: 20px;
        }

        a {
            display: block;
            text-align: center;
            margin: 10px;
            font-size: 18px;
            color: #4CAF50;
            text-decoration: none;
            padding: 10px;
            border: 1px solid #4CAF50;
            border-radius: 4px;
        }

        a:hover {
            background-color: #4CAF50;
            color: white;
            transition: background-color 0.3s ease;
        }

        .separator {
            text-align: center;
            margin: 20px 0;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome Admin</h1>
        <div class="info">
            <% 
            AdminBean ab = (AdminBean) session.getAttribute("abean");
            out.println("Page belongs to: " + ab.getFname() + "<br>");
            out.println("*************************<br>");
            String str = (String) request.getAttribute("msg");
            %>
        </div>
        <!-- Highlighted Message -->
        <div class="highlight-message">
            <%= str %>
        </div>

        <a href="AddBook.html">Add Book</a>
        <a href="viewb">View All Books</a>
        <a href="logout">Logout</a>
    </div>
</body>
</html>
