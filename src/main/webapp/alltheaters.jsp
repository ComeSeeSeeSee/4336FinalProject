<%--
  Created by IntelliJ IDEA.
  User: leozh
  Date: 2022/7/19
  Time: 11:43
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
        <th>Theater</th>
        <th>Confirm</th>
    </tr>

    <c:forEach items="${allTheatersByZipcodeFk}" var="theater" varStatus="status">
        <tr align="center">
            <td>${status.count}</td>
            <td>${theater.theaterName}</td>
            <td><a href="/MovieProject/selectMovieByIdServlet?id=${theater.id}">select</a></td>
        </tr>
    </c:forEach>






</table>


</body>






</html>
