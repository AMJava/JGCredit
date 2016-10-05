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
<%@ include file="../jsp/shared/header.jsp" %>
<h1>ERROR, PLEASE CONTACT SECOND LINE SUPPORT</h1>
<%
  MVCModel data = (MVCModel)request.getAttribute("model");
  if (data != null) {
    ErrorResponse error = (ErrorResponse)data.getError();
%>
<h4 style="color:red"><%=error.getMessage()%></h4>
<%
  }
%>
<%@ include file="../jsp/shared/footer.jsp" %>
</body>
</html>
