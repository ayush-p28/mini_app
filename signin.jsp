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
    <h1>Signin Page...</h1>

    <%@ include file="menu.jsp" %>

    <% String errMsg = (String)session.getAttribute("err_msg"); %>

    <% if(errMsg != null) { %>
        <div id="err">
            <%= errMsg %>
        </div>
    <% } %>    

    <form action="login.do" method="post">

        <table border="1" width="auto" align="center">

            <tr>
                <th>Email</th>
                <td><input type="email" required name="email"></td>
            </tr>
            <tr>
                <th>Password</th>
                <td><input type="password" required name="password"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Signin">
                </td>
            </tr>
        </table>
    </form>


</body>
</html>