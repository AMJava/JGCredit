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
  <link href="images/icon.png" rel="icon" type="image/png" />
  <link rel="stylesheet" href="styles/style.css">
  <title>Profile</title>
</head>
<body>
<%@ include file="../shared/header.jsp" %>
<div class="header_02"><%= request.getAttribute("model") %></div>
<%@ include file="../shared/footer.jsp" %>
</body>
</html>
