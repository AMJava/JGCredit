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
  <title>Profile</title>
</head>
<body>
<%@ include file="../shared/header.jsp" %>
<%
  UserDTO editUser = (UserDTO) session.getAttribute("userDTO");
%>
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
      <div class="panel panel-info">
        <div class="panel-heading">
          <h3 class="panel-title"><%=editUser.getFName()%> <%=editUser.getLName()%></h3>
        </div>
        <div class="panel-body">
          <div class="row">
            <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="images/profile.jpg" class="img-circle img-responsive"> </div>
            <div class=" col-md-9 col-lg-9 ">
              <table class="table table-user-information">
                <tbody>
                <tr>
                  <td>First Name:</td>
                  <td ><%=editUser.getFName()%></td>
                </tr>
                <tr>
                  <td>Last Name:</td>
                  <td><%=editUser.getLName()%></td>
                </tr>
                <tr>
                  <td>Personal Code:</td>
                  <td><input type="text" name="personalNumber" value='<%=editUser.getPersonalCode() %>'></td>
                </tr>
                <tr>
                  <td>Birth date:</td>
                  <td><%=editUser.getBirthDate().toString().substring(0,10)%></td>
                </tr>
                <tr>
                  <td>Address</td>
                  <td><input type="text" name="personalNumber" value='<%=editUser.getAddress() %>'></td>
                </tr>

                <tr>
                <tr>
                  <td>Phone Number</td>
                  <td><input type="text" name="personalNumber" value='<%=editUser.getPhoneNumber() %>'></td>
                </tr>
                <tr>
                  <td>Company Name</td>
                  <td><input type="text" name="personalNumber" value='<%=editUser.getCompany() %>'></td>
                </tr>
                <tr>
                  <td>Job Title</td>
                  <td><input type="text" name="personalNumber" value='<%=editUser.getJobTitle() %>'></td>
                </tr>
                <tr>
                  <td>Email</td>
                  <td><a href="mailto:info@support.com"><%=editUser.getEmail()%></a></td>
                </tr>
                <td>Salary</td>
                <td><%=editUser.getSalary()%></td>
                </tr>
                </tbody>
              </table>
              <button type="submit" class="btn btn-primary">Save Changes</button>
              <a href="<%=request.getContextPath()%>/profile" class="btn btn-primary">Cancel</a>
            </div>
          </div>
        </div>

      </div>
    </div>
  </div>
</div>
<%@ include file="../shared/footer.jsp" %>
</body>
</html>
