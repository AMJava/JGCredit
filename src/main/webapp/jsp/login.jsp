<%@ page import="lv.javaguru.java2.dto.MVCModel" %>
<%@ page import="lv.javaguru.java2.businesslogic.exceptions.ErrorResponse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <link href="images/icon.png" rel="icon" type="image/png" />
  <link rel="stylesheet" href="styles/style.css">
  <title>Login</title>
</head>
<body>
<%@ include file="../jsp/shared/header.jsp" %>

<div class="content-section">
  <div class="modal-dialog">
      <div class="loginmodal-container">
        <h1>Login</h1><br>
        <form method="post">
          <input type="text" name="user" placeholder="Username">
          <input type="password" name="pass" placeholder="Password">
          <input type="submit" name="login" class="login loginmodal-submit" value="Login">
          <%
            MVCModel data = (MVCModel)request.getAttribute("model");
            if (data != null) {
              ErrorResponse error = (ErrorResponse)data.getError();
          %>
            <h4 style="color:red"><%=error.getMessage()%></h4>
          <%
            }
          %>
        </form>

        <div class="login-help">
          <a href="<%=request.getContextPath()%>/register">Register</a> - <a href="<%=request.getContextPath()%>/restorePassword">Forgot Password</a>
        </div>
      </div>
  </div>
</div> <!-- /.content-section -->

<!--<script src="js/jquery.min.js"></script>-->
<script src="js/jquery-ui.min.js"></script>
<script src="js/script.js"></script>
<%@ include file="../jsp/shared/footer.jsp" %>
</body>
</html>
