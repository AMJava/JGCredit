<%@ page import="lv.javaguru.java2.domain.MVCModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <link href="../images/icon.png" rel="icon" type="image/png" />
  <link rel="stylesheet" href="../styles/style.css">
  <title>Login</title>
</head>
<body>
<%@ include file="../jsp/shared/header.jsp" %>
  <%
    MVCModel data = (MVCModel)request.getAttribute("model");
    if (data != null) {
      String path = (String)data.getData();
      response.sendRedirect(path);
    }
    else{
      response.sendRedirect("/java2");
    }
  %>
<!--<script src="js/jquery.min.js"></script>-->
<script src="../js/jquery-ui.min.js"></script>
<script src="../js/script.js"></script>
<%@ include file="../jsp/shared/footer.jsp" %>
</body>
</html>
