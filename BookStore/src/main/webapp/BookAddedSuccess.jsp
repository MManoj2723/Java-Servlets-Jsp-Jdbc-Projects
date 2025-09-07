<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="beans.*" %>
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
        padding: 25px;
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        width: 400px;
        text-align: center;
    }
    h2 {
        color: #333;
        margin-bottom: 10px;
    }
    .msg {
        background-color: #ffeb3b;
        padding: 10px;
        border-radius: 5px;
        margin: 10px 0;
        font-weight: bold;
    }
    .links {
        display: flex;
        flex-direction: column;
        gap: 10px;
        margin-top: 15px;
    }
    .link {
        display: block;
        text-decoration: none;
        color: white;
        background-color: #007bff;
        padding: 10px;
        border-radius: 5px;
        font-weight: bold;
        transition: background 0.3s ease;
    }
    .link:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Admin Dashboard</h2>
        <%
        AdminBean ab = (AdminBean) session.getAttribute("abean");
        String str = (String) request.getAttribute("msg");
        %>
        <p><strong>Page belongs to:</strong> <%= ab.getFname() %></p>
        <hr>
        <% if (str != null) { %>
            <div class="msg"><%= str %></div>
        <% } %>
        <div class="links">
            <a href="AddBook.html" class="link">➕ Add Book</a>
            <a href="viewb" class="link">📚 View All Books</a>
            <a href="logout" class="link">🚪 Logout</a>
        </div>
    </div>
</body>
</html>
