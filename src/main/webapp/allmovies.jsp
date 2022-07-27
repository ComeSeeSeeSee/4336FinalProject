<%--
  Created by IntelliJ IDEA.
  User: leozh
  Date: 2022/7/19
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
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
        <th>Name</th>
        <th>Description</th>
        <th>TimePeriod</th>
        <th>Price</th>
        <th>Confirm</th>
    </tr>

    <c:forEach items="${allMoviesByTheaterFk}" var="movie" varStatus="status">
        <tr align="center">
            <td>${status.count}</td>
            <td>${movie.name}</td>
            <td>${movie.description}</td>
            <td>${movie.timePeriod}</td>
            <td>$10</td>
            <td><a href="/MovieProject/paymentServlet">purchase</a></td>
        </tr>
    </c:forEach>



</table>


</body>



</html>
