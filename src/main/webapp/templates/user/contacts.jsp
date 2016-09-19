<%--
  Created by IntelliJ IDEA.
  User: Arturs
  Date: 16.08.2016
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="lv.javaguru.java2.dto.UserDTO" %>
<html>
<head>
  <link href="images/icon.png" rel="icon" type="image/png" />
  <link rel="stylesheet" href="styles/style.css">
  <title>Contacts</title>
</head>
<body>
<%@ include file="../shared/header.jsp" %>
<div class="content-section">
  <div class="container">
    <div class="row">
      <div class="col-md-5 col-sm-6">
        <h3 class="widget-title">Contact Us</h3>
        <div class="contact-form">
          <form name="contactform" id="contactform" action="#" method="post">
            <%
              UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
              if (userDTO != null) {
            %>
              <p>
                <input name="login" type="text" id="login" value="<%=userDTO.getLogin()%>" readonly>
              </p>
              <p>
                <input name="name" type="text" id="name" value="<%=userDTO.getFName()%> <%=user.getLName()%>" readonly>
              </p>
            <p>
              <input name="email" type="text" id="email" value="<%=userDTO.getEmail()%>" readonly>
            </p>
            <%
              }
              else{
            %>
            <p>
              <input name="name" type="text" id="name" placeholder="Your Name">
            </p>
            <p>
              <input name="email" type="text" id="email" placeholder="Your Email">
            </p>
            <%
              }
            %>
            <p>
              <input name="subject" type="text" id="subject" placeholder="Subject">
            </p>
            <p>
              <textarea name="message" id="message" placeholder="Message"></textarea>
            </p>
            <input type="submit" class="mainBtn" id="submit" value="Send Message">
          </form>
        </div> <!-- /.contact-form -->
      </div>
      <div class="col-md-7 col-sm-6 map-wrapper">
        <h3 class="widget-title">Our Location</h3>
        <div class="map-holder" style="height: 360px"></div>
      </div>
    </div>
  </div>
</div> <!-- /.content-section -->
<%@ include file="../shared/footer.jsp" %>

<!-- Google Map -->
<script src="http://maps.google.com/maps/api/js?sensor=true&key=AIzaSyBsFoATu7RVPDssbj_U3fsB_qawnmJrbuM"></script>
<script src="js/vendor/jquery.gmap3.min.js"></script>

<!-- Google Map Init-->
<script>
  jQuery(function($){
    $('.first-map, .map-holder').gmap3({
      marker:{
        address: '56.943106, 24.097465'
      },
      map:{
        options:{
          zoom: 15,
          scrollwheel: false,
          streetViewControl : true
        }
      }
    });
  });
</script>
</body>
</html>
