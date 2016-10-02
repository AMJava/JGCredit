<%--
  Created by IntelliJ IDEA.
  User: Arturs
  Date: 16.08.2016
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="lv.javaguru.java2.domain.MVCModel" %>
<%@ page import="lv.javaguru.java2.dto.LoanDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="lv.javaguru.java2.businesslogic.exceptions.ErrorResponse" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="images/icon.png" rel="icon" type="image/png" />
  <link rel="stylesheet" href="styles/style.css">
  <title>Register</title>
</head>
<body>
<%@ include file="../jsp/shared/header.jsp" %>
<%
  MVCModel data = (MVCModel)request.getAttribute("model");
  LoanDTO loanDTO = null;
  NumberFormat formatter = new DecimalFormat("#0.00");
  if (data != null) {
    loanDTO = (LoanDTO) data.getData();
  }
%>
<div class="container">
  <form class="form-horizontal" role="form" method="post">
    <h2>Take Loan</h2>
    <div class="form-group required">
      <label for="amount" class="col-sm-3 control-label">Amount</label>
      <div class="col-sm-9">
        <%
          if (loanDTO != null) {
        %>
        <input type="text" name="amount" id="amount" readonly="readonly" placeholder="Amount" required="required" class="form-control" autofocus value='<%=formatter.format(loanDTO.getLoan()) %>€'>
        <%
        }
        else{
        %>
        <input type="text" name="amount" id="amount" readonly="readonly" placeholder="Amount" required="required" class="form-control" autofocus>
        <%
          }
        %>
      </div>
    </div>
    <div class="form-group required">
      <label for="duration" class="col-sm-3 control-label">Duration(months)</label>
      <div class="col-sm-9">
        <%
          if (loanDTO != null) {
        %>
        <input type="text" name="duration" id="duration" readonly="readonly" placeholder="Duration" required="required" class="form-control" autofocus value='<%=loanDTO.getDuration() %>'>
        <%
        }
        else{
        %>
        <input type="text" name="duration" id="duration" readonly="readonly" placeholder="Duration" required="required" class="form-control">
        <%
          }
        %>
      </div>
    </div>
    <div class="form-group required">
      <label for="finalAmount" class="col-sm-3 control-label">Final Amount</label>
      <div class="col-sm-9">
        <%
          if (loanDTO != null) {
        %>
        <input type="text" name="finalAmount" id="finalAmount" readonly="readonly" placeholder="Final Amount" required="required" class="form-control" autofocus value='<%=formatter.format(loanDTO.getLoanSum()) %>€'>
        <%
        }
        else{
        %>
        <input type="text" name="finalAmount" id="finalAmount" readonly="readonly" required="required" placeholder="Final Amount" class="form-control">
        <%
          }
        %>
      </div>
    </div>
    <div class="form-group required">
      <label for="term" class="col-sm-3 control-label">Term Unit</label>
      <div class="col-sm-9">
        <%
          if (loanDTO != null) {
        %>
        <input type="text" name="termUnit" id="termUnit" readonly="readonly" placeholder="Term Unit" required="required" class="form-control" autofocus value='<%=loanDTO.getTerm().substring(0, 1).toUpperCase() + loanDTO.getTerm().substring(1) %>'>
        <%
        }
        else{
        %>
        <input type="text" name="termUnit" id="termUnit" readonly="readonly" placeholder="Term Unit" required="required" class="form-control">
        <%
          }
        %>
      </div>
    </div>
    <div class="form-group required">
      <label for="termPayment" class="col-sm-3 control-label">Term Payment</label>
      <div class="col-sm-9">
        <%
          if (loanDTO != null) {
        %>
        <input type="text" name="termPayment" id="termPayment" readonly="readonly" placeholder="Term Payment" required="required" class="form-control" autofocus value='<%=formatter.format(loanDTO.getTermPayment()) %>€'>
        <%
        }
        else{
        %>
        <input type="text" name="termPayment" id="termPayment" readonly="readonly" placeholder="Term Payment" required="required" class="form-control">
        <%
          }
        %>
      </div>
    </div>
    <div class="form-group required">
      <label for="bankAccount" class="col-sm-3 control-label">Bank Account</label>
      <div class="col-sm-9">
        <input type="text" name="bankAccount" id="bankAccount" placeholder="Bank Account" required="required" class="form-control">
        <span class="help-block">Your Bank Account Number</span>
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
      if (data != null) {
        ErrorResponse error = (ErrorResponse)data.getError();
        if (error != null) {
    %>
    <h4 style="color:red"><%=error.getMessage()%></h4>
    <%
      }}
    %>
    <div class="form-group">
      <div class="col-sm-6 col-sm-offset-3">
        <button type="submit" class="btn btn-primary btn-block">Take</button>
      </div>
    </div>
  </form> <!-- /form -->
</div> <!-- ./container -->
<%@ include file="../jsp/shared/footer.jsp" %>
</body>
</html>
