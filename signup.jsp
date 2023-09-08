<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <style>
        #err {
            color: red;
            text-align: center;
            background-color: rgb(244, 234, 234);
            width: 50%;
            margin: 10px auto;
            border: 1px solid red;
            border-radius: 5px;
            font-family: verdana;
            padding-top: 5px; 
            padding-bottom: 5px; 
        }

        small {
            font-size: .7em;
            color: red;
        }
    </style>
</head>
<body>
    <h1>Signup Page...</h1>

    <%@ include file="menu.jsp" %>

    <% String errMsg = (String)request.getAttribute("message"); %>

    <% if(errMsg!=null) { %>
        <div id="err">
            <%= errMsg %>
        </div>
    <% } %>

    <form action="register.do" method="post">
        <table border="1" width="auto" align="center">            
            <tr>
                <th>User Type</th>
                <td>
                    Seller<input type="radio" name="type" value="1"> &nbsp;&nbsp;
                    Buyer<input type="radio" name="type" value="2" checked>
                </td>                
            </tr>
            <tr>
                <th valign="top">Full Name</th>
                <td>
                    <input type="text" required name="name">
                    <% String unameErr = (String)request.getAttribute("uname_err"); %>
                    <% if(unameErr!=null) {%>
                        <br>
                        <small><%= unameErr %></small>
                    <% } %>
                </td>
            </tr>
            <tr>
                <th>Email</th>
                <td>
                    <input type="email" required name="email">
                    <% String emailErr = (String)request.getAttribute("email_err"); %>
                    <% if(emailErr != null) { %>
                        <br>
                        <small><%= emailErr %></small>
                    <% } %>
                </td>                
            </tr>
            <tr>
                <th>Password</th>
                <td>
                    <input type="password" required name="password">
                    <% String passwErr = (String)request.getAttribute("passw_err"); %>
                    <% if(passwErr != null) { %>
                        <br>
                        <small><%= passwErr %></small>
                    <% } %>
                </td>                
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Signup">
                </td>
            </tr>
        </table>
    </form>


</body>
</html>