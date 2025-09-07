<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Update Status</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 40px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .message-box {
        max-width: 600px;
        background-color: #ffffff;
        padding: 20px 30px;
        border-radius: 10px;
        box-shadow: 0 8px 16px rgba(0,0,0,0.1);
        margin-bottom: 30px;
        font-size: 18px;
        color: #333;
        text-align: center;
    }

    .success {
        border-left: 8px solid #4CAF50;
        background-color: #e8f5e9;
        color: #2e7d32;
    }

    .error {
        border-left: 8px solid #f44336;
        background-color: #ffebee;
        color: #c62828;
    }

    .btn-link {
        text-decoration: none;
        background-color: #007BFF;
        color: white;
        padding: 12px 24px;
        border-radius: 5px;
        font-size: 16px;
        transition: background-color 0.3s ease;
    }

    .btn-link:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<%
String invalid= (String)request.getAttribute("invalid");
String incsuccess= (String)request.getAttribute("incsuccess");
String incfailed= (String)request.getAttribute("incfailed");
String decsuccess= (String)request.getAttribute("decsuccess");
String decfailed= (String)request.getAttribute("decfailed");
String rmvsuccess = (String)request.getAttribute("rmvsuccess");
String rmvfailed = (String)request.getAttribute("rmvfailed");

String message = "";
String cssClass = "";

if(invalid!=null){
    message = invalid;
    cssClass = "error";
}
else if(incsuccess!=null){
    message = incsuccess;
    cssClass = "success";
}
else if(incfailed!=null){
    message = incfailed;
    cssClass = "error";
}
else if(decsuccess!=null){
    message = decsuccess;
    cssClass = "success";
}
else if(decfailed!=null){
    message = decfailed;
    cssClass = "error";
}
else if(rmvsuccess!=null){
    message = rmvsuccess;
    cssClass = "success";
}
else{
    message = rmvfailed;
    cssClass = "error";
}
%>

<div class="message-box <%= cssClass %>">
    <%= message %>
</div>

<a href="showcart" class="btn-link">Back to Cart</a>

</body>
</html>
