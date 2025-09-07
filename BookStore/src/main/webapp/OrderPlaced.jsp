<%--  <%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%
String orderSuccess=
					(String)request.getAttribute("OrderPlacedSuccess");


if(orderSuccess!=null){
	out.println(orderSuccess);
}
%>


<%
String orderFailed=
					(String)request.getAttribute("OrderPlacedFailed");

if(orderFailed!=null){
	out.println(orderFailed);
}

%>

<%
		String noQuantity=(String)request.getAttribute("noEnoughQuantity");

		if(noQuantity!=null){
			out.println("Unable TO Place The Order Enough Quantity Not Found For BId:"+noQuantity);
		}
%>

 --%>
 
 
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Status</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9fafb;
            margin: 0;
            padding: 20px;
        }

        .message-container {
            max-width: 600px;
            margin: 20px auto;
            padding: 15px 20px;
            border-radius: 12px;
            font-size: 16px;
            font-weight: 500;
            text-align: center;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }

        .success {
            background-color: #e6ffed;
            color: #05603a;
            border: 1px solid #05603a;
        }

        .error {
            background-color: #ffe6e6;
            color: #a80000;
            border: 1px solid #a80000;
        }
    </style>
</head>
<body>

<%
    String orderSuccess = (String) request.getAttribute("OrderPlacedSuccess");
    if (orderSuccess != null) {
%>
    <div class="message-container success">
        <%= orderSuccess %>
    </div>
    
<%

response.sendRedirect("showb");

 }
%>

<%
    String orderFailed = (String) request.getAttribute("OrderPlacedFailed");
    if (orderFailed != null) {
%>
    <div class="message-container error">
        <%= orderFailed %>
    </div>
<%
    }
%>


<%
Integer noQuantity=(Integer)request.getAttribute("noEnoughQuantity");
if(noQuantity!=null){
%>

<div class="message-container error">
        <%="Unable TO Place The Order Enough Quantity Not Found For BId:"+noQuantity %>
    </div>
<%
}
%>

</body>
</html> 
 


 


 


 


 