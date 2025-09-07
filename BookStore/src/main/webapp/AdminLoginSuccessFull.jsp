<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .container {
        background: white;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        text-align: center;
        width: 350px;
    }
    h2 {
        color: #333;
        margin-bottom: 20px;
    }
    .links {
        display: flex;
        flex-direction: column;
        gap: 15px;
    }
    a {
        text-decoration: none;
        color: white;
        background-color: #007bff;
        padding: 10px;
        border-radius: 5px;
        transition: background 0.3s ease;
        font-size: 16px;
    }
    a:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <div class="container">
        <%
            AdminBean ab = (AdminBean) session.getAttribute("abean");
            out.println("<h2>Welcome " + ab.getFname() + " </h2>");
        %>
        <div class="links">
            <a href="AddBook.html">Add Book</a>
            <a href="viewb">View All Books</a>
            <a href="logout">Logout</a>
        </div>
    </div>
</body>
</html>
