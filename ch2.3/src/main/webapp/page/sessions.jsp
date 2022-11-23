<%--
  Created by IntelliJ IDEA.
  User: xumin
  Date: 2022/11/22
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>场次</title>
</head>
<body>
<a href="<c:url value="/session/add"/>">继续添加</a>
<table border="1px solid" cellpadding="4">
    <tr>
        <th>片名</th>
        <th>时间</th>
        <th>影厅</th>
        <th>级别</th>
        <th>备注</th>
    </tr>
    <%--    JSTL tags--%>
    <c:forEach items="${film_sessions}" var="film_session">
        <tr>
            <td>${film_session.getTitle()}</td>
            <td>${film_session.getHour()} 时 ${film_session.getMinute()} 分</td>
            <td>
                &emsp;
                <c:forEach items="${film_session.getHall()}" var="hall">
                    ${hall}&emsp;
                </c:forEach>
            </td>
            <td>${film_session.getLevel()}</td>
            <td>${film_session.getNote()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
