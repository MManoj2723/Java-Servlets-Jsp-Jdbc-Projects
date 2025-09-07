<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import ="java.util.*" %>
<%@ page import ="beans.*" %>

<%

String name=(String)session.getAttribute("name");
out.println(name+": Ordders Page");

%>

<%

List<RecentOrdersBean> orders=
						(List<RecentOrdersBean>)request.getAttribute("Orders");

String noOrders=(String)request.getAttribute("noOrders");


if(orders!=null){
	
	for(RecentOrdersBean ro:orders){
		out.print(ro.getProdName()+" ");
		out.print(ro.getProdQty()+" ");
		out.print(ro.getTotalPrice()+" ");
		out.print(ro.getOrdrDate()+" ");
	}
	
}else{
	out.println(noOrders);
}


%> --%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.util.*" %>
<%@ page import ="beans.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Orders Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f9f9f9;
            margin: 0;
            padding: 20px;
        }

        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        .orders-container {
            background: #fff;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0px 2px 10px rgba(0,0,0,0.1);
            max-width: 800px;
            margin: auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }

        th, td {
            padding: 12px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        th {
            background: #4CAF50;
            color: white;
            text-transform: uppercase;
            font-size: 14px;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .no-orders {
            text-align: center;
            color: #777;
            font-size: 16px;
            margin-top: 20px;
        }

        .username {
            font-weight: bold;
            font-size: 18px;
            color: #444;
        }
        .showBooks{
        display: inline-flex;
        justify-content: center;
        align-items: center;

        font-size: 20px;
        font-weight: bold;
        border-radius: 5px;
        padding: 10px;
        background-color: #4CAF50;
       }
       a{
        text-decoration: none;
         color: #fff;
       }
        .container{
        margin:10px;
        display: flex;
        justify-content: center;
        align-items: center;
       }
    </style>
</head>
<body>

<div class="orders-container">
    <%
        String name = (String) session.getAttribute("name");
        if(name != null){
    %>
        <h2><span class="username"><%= name %></span> : Orders Page</h2>
    <% } %>

    <%
        List<RecentOrdersBean> orders = (List<RecentOrdersBean>) request.getAttribute("Orders");
        String noOrders = (String) request.getAttribute("noOrders");

        if (orders != null && !orders.isEmpty()) {
    %>
        <table>
            <tr>
                <th>Product</th>
                <th>Quantity</th>
                <th>Total Price</th>
                <th>Order Date</th>
            </tr>
            <%
                for (RecentOrdersBean ro : orders) {
            %>
            <tr>
                <td><%= ro.getProdName() %></td>
                <td><%= ro.getProdQty() %></td>
                <td>₹<%= ro.getTotalPrice() %></td>
                <td><%= ro.getOrdrDate() %></td>
            </tr>
            <%
                }
            %>
        </table>
        
        
    <%
        } else {
    %>
        <div class="no-orders"><%= noOrders %></div>
    <%
        }
    %>
    <%-- <%
    
    String cid=(String)session.getAttribute("cid");
    
    out.println(cid);
    
    
    %> --%>
    
 
</div>


<div class="container">
<div class="showBooks">
<a href="showb"> Show Books</a>
</div>
</div>

</body>
</html>
