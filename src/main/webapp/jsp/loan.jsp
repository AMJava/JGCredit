<%@ page import="lv.javaguru.java2.domain.MVCModel" %>
<%@ page import="lv.javaguru.java2.businesslogic.exceptions.ErrorResponse" %>
<%@ page import="lv.javaguru.java2.domain.Loan" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="lv.javaguru.java2.dto.LoanDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <link href="images/icon.png" rel="icon" type="image/png" />
  <link rel="stylesheet" href="styles/style.css">
  <title>Login</title>
</head>
<body>
<%@ include file="../jsp/shared/header.jsp" %>
<%
  NumberFormat formatter = new DecimalFormat("#0.00");
  MVCModel data = (MVCModel)request.getAttribute("model");
  List<LoanDTO> loans = null;
  if (data != null) {
    loans = (List<LoanDTO>) data.getData();
  }
%>
<div class="content-section">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <h4>User Loans</h4>
        <div class="table-responsive">
          <table id="mytable" class="table table-bordred table-striped">
            <thead>
            <th class="text-center">Number</th>
            <th class="text-center">Amount</th>
            <th class="text-center">Duration(months)</th>
            <th class="text-center">Amount Sum</th>
            <th class="text-center">Term Unit</th>
            <th class="text-center">Term Payments</th>
            <th class="text-center">Start Date</th>
            <th class="text-center">End Date</th>
            <th class="text-center">IBAN</th>
            <th class="text-center">Status</th>
            <th class="text-center">Extended</th>
            <th class="text-center">Extended Date</th>
            <th class="text-center">Extend?(300€)</th>
            </thead>
            <tbody>
              <%
                if (loans != null && loans.size() > 0) {
                  int i =0;
                  for(LoanDTO loan : loans){
              %>
                <tr class="text-center">
                <td><%=++i %></td>
                <td><%=formatter.format(loan.getLoan())%>€</td>
                <td><%=loan.getDuration() %></td>
                <td><%=formatter.format(loan.getLoanSum()) %>€</td>
                <td><%=loan.getTerm().substring(0, 1).toUpperCase() + loan.getTerm().substring(1) %></td>
                <td><%=formatter.format(loan.getTermPayment()) %>€</td>
                <td><%=loan.getStartDate().toString().substring(0,10) %></td>
                <td><%=loan.getEndDate().toString().substring(0,10) %></td>
                <td><%=loan.getBankAccountNumb() %></td>
                  <%
                    if(loan.getLoanStatus().toString().equals("ACTIVE")){
                  %>
                    <td class="green"><%=loan.getLoanStatus() %></td>
                  <%
                    }else{
                  %>
                    <td class="orange"><%=loan.getLoanStatus() %></td>
                  <%
                    }
                    if(loan.getExtendedFlag() != null){
                  %>
                <td><input type="checkbox" disabled="disabled" class="checkthis" checked/></td>
                  <%
                    }else{
                  %>
                  <td><input type="checkbox" disabled="disabled" class="checkthis" unchecked/></td>
                  <%
                    }
                    if(loan.getExtendedDate() != null){
                  %>
                    <td><%=loan.getExtendedDate().toString().substring(0,10) %></td>
                  <%
                    }else{
                  %>
                    <td></td>
                  <%
                    }
                      if(loan.getLoanStatus().toString().equals("ACTIVE") && loan.getExtendedFlag() == null){
                  %>
                <td>
                  <p data-placement="top" data-toggle="tooltip" title="Extend for 3 month"><button class="btn btn-primary btn-xs" data-title="Extend" data-toggle="modal" data-target="#extend" ><span class="glyphicon glyphicon-plus"></span></button></p>
                </td>
                  <%
                    }
                  %>
                </tr>
              <%
                }}
              %>
            </tbody>
          </table>
          <%
              ErrorResponse error = (ErrorResponse)data.getError();
            if(error != null){
          %>
          <h4 style="color:red"><%=error.getMessage()%></h4>
          <%
            }
          %>
        </div>
      </div>
    </div>
  </div>
</div> <!-- /.content-section -->

<!--<script src="js/jquery.min.js"></script>-->
<script src="js/jquery-ui.min.js"></script>
<script src="js/script.js"></script>
<%@ include file="../jsp/shared/footer.jsp" %>
</body>
</html>
