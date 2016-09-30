<%@ page import="lv.javaguru.java2.domain.MVCModel" %>
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
        <h1>Change Password</h1><br>
        <form method="post">
          <input type="password" name="password" placeholder="Password">
          <input type="password" name="newPassword" placeholder="New Password">
          <input type="password" name="newPassword2" placeholder="Repeat New Password">
          <input type="submit" name="change" class="login loginmodal-submit" value="Change Password">
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
      </div>
  </div>
</div> <!-- /.content-section -->

<!--<script src="js/jquery.min.js"></script>-->
<script src="js/jquery-ui.min.js"></script>
<script src="js/script.js"></script>
<%@ include file="../jsp/shared/footer.jsp" %>
</body>
</html>
