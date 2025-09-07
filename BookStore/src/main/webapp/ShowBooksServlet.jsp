<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="beans.*" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="showbooks.css">
    <meta charset="UTF-8">
    <title>Available Books</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
   i{
	cursor: pointer;
	}
	#m{
		border-radius: 5px;
		background-color:#007bff;
		padding: 10px;
		color:white; 
		transition: 200ms;
		text-decoration: none;
	}
	#m:hover{
		 background-color: #0056b3;
		 /* text-decoration:underline;  */
		 transform: scale(1.05);
	}
    </style>
</head>
<body>
    <h2>Available Books</h2>
    
    <table>
        <thead>
            <tr>
                <th>Book ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Publisher</th>
                <th>Year</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>AddtoCart</th>
            </tr>
        </thead>
        <tbody>
            <%
            String cid=(String)session.getAttribute("cid");
            
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
                <td><a  href="addtocart?bid=<%= b.getbId() %>"><i class="fa-solid fa-cart-plus"></i></a></td>
            </tr>
            <% } %>
        </tbody>
    </table>

    
    <br><a id="m" href="showcart">ShowCart</a>
    <a id="m" href="clogout">Logout</a>
    <a id="m" href="showRecentOrders">RecentOrders</a>
    
    
    
    
    
    
</body>
</html>
