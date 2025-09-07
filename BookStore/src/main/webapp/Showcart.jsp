<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.*" %>
<%@ page import ="beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Shopping Cart</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f7f7f7;
        margin: 0;
        padding: 20px;
    }

    .container {
        background-color: #ffffff;
        border-radius: 8px;
        padding: 20px;
        max-width: 900px;
        margin: auto;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    }

    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }

    th, td {
        text-align: left;
        padding: 12px;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #f2f2f2;
        color: #333;
    }

    tr:hover {
        background-color: #f9f9f9;
    }

    .empty-message {
        text-align: center;
        color: #888;
        font-size: 18px;
        margin-bottom: 20px;
    }

    .shop-link {
        display: inline-block;
        text-align: center;
        margin-top: 10px;
        text-decoration: none;
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border-radius: 5px;
        transition: background-color 0.3s ease;
    }

    .shop-link:hover {
        background-color: #45a049;
    }

    .qty-form {
        display: flex;
        gap: 8px;
        align-items: center;
    }

    .qty-form input[type=number] {
        width: 60px;
        padding: 4px;
    }

    .qty-form button {
        padding: 4px 10px;
        border: none;
        background-color: #007bff;
        color: white;
        border-radius: 4px;
        cursor: pointer;
    }

    .qty-form button:hover {
        background-color: #0056b3;
    }

    .remove-btn {
        background-color: #e74c3c;
        color: white;
        border: none;
        padding: 6px 12px;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.3s ease;
        font-size: 14px;
    }

    .remove-btn:hover {
        background-color: #c0392b;
    }

    /* Place Order button */
    .place-order-form {
        text-align: center;
        margin-top: 20px;
    }

    .place-order-btn {
        background-color: #ff9800;
        color: white;
        border: none;
        padding: 12px 24px;
        border-radius: 6px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease, transform 0.1s ease;
    }

    .place-order-btn:hover {
        background-color: #e68900;
        transform: scale(1.05);
    }
</style>
</head>
<body>
<div class="container">
    <h2>Your Shopping Cart</h2>
    <%
    String cartEmpty = (String) request.getAttribute("cartEmpty");
    LinkedList<ShowCartBean> showcart = (LinkedList<ShowCartBean>) session.getAttribute("showcart");
    
    if (cartEmpty != null) {
    %>
        <div class="empty-message"><%= cartEmpty %></div>
    <%
    } else {
    %>
        <table>
            <tr>
                <th>Book ID</th>
                <th>Title</th>
                <th>Quantity</th>
                <th>Total Price</th>
                <th>Update</th>
                <th>RemoveBook</th>
            </tr>
            <%
            for (ShowCartBean sb : showcart) {
            %>
            <tr>
                <td><%= sb.getbId() %></td>
                <td><%= sb.getbTitle() %></td>
                <td><%= sb.getQty() %></td>
                <td>₹<%= sb.getTotalPrice() %></td>
                <td>
                    <form class="qty-form" action="updateCart" method="post">
                        <input type="hidden" name="bid" value="<%= sb.getbId() %>">
                        <input type="hidden" name="bqty" value="<%= sb.getQty() %>">
                        <button type="submit" name="updt" value="increment">+</button>
                        <button type="submit" name="updt" value="decrement">−</button>
                    </form>
                </td>
                <td>
				    <form action="removebook" method="post" style="display:inline;">
				        <input type="hidden" name="bid" value="<%= sb.getbId() %>">
				        <input type="submit" name="remove" value="RemoveBook" class="remove-btn">
				    </form>
				</td>
            </tr>
            <%
            }
            %>
        </table>

        <!-- Place Order Form -->
        <form class="place-order-form" action="placeorder" method="post">
            <%
                for (ShowCartBean sb : showcart) {
            %>
                <input type="hidden" name="bid[]" value="<%= sb.getbId() %>">
                <input type="hidden" name="bqty[]" value="<%= sb.getQty() %>">
            <%
                }
            %>
            <input type="submit" value="Place Order" class="place-order-btn">
        </form>
    <%
    }
    %>
        
    <div style="text-align:center; margin-top:15px;">
        <a class="shop-link" href="showb">Continue Shopping</a>
    </div>
</div>
</body>
</html>
