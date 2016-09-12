<%@ page import="lv.javaguru.java2.servlet.mvc.MVCModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <link href="images/icon.png" rel="icon" type="image/png" />
  <link rel="stylesheet" href="styles/style.css">
  <title>Login</title>
</head>
<body>
<%@ include file="templates/shared/header.jsp" %>
  <%
    if (request.getAttribute("message") != null) {
      response.sendRedirect((String)request.getAttribute("message"));
    }
    else{
      response.sendRedirect("/java2");
    }
  %>
<h4 style="color:red"><%=request.getAttribute("message")%></h4>


<!--<script src="js/jquery.min.js"></script>-->
<script src="js/jquery-ui.min.js"></script>
<script src="js/script.js"></script>
<%@ include file="templates/shared/footer.jsp" %>
</body>
</html>
