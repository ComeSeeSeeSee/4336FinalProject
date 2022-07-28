<%--
  Created by IntelliJ IDEA.
  User: leozh
  Date: 2022/7/19
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>


<body>

<form action="/MovieProject/paymentServlet" method="post" >
    Please type your credit card number:
    <div id="errorMsg" style="color: red">${error_msg1}</div>
    <input type="text" name="keyword" id="keyword">
    <input type="submit" value="click to Pay">
</form>




</body>


</html>
