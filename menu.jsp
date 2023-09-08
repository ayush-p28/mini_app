<%@ page import="models.User" %>

<% User user = (User)session.getAttribute("user"); %>

<hr>

<% if(user==null) { %>
    <a href="login.do">Signin</a>
    <a href="register.do">Signup</a>
<% } else { %>
    <a href="logout.do">Signout</a>
<% } %>



<hr>