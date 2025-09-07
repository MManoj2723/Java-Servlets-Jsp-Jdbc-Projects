<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="beans.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Books</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        height: 100vh;
        margin: 0;
    }
    .container {
        background: white;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        width: 80%;
        max-width: 900px;
    }
    h2 {
        text-align: center;
        color: #333;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 15px;
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th, td {
        padding: 10px;
        text-align: center;
    }
    th {
        background-color: #007bff;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    .actions a {
        text-decoration: none;
        background-color: #28a745;
        color: white;
        padding: 5px 10px;
        border-radius: 5px;
        transition: 0.3s;
    }
    .actions a:hover {
        background-color: #218838;
    }
    .nav-links {
        margin-top: 20px;
        display: flex;
        gap: 15px;
    }
    .nav-links a {
        text-decoration: none;
        padding: 10px;
        background-color: #007bff;
        color: white;
        border-radius: 5px;
        transition: 0.3s;
    }
    .nav-links a:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Available Books</h2>
        <table>
            <tr>
                <th>Book ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Publisher</th>
                <th>Year</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Actions</th>
            </tr>
            <%
            ArrayList<BookBean> al = (ArrayList<BookBean>) request.getAttribute("arraylist");
            for (BookBean b : al) {
            %>
            <tr>
                <td><%= b.getbId() %></td>
                <td><%= b.getbTitle() %></td>
                <td><%= b.getbAuthor() %></td>
                <td><%= b.getbPublisher() %></td>
                <td><%= b.getbPubYear() %></td>
                <td>₹<%= b.getbPrice() %></td>
                <td><%= b.getBqty() %></td>
                <td class="actions">
                    <a href="editb?bid=<%= b.getbId() %>">Edit</a>
                </td>
            </tr>
            <% } %>
        </table>

        <div class="nav-links">
            <a href="AddBook.html">➕ Add Book</a>
            <a href="logout">🚪 Logout</a>
        </div>
    </div>
</body>
</html>
