<%--
  Created by IntelliJ IDEA.
  User: Arturs
  Date: 16.08.2016
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="lv.javaguru.java2.servlet.mvc.MVCModel" %>
<%@ page import="lv.javaguru.java2.dto.UserDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="lv.javaguru.java2.businesslogic.exceptions.ErrorResponse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="images/icon.png" rel="icon" type="image/png" />
  <link rel="stylesheet" href="styles/style.css">
    <title>Register</title>
</head>
<body>
<%@ include file="../shared/header.jsp" %>
<%
  UserDTO errorUser = (UserDTO) session.getAttribute("userErrorDTO");
%>
<div class="container">
  <form class="form-horizontal" role="form" method="post">
    <h2>Registration Form</h2>
    <div class="form-group required">
      <label for="login" class="col-sm-3 control-label">Login</label>
      <div class="col-sm-9">
        <%
          if (errorUser != null) {
        %>
        <input type="text" name="login" id="login" placeholder="Login" required="required" class="form-control" autofocus value='<%=errorUser.getLogin() %>'>
        <%
          }
          else{
        %>
        <input type="text" name="login" id="login" placeholder="Login" required="required" class="form-control" autofocus>
        <%
          }
        %>
      </div>
    </div>
    <div class="form-group required">
      <label for="firstName" class="col-sm-3 control-label">First Name</label>
      <div class="col-sm-9">
        <%
          if (errorUser != null) {
        %>
        <input type="text" name="fName" id="firstName" placeholder="First Name" required="required" class="form-control" autofocus value='<%=errorUser.getFName() %>'>
        <%
        }
        else{
        %>
        <input type="text" name="fName" id="firstName" placeholder="First Name" required="required" class="form-control">
        <%
          }
        %>
      </div>
    </div>
    <div class="form-group required">
      <label for="lastName" class="col-sm-3 control-label">Last Name</label>
      <div class="col-sm-9">
        <%
          if (errorUser != null) {
        %>
        <input type="text" name="lName" id="lastName" placeholder="Last Name" required="required" class="form-control" autofocus value='<%=errorUser.getLName() %>'>
        <%
        }
        else{
        %>
        <input type="text" name="lName" id="lastName" placeholder="Last Name" required="required" class="form-control">
        <%
          }
        %>
      </div>
    </div>
    <div class="form-group required">
      <label for="personalNumber" class="col-sm-3 control-label">Personal Number</label>
      <div class="col-sm-9">
        <%
          if (errorUser != null) {
        %>
        <input type="text" name="personalNumber" id="personalNumber" placeholder="personalNumber" required="required" class="form-control" autofocus value='<%=errorUser.getPersonalCode() %>'>
        <%
        }
        else{
        %>
        <input type="text" name="personalNumber" id="personalNumber" required="required" placeholder="Personal Number" class="form-control">
        <%
          }
        %>
      </div>
    </div>
    <div class="form-group required">
      <label for="address" class="col-sm-3 control-label">Adress</label>
      <div class="col-sm-9">
        <%
          if (errorUser != null) {
        %>
        <input type="text" name="address" id="address" placeholder="Address" required="required" class="form-control" autofocus value='<%=errorUser.getAddress() %>'>
        <%
        }
        else{
        %>
        <input type="text" name="address" id="address" placeholder="Address" required="required" class="form-control">
        <%
          }
        %>
        <span class="help-block">Street name,house-flat number</span>
      </div>
    </div>
    <div class="form-group required">
      <label for="email" class="col-sm-3 control-label">Email</label>
      <div class="col-sm-9">
        <%
          if (errorUser != null) {
        %>
        <input type="text" name="email" id="email" placeholder="Email" required="required" class="form-control" autofocus value='<%=errorUser.getEmail() %>'>
        <%
        }
        else{
        %>
        <input type="email" name="email" id="email" placeholder="Email" required="required" class="form-control">
        <%
          }
        %>
      </div>
    </div>
    <div class="form-group required">
      <label for="birthDate" class="col-sm-3 control-label">Date of Birth</label>
      <div class="col-sm-5">
        <input type="date" name="birthDate" id="birthDate" required="required" class="form-control">
        <span class="help-block">You must be at least 18 years old to be an JGCredit member. </span>
      </div>
    </div>
    <div class="form-group required">
      <label for="phoneNumber" class="col-sm-3 control-label">Phone Number</label>
      <div class="col-sm-9">
        <%
          if (errorUser != null) {
        %>
        <input type="text" name="phoneNumber" id="phoneNumber" placeholder="Phone Number" required="required" class="form-control" autofocus value='<%=errorUser.getPhoneNumber() %>'>
        <%
        }
        else{
        %>
        <input type="text" name="phoneNumber" id="phoneNumber" placeholder="Phone Number" required="required" class="form-control">
        <%
          }
        %>
      </div>
    </div>
    <div class="form-group">
      <label for="companyName" class="col-sm-3 control-label">Company Name</label>
      <div class="col-sm-9">
        <%
          if (errorUser != null) {
        %>
        <input type="text" name="companyName" id="companyName" placeholder="Company Name" class="form-control" autofocus value='<%=errorUser.getCompany() %>'>
        <%
        }
        else{
        %>
        <input type="text" name="companyName" id="companyName" placeholder="Company Name" class="form-control">
        <%
          }
        %>
      </div>
    </div>
    <div class="form-group">
      <label for="jobTitle" class="col-sm-3 control-label">Job Title</label>
      <div class="col-sm-9">
        <%
          if (errorUser != null) {
        %>
        <input type="text" name="jobTitle" id="jobTitle" placeholder="Job Title" class="form-control" autofocus value='<%=errorUser.getJobTitle() %>'>
        <%
        }
        else{
        %>
        <input type="text" name="jobTitle" id="jobTitle" placeholder="Job Title" class="form-control">
        <%
          }
        %>
      </div>
    </div>
    <div class="form-group">
      <label for="salary" class="col-sm-3 control-label">Salary</label>
      <div class="col-sm-4">
        <select id="salary" name="salary" class="form-control">
          <option><500 EURO</option>
          <option>500-1000 EURO</option>
          <option>1000-2000 EURO</option>
          <option>>2000 EURO</option>
        </select>
      </div>
    </div> <!-- /.form-group -->
    <div class="form-group required">
      <label class="control-label col-sm-3">Gender</label>
      <div class="col-sm-6">
        <div class="row">
          <div class="col-sm-4">
            <label class="radio-inline">
              <input type="radio" name="gender" id="femaleRadio" required="required" value="Female">Female
            </label>
          </div>
          <div class="col-sm-4">
            <label class="radio-inline">
              <input type="radio" name="gender" id="maleRadio" required="required" value="Male">Male
            </label>
          </div>
        </div>
      </div>
    </div> <!-- /.form-group -->
    <div class="form-group required">
      <label for="question" class="col-sm-3 control-label">Secret Qeastion</label>
      <div class="col-sm-6">
        <select id="question" name="question" required="required" class="form-control">
          <option>Best childhood friend</option>
          <option>Name of first pet</option>
          <option>Favorite teacher</option>
          <option>Favorite historical person</option>
        </select>
        <span class="help-block">Secret question when password is forgotten</span>
      </div>
    </div> <!-- /.form-group -->
    <div class="form-group required">
      <label for="answer" class="col-sm-3 control-label">Secret Answer</label>
      <div class="col-sm-9">
        <input type="text" name="answer" id="answer" placeholder="Secret Answer" required="required" class="form-control">
        <span class="help-block">Secret answer when password is forgotten</span>
      </div>
    </div>
    <div class="form-group required">
      <label for="password" class="col-sm-3 control-label">Password</label>
      <div class="col-sm-9">
        <input type="password" name="password" id="password" placeholder="Password" required="required" class="form-control">
        <span class="help-block">Use letters and numbers</span>
      </div>
    </div>
    <div class="form-group required">
      <label for="password2" class="col-sm-3 control-label">Confirm Password</label>
      <div class="col-sm-9">
        <input type="password" name="password2" id="password2" placeholder="Password" required="required" class="form-control">
        <span class="help-block">Use letters and numbers</span>
      </div>
    </div>
    <div class="form-group required">
      <div class="col-sm-9 col-sm-offset-3">
        <div class="checkbox">
          <label>
            <input type="checkbox" name="term" value = "Y" id="term">I accept <a href="https://termsfeed.com/blog/sample-terms-and-conditions-template/" target="_blank" >terms</a>
          </label>
        </div>
      </div>
    </div> <!-- /.form-group -->
    <%
      if (request.getAttribute("error") != null) {
      ErrorResponse error = (ErrorResponse) request.getAttribute("error");
    %>
    <h5 style="color:red"><%=error.getMessage()%>.</h5>
    <%
      }
    %>
    <div class="form-group">
      <div class="col-sm-6 col-sm-offset-3">
        <button type="submit" class="btn btn-primary btn-block">Register</button>
      </div>
    </div>
  </form> <!-- /form -->
</div> <!-- ./container -->
<%@ include file="../shared/footer.jsp" %>
</body>
</html>
