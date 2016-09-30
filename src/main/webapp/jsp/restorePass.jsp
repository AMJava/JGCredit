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
        <h1>Restore Password</h1><br>
        <form method="post">
          <input type="text" name="user" placeholder="Username">
            <select id="question" name="question" class="form-control">
              <option>Select Question</option>
              <option>Best childhood friend</option>
              <option>Name of first pet</option>
              <option>Favorite teacher</option>
              <option>Favorite historical person</option>
            </select>
          <span class="help-block"></span>
          <input type="text" name="answer" placeholder="Secret Answer">
          <input type="submit" name="restore" class="login loginmodal-submit" value="Restore">
          <span class="help-block">Password will be changed and sent to user E-mail.</span>
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
