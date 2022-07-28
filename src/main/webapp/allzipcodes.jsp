<%@ page import="com.example.entities.Zipcode" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>


<body>


<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>ID</th>
        <th>Zipcode</th>
        <th>Confirm</th>
    </tr>

    <c:forEach items="${zipcodeList}" var="zipcode" varStatus="status">
        <tr align="center">
            <td>${status.count}</td>
            <td>${zipcode.zipcode}</td>
            <td><a href="/MovieProject/selectZipcodeByIdServlet?id=${zipcode.id}">select</a></td>
        </tr>
    </c:forEach>

</table>





</body>


</html>
