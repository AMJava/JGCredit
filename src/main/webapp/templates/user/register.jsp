<%--
  Created by IntelliJ IDEA.
  User: Arturs
  Date: 16.08.2016
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="images/icon.png" rel="icon" type="image/png" />
  <link rel="stylesheet" href="styles/style.css">
    <title>Register</title>
</head>
<body>
<%@ include file="../shared/header.jsp" %>
<div class="container">
  <form class="form-horizontal" role="form" method="post">
    <h2>Registration Form</h2>
    <div class="form-group">
      <label for="login" class="col-sm-3 control-label">Login</label>
      <div class="col-sm-9">
        <input type="text" name="login" id="login" placeholder="Login" class="form-control" autofocus>
      </div>
    </div>
    <div class="form-group">
      <label for="firstName" class="col-sm-3 control-label">First Name</label>
      <div class="col-sm-9">
        <input type="text" name="fName" id="firstName" placeholder="First Name" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label for="lastName" class="col-sm-3 control-label">Last Name</label>
      <div class="col-sm-9">
        <input type="text" name="lName" id="lastName" placeholder="Last Name" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label for="personalNumber" class="col-sm-3 control-label">Personal Number</label>
      <div class="col-sm-9">
        <input type="text" name="personalNumber" id="personalNumber" placeholder="Personal Number" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label for="address" class="col-sm-3 control-label">Adress</label>
      <div class="col-sm-9">
        <input type="text" name="address" id="address" placeholder="Address" class="form-control">
        <span class="help-block">Street name,house-flat number</span>
      </div>
    </div>
    <div class="form-group">
      <label for="email" class="col-sm-3 control-label">Email</label>
      <div class="col-sm-9">
        <input type="email" name="email" id="email" placeholder="Email" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label for="password" class="col-sm-3 control-label">Password</label>
      <div class="col-sm-9">
        <input type="password" name="password" id="password" placeholder="Password" class="form-control">
        <span class="help-block">Use letters and numbers</span>
      </div>
    </div>
    <div class="form-group">
      <label for="birthDate" class="col-sm-3 control-label">Date of Birth</label>
      <div class="col-sm-5">
        <input type="date" name="birthDate" id="birthDate" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label for="phoneNumber" class="col-sm-3 control-label">Phone Number</label>
      <div class="col-sm-9">
        <input type="text" name="phoneNumber" id="phoneNumber" placeholder="Phone Number" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label for="companyName" class="col-sm-3 control-label">Company Name</label>
      <div class="col-sm-9">
        <input type="text" name="companyName" id="companyName" placeholder="Company Name" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label for="jobTitle" class="col-sm-3 control-label">Job Title</label>
      <div class="col-sm-9">
        <input type="text" name="jobTitle" id="jobTitle" placeholder="Job Title" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label for="salary" class="col-sm-3 control-label">Salary</label>
      <div class="col-sm-4">
        <select id="salary" name="salary" class="form-control">
          <option><500€</option>
          <option>500-1000€</option>
          <option>1000-2000€</option>
          <option>>2000€</option>
        </select>
      </div>
    </div> <!-- /.form-group -->
    <div class="form-group">
      <label class="control-label col-sm-3">Gender</label>
      <div class="col-sm-6">
        <div class="row">
          <div class="col-sm-4">
            <label class="radio-inline">
              <input type="radio" name="gender" id="femaleRadio" value="Female">Female
            </label>
          </div>
          <div class="col-sm-4">
            <label class="radio-inline">
              <input type="radio" name="gender" id="maleRadio" value="Male">Male
            </label>
          </div>
        </div>
      </div>
    </div> <!-- /.form-group -->
    <div class="form-group">
      <div class="col-sm-9 col-sm-offset-3">
        <div class="checkbox">
          <label>
            <input type="checkbox" name="accept">I accept <a href="http://examples.yourdictionary.com/payment-terms-examples.html" target="_blank">terms</a>
          </label>
        </div>
      </div>
    </div> <!-- /.form-group -->
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
