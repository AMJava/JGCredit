<%@ page import="lv.javaguru.java2.domain.MVCModel" %>
<%@ page import="lv.javaguru.java2.businesslogic.exceptions.ErrorResponse" %>
<%@ page import="lv.javaguru.java2.domain.Loan" %>
<%@ page import="java.util.List" %>
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
  MVCModel data = (MVCModel)request.getAttribute("model");
  List<Loan> loans = null;
  if (data != null) {
    loans = (List<Loan>) data.getData();
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
            <th class="text-center">Duration</th>
            <th class="text-center">Amount Sum</th>
            <th class="text-center">Term Unit</th>
            <th class="text-center">Term Payments</th>
            <th class="text-center">Start Date</th>
            <th class="text-center">End Date</th>
            <th class="text-center">IBAN</th>
            <th class="text-center">Status</th>
            <th class="text-center">Extended</th>
            <th class="text-center">Extended Date</th>
            <th class="text-center">Extend?</th>
            </thead>
            <tbody>
            <tr class="text-center">
              <%
                if (loans.size() > 0) {
                  int i =0;
                  for(Loan loan : loans){
              %>
                <td><%=i++ %></td>
                <td><%=loan.getLoan() %></td>
                <td><%=loan.getDuration() %></td>
                <td><%=loan.getLoanSum() %></td>
                <td><%=loan.getTerm() %></td>
                <td><%=loan.getTermPayment() %></td>
                <td><%=loan.getStartDate() %></td>
                <td><%=loan.getEndDate() %></td>
                <td><%=loan.getBankAccountNumb() %></td>
                <td><%=loan.getLoanStatus() %></td>
                <td><input type="checkbox" class="checkthis" unchecked/></td>
                <td><%=loan.getExtendedDate() %></td>
                <td>
                  <p data-placement="top" data-toggle="tooltip" title="Extend for 1 month"><button class="btn btn-primary btn-xs" data-title="Extend" data-toggle="modal" data-target="#extend" ><span class="glyphicon glyphicon-plus"></span></button></p>
                </td>
              <%
                }}
              %>
            </tr>
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
