<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Take a loan</title>
  <link href="../../styles/style.css" rel="stylesheet" type="text/css" />
  <link href="../../libs/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="../shared/header.jsp" %>
<div id="agreement_wrapper">
        <div class="header_02"><%= request.getAttribute("model") %></div>
  <form method="POST" action="">
    <table>
      <tr>
        <td>Loan Sum:</td>
        <td><input type="text" name="loanSum"></td>
      </tr>
      <tr>
        <td>Interest Rate:</td>
        <td><input type="text" name="interestRate"></td>
      </tr>
      <tr>
        <td>Term:</td>
        <td><input type="text" name="term"></td>
      </tr>
      <tr>
        <td>Term Unit:</td>
        <td><input type="text" name="termUnit"></td>
      </tr>
      <tr>
        <td>Start Date:</td>
        <td><input type="text" name=startDate"></td>
      </tr>
      <tr>
        <td>End Date:</td>
        <td><input type="text" name="endDate"></td>
      </tr>
      <tr>
        <td>Comments:</td>
        <td><input type="password" name="comments"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="SUBMIT" value="Finish" name="submit"></td>
      </tr>
      <% String error = (String) request.getAttribute("model");
        if (error != null) {%>
      <tr>
        <td></td>
        <td><font color="red"><%="Error: " + error%>
        </font></td>

      </tr>
      <% } %>
    </table>
  </form>
  </div>
<script type=”text/javascript” src="../../libs/bootstrap.min.js"></script>
<%@ include file="../shared/footer.jsp" %>
</body>
</html>
