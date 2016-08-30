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
  <form class="form-horizontal" role="form">
    <h2>Registration Form</h2>
    <div class="form-group">
      <label for="login" class="col-sm-3 control-label">Login</label>
      <div class="col-sm-9">
        <input type="text" id="login" placeholder="Login" class="form-control" autofocus>
      </div>
    </div>
    <div class="form-group">
      <label for="firstName" class="col-sm-3 control-label">First Name</label>
      <div class="col-sm-9">
        <input type="firstName" id="firstName" placeholder="First Name" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label for="lastName" class="col-sm-3 control-label">Last Name</label>
      <div class="col-sm-9">
        <input type="firstName" id="lastName" placeholder="Last Name" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label for="email" class="col-sm-3 control-label">Email</label>
      <div class="col-sm-9">
        <input type="email" id="email" placeholder="Email" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label for="password" class="col-sm-3 control-label">Password</label>
      <div class="col-sm-9">
        <input type="password" id="password" placeholder="Password" class="form-control">
        <span class="help-block">Last Name, First Name, eg.: Smith, Harry</span>
      </div>
    </div>
    <div class="form-group">
      <label for="birthDate" class="col-sm-3 control-label">Date of Birth</label>
      <div class="col-sm-9">
        <input type="date" id="birthDate" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label for="country" class="col-sm-3 control-label">Country</label>
      <div class="col-sm-9">
        <select id="country" class="form-control">
          <option>Afghanistan</option>
          <option>Bahamas</option>
          <option>Cambodia</option>
          <option>Denmark</option>
          <option>Ecuador</option>
          <option>Fiji</option>
          <option>Gabon</option>
          <option>Haiti</option>
        </select>
      </div>
    </div> <!-- /.form-group -->
    <div class="form-group">
      <label class="control-label col-sm-3">Gender</label>
      <div class="col-sm-6">
        <div class="row">
          <div class="col-sm-4">
            <label class="radio-inline">
              <input type="radio" id="femaleRadio" value="Female">Female
            </label>
          </div>
          <div class="col-sm-4">
            <label class="radio-inline">
              <input type="radio" id="maleRadio" value="Male">Male
            </label>
          </div>
          <div class="col-sm-4">
            <label class="radio-inline">
              <input type="radio" id="uncknownRadio" value="Unknown">Unknown
            </label>
          </div>
        </div>
      </div>
    </div> <!-- /.form-group -->
    <div class="form-group">
      <label class="control-label col-sm-3">Meal Preference</label>
      <div class="col-sm-9">
        <div class="checkbox">
          <label>
            <input type="checkbox" id="calorieCheckbox" value="Low calorie">Low calorie
          </label>
        </div>
        <div class="checkbox">
          <label>
            <input type="checkbox" id="saltCheckbox" value="Low salt">Low salt
          </label>
        </div>
      </div>
    </div> <!-- /.form-group -->
    <div class="form-group">
      <div class="col-sm-9 col-sm-offset-3">
        <div class="checkbox">
          <label>
            <input type="checkbox">I accept <a href="#">terms</a>
          </label>
        </div>
      </div>
    </div> <!-- /.form-group -->
    <div class="form-group">
      <div class="col-sm-9 col-sm-offset-3">
        <button type="submit" class="btn btn-primary btn-block">Register</button>
      </div>
    </div>
  </form> <!-- /form -->
</div> <!-- ./container -->
<%@ include file="../shared/footer.jsp" %>
</body>
</html>
