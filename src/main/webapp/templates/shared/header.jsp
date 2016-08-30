<%@ page import="lv.javaguru.java2.servlet.mvc.MVCModel" %>
<%@ page import="lv.javaguru.java2.dto.UserDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>JGCredit</title>
  <link href="styles/bootstrap.css" rel="stylesheet" type="text/css" />
  <link href="styles/normalize.min.css" rel="stylesheet" type="text/css" />
  <link href="styles/font-awesome.min.css" rel="stylesheet" type="text/css" />
  <link href="styles/animate.css" rel="stylesheet" type="text/css" />
  <link href="styles/templatemo-misc.css" rel="stylesheet" type="text/css" />
  <link href="styles/templatemo-style.css" rel="stylesheet" type="text/css" />
  <script src="js/vendor/modernizr-2.6.2.min.js"></script>
</head>
<body>
<header class="site-header">
  <div class="top-header">
    <div class="container">
      <div class="row">
        <div class="col-md-6 col-sm-6">
          <div class="top-header-left">
            <%
              UserDTO user = (UserDTO) session.getAttribute("userDTO");
              if (user != null) {
            %>

            <a href="<%=request.getContextPath()%>/profile">
              <img class="img-cicle" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=30" />
              Hello <%=user.getFName()%> <%=user.getLName()%>!!!   </a>
            <a href="<%=request.getContextPath()%>/logout">Sign Out</a>
            <%
              }
              else
              {
            %>
            <a href="<%=request.getContextPath()%>/register">Sign Up</a>
            <a href="<%=request.getContextPath()%>/login">Log In</a>
            <%
              }
            %>
          </div> <!-- /.top-header-left -->
        </div> <!-- /.col-md-6 -->
      </div> <!-- /.row -->
    </div> <!-- /.container -->
  </div> <!-- /.top-header -->
  <div class="main-header">
    <div class="container">
      <div class="row">
        <div class="col-md-4 col-sm-6 col-xs-8">
          <div class="logo">
            <h1><a href="#">JGCREDIT.LV</a></h1>
          </div> <!-- /.logo -->
        </div> <!-- /.col-md-4 -->
        <div class="col-md-8 col-sm-6 col-xs-4">
          <div class="main-menu">
            <a href="#" class="toggle-menu">
              <i class="fa fa-bars"></i>
            </a>
            <ul class="menu">
              <%
                if (user != null) {
              %>
              <li><a href="<%=request.getContextPath()%>/profile">My Account</a></li>
              <li><a href="<%=request.getContextPath()%>/loans">My Loans</a></li>
              <%
                }
                else
                {
              %>
              <li><a href="<%=request.getContextPath()%>/register">Sign Up</a></li>
              <li><a href="<%=request.getContextPath()%>/login">Log In</a></li>
              <%
                }
              %>
            </ul>
          </div> <!-- /.main-menu -->
        </div> <!-- /.col-md-8 -->
      </div> <!-- /.row -->
    </div> <!-- /.container -->
  </div> <!-- /.main-header -->
  <div class="main-nav">
    <div class="container">
      <div class="row">
        <div class="col-md-6 col-sm-7">
          <div class="list-menu">
            <ul>
              <li><a href="<%=request.getContextPath()%>/home">Home</a></li>
              <li><a href="<%=request.getContextPath()%>/operations">Operations</a></li>
              <li><a href="<%=request.getContextPath()%>/about">About</a></li>
              <li><a href="<%=request.getContextPath()%>/contacts">Contact</a></li>
            </ul>
          </div> <!-- /.list-menu -->
        </div> <!-- /.col-md-6 -->
        <div class="col-md-6 col-sm-5">
          <div class="notification">
            <span>Register and take your first loan with 0% interest!</span>
          </div>
        </div> <!-- /.col-md-6 -->
      </div> <!-- /.row -->
    </div> <!-- /.container -->
  </div> <!-- /.main-nav -->
</header> <!-- /.site-header -->
<script src="js/vendor/jquery-1.10.1.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.10.1.min.js"><\/script>')</script>
<script src="js/jquery.easing-1.3.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/plugins.js"></script>
<script src="js/main.js"></script>
</body>
</html>
