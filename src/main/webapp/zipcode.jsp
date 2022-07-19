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

<%--    <%--%>
<%--        List<Zipcode> zipcodeList = (List<Zipcode>)request.getAttribute("zipcodeList");--%>

<%--        for (int i = 0; i < zipcodeList.size(); i++) {--%>
<%--            Zipcode zipcode = zipcodeList.get(i);--%>
<%--    %>--%>

<%--    <tr align="center">--%>
<%--        <td><%=zipcode.getId()%></td>--%>
<%--        <td><%=zipcode.getZipcode()%></td>--%>
<%--        <td><a href="/MovieProject/selectZipcodeByIdServlet?id=${zipcode.id}">select</a></td>--%>
<%--    </tr>--%>

<%--    <%--%>
<%--        }--%>
<%--    %>--%>



</table>

<script>
    // document.getElementById("add").onclick = function (){
    //     location.href = "jsp";
    // }

</script>










</body>


</html>
