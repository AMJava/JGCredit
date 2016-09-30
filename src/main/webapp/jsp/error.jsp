<%@ page import="lv.javaguru.java2.domain.MVCModel" %>
<%@ page import="lv.javaguru.java2.businesslogic.exceptions.ErrorResponse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <link href="../images/icon.png" rel="icon" type="image/png" />
  <link rel="stylesheet" href="../styles/style.css">
  <title>Fatal Error</title>
</head>
<body>
<h1>Fatal ERROR, PLEASE CONTACT SECOND LINE SUPPORT</h1>
<%
  MVCModel data = (MVCModel)request.getAttribute("model");
  if (data != null) {
    ErrorResponse error = (ErrorResponse)data.getError();
%>
<h4 style="color:red"><%=error.getMessage()%></h4>
<%
  }
%>
</body>
</html>
