<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 21/07/16
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="jagCredit">
<head>
    <title>JagCredit Group Services</title>
    <script type="application/javascript" src="./public/js/libs.js"></script>
    <script type="application/javascript" src="./public/js/application.js"></script>
    <style type="text/css" href="./public/css/style.css"></style>
    <%--<style type="text/css" href="public/css/bootstrap/.css"></style>--%>
</head>
<body>
<div ui-view="header"></div>
<div ui-view="content"></div>
<div ui-view="footer"></div>
</body>
</html>
