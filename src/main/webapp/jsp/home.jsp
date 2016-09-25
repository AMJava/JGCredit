<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <link href="images/icon.png" rel="icon" type="image/png" />
  <link rel="stylesheet" href="styles/style.css">
  <title>Home</title>
</head>
<body>
<%@ include file="../jsp/shared/header.jsp" %>

<div class="content-section">
  <div class="container">
    <div class="price-box">
      <div class="row">
        <div class="col-sm-6">
          <form class="form-horizontal form-pricing" role="form">

            <div class="price-slider">
              <h4 clasl="great">Amount</h4>
              <span>Minimum $100K is required</span>
              <div class="col-sm-12">
                <div id="slider_amirol"></div>
              </div>
            </div>
            <div class="price-slider">
              <h4 class="great">Duration</h4>
              <span>Please choose one</span>
              <div class="btn-group btn-group-justified">
                <div class="btn-group btn-group-lg">
                  <button type="button" class="btn btn-primary btn-lg btn-block month active-month selected-month" id='24month'>24 Months</button>
                </div>
                <div class="btn-group btn-group-lg">
                  <button type="button" class="btn btn-primary btn-lg btn-block month" id='18month'>18 Months</button>
                </div>
                <div class="btn-group btn-group-lg">
                  <button type="button" class="btn btn-primary btn-lg btn-block month" id='12month'>12 Months</button>
                </div>
              </div>
            </div>
            <div class="price-slider">
              <h4 class="great">Term</h4>
              <span>Please choose one</span>
              <input name="sliderVal" type="hidden" id="sliderVal" value='0' readonly="readonly" />
              <input name="month" type="hidden" id="month" value='24month' readonly="readonly" />
              <input name="term" type="hidden" id="term" value='quarterly' readonly="readonly" />
              <div class="btn-group btn-group-justified">
                <div class="btn-group btn-group-lg">
                  <button type="button" class="btn btn-primary btn-lg btn-block term active-term selected-term" id='quarterly'>Quarterly</button>
                </div>
                <div class="btn-group btn-group-lg">
                  <button type="button" class="btn btn-primary btn-lg btn-block term" id='monthly'>Monthly</button>
                </div>
                <div class="btn-group btn-group-lg">
                  <button type="button" class="btn btn-primary btn-lg btn-block term" id='weekly'>Weekly</button>
                </div>
              </div>
            </div>
        </div>

        <div class="col-sm-6">
          <div class="price-form">

            <div class="form-group">
              <div class="row">
                <div class="col-sm-6">
                  <label for="amount_amirol" class="control-label">Annually ($): </label>
                  <span class="help-text">Amount that you need to pay</span>
                </div>
                <div class="col-sm-6">
                  <input type="hidden" id="amount_amirol" class="form-control">
                  <!-- <p class="price lead" id="total"></p> -->
                  <input class="price lead" name="totalprice" type="text" id="total" disabled="disabled" style="" />
                </div>
              </div>
            </div>
            <div class="form-group">
              <div class="row">
                <div class="col-sm-6">
                  <label for="amount_amirol" class="control-label">Monthly ($): </label>
                  <span class="help-text">Amount that you need to pay</span>
                </div>
                <div class="col-sm-6">
                  <input type="hidden" id="amount_amirol1" class="form-control">
                  <!-- <p class="price lead" id="total12"></p> -->
                  <input class="price lead" name="totalprice12" type="text" id="total12" disabled="disabled" style="" />
                </div>
              </div>
            </div>
            <div class="form-group">
              <div class="row">
                <div class="col-sm-6">
                  <label for="amount_amirol" class="control-label">Weekly ($): </label>
                  <span class="help-text">Amount that you need to pay</span>
                </div>
                <div class="col-sm-6">
                  <input type="hidden" id="amount_amirol2" class="form-control">
                  <!-- <p class="price lead" id="total52"></p> -->
                  <input class="price lead" name="totalprice52" type="text" id="total52" disabled="disabled" style="" />
                </div>
              </div>
            </div>
            <div style="margin-top:30px"></div>
            <hr class="style">

            <div class="form-group">
              <div class="col-sm-12">
                <button type="submit" class="btn btn-primary btn-lg btn-block">Proceed <span class="glyphicon glyphicon-chevron-right"></span></button>
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-12">
                <img src="images/payment.png" class="img-responsive payment" />
              </div>
            </div>

          </div>

          </form>
        </div>
      </div>

    </div>
    <script src="js/script.js"></script>
  </div>
</div> <!-- /.content-section -->

<!--<script src="js/jquery.min.js"></script>-->
<script src="js/jquery-ui.min.js"></script>
<script src="js/script.js"></script>
<%@ include file="../jsp/shared/footer.jsp" %>
</body>
</html>
