<%@ page import="com.example.entities.Zipcode" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: leozh
  Date: 2022/7/19
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>


<body>
<h2>Find theater by zipcode</h2>
<form action="/MovieProject/zipcodeServlet" method="post" >

    <div id="errorMsg" style="color: red">${error_msg1} ${error_msg2}</div>
    Please type zipcode:<input type="text" name="keyword" id="keyword">
    <input type="submit" value="click to search">

</form>

<a href="/MovieProject/zipcodeServlet"> <input type="submit" value="Show all zipcodes"> </a>












</body>


</html>
