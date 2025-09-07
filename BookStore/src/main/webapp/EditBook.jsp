<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="beans.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Book Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7f6;
            color: #333;
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
        }

        .form-group {
            margin: 10px 0;
            display: flex;
            flex-direction: column;
        }

        label {
            font-size: 14px;
            color: #555;
            margin-bottom: 5px;
        }

        input[type="text"] {
            padding: 10px;
            font-size: 14px;
            border: 1px solid #ddd;
            border-radius: 4px;
            width: 100%;
            box-sizing: border-box;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
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
        <h1>Update Book Information</h1>
        <div class="info">
            <% 
            AdminBean ab = (AdminBean) session.getAttribute("abean");
            out.println("Page belongs to admin: " + ab.getFname() + "<br>");
            out.println("-----------------------------" + "<br>");
            BookBean b = (BookBean) request.getAttribute("b");
            %>
        </div>
        <form action="updateb" method="post">
            <input type="hidden" name="bid" value="<%=b.getbId()%>">
            
            <div class="form-group">
                <label for="btitle">BTitle:</label>
                <input type="text" name="btitle" id="btitle" value="<%=b.getbTitle()%>">
            </div>
            
            <div class="form-group">
                <label for="bauthor">BAuthor:</label>
                <input type="text" name="bauthor" id="bauthor" value="<%=b.getbAuthor()%>">
            </div>

            <div class="form-group">
                <label for="bpublisher">BPublisher:</label>
                <input type="text" name="bpublisher" id="bpublisher" value="<%=b.getbPublisher()%>">
            </div>

            <div class="form-group">
                <label for="bpyear">BPubYear:</label>
                <input type="text" name="bpyear" id="bpyear" value="<%=b.getbPubYear()%>">
            </div>

            <div class="form-group">
                <label for="bprice">BPrice:</label>
                <input type="text" name="bprice" id="bprice" value="<%=b.getbPrice()%>">
            </div>

            <div class="form-group">
                <label for="bqty">BQty:</label>
                <input type="text" name="bqty" id="bqty" value="<%=b.getBqty()%>">
            </div>

            <input type="submit" value="Update Book">
        </form>
    </div>
</body>
</html>
