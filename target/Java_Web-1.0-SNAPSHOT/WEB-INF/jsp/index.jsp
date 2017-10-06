<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sulaymon
  Date: 03.10.2017
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link href="${pageContext.request.contextPath}css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}js/validatescript.js"></script>
</head>
<body>
   Basic Calculator
   <div class="container">
<form name="myForm"  onsubmit="return validateForm()" method="post" action="/calc">
    <input type="text" name="digit" >
    <input type="submit" name="mathaction" value="+">
    <input type="submit" name="mathaction" value="-">
    <input type="submit" name="mathaction" value="*">
    <input type="submit" name="mathaction" value="/">
    <input type="submit" formmethod="get" value="reset" >
</form>
 ${digits} =${result}
   </div>
</body>
</html>
