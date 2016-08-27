<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <link href="images/icon.png" rel="icon" type="image/png" />
  <link rel="stylesheet" href="styles/style.css">
</head>
<body>
<%@ include file="../shared/header.jsp" %>

<div class="content-section">
  <div class="modal-dialog">
      <div class="loginmodal-container">
        <h1>Login</h1><br>
        <form>
          <input type="text" name="user" placeholder="Username">
          <input type="password" name="pass" placeholder="Password">
          <input type="submit" name="login" class="login loginmodal-submit" value="Login">
        </form>

        <div class="login-help">
          <a href="#">Register</a> - <a href="#">Forgot Password</a>
        </div>
      </div>
  </div>
</div> <!-- /.content-section -->

<!--<script src="js/jquery.min.js"></script>-->
<script src="js/jquery-ui.min.js"></script>
<script src="js/script.js"></script>
<%@ include file="../shared/footer.jsp" %>
</body>
</html>
