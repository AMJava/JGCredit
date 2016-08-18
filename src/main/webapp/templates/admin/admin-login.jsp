<%--
  Created by IntelliJ IDEA.
  User: Arturs
  Date: 16.08.2016
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="../admin-shared/admin-header.jsp" %>
<center><h1>JG Credit Admin Panel</h1></center>
<center>
  <h2>Sign In</h2>
  <form action="login" method="Post">
    <br/>Username:<input type="text" name="username">
    <br/>Password:<input type="password" name="password">
    <br/><input type="submit" value="Submit"  name="submit">
  </form>
</center>
<div class="header_02"><%= request.getAttribute("model") %></div>
</body>
</html>
