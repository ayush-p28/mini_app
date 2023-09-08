<%@ page import="models.Khilona,java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <style>
        #no_rec {
            border: 1px solid #999;
            background-color: #eee;
            color: #555;
            margin: 10px auto;
            width: 30%;
            font-family: verdana;
            padding-top: 30px; 
            padding-bottom: 30px;
            text-align: center; 
        }
    </style>
</head>
<body>
    
    <h1>All Khilona's Page</h1>

    <%@ include file="menu.jsp" %>

    <%@ include file="menu2.jsp" %>

    <% ArrayList<Khilona> khilonas = (ArrayList<Khilona>)request.getAttribute("all_khilonas"); %>

    <% if(!khilonas.isEmpty()) { %>
        <table border="1" align="center" width="auto">
            <tr>
                <th>Sr.No</th>
                <th>Name</th>
                <th>Price</th>
                <th>Age-Group</th>
                <th>Quantity</th>
                <% if(user.getUserType()==1){ %>
                    <th>Action</th>
                <% } %>
            </tr>
    
            <% int i = 0; %>
    
            <% for(Khilona khilona : khilonas) { %>
                <tr>
                    <td><%= ++i %></td>
                    <td><%= khilona.getName() %></td>
                    <td><%= khilona.getPrice() %></td>
                    <td><%= khilona.getAgeGroup() %></td>
                    <td><%= khilona.getQuantity() %></td>
                    <% if(user.getUserType()==1){ %>
                        <td>
                            <a href="del.do?kid=<%= khilona.getKhilonaId() %>">Delete</a>
                            <a href="update.do?kid=<%= khilona.getKhilonaId() %>">Update</a>
                        </td>
                    <% } %>
                </tr>
            <% } %>
        </table>    
    <% } else { %>
        <div id="no_rec">
            No Khilona Records Found... 
            <% if(user.getUserType() == 1) { %>
            <a href="add.do">Add New Khilona</a>
            <% } %>
        </div>
    <% } %>

    
</body>
</html>