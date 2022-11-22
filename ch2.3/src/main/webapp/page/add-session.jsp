<%--
  Created by IntelliJ IDEA.
  User: xumin
  Date: 2022/11/22
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加场次</title>
</head>
<body>
<form:form modelAttribute="film-session" method="post" action="session/add">
    <fieldset>
        <legend>添加场次</legend>
        <p><label>片名</label><form:input path="Title"/></p>
        <p><label>影厅</label><form:checkboxes path="Hall" items="${halls}"/></p>
        <p><label>级别</label><form:select path="Level" items="${levels}"/></p>
        <p><label>备注</label><form:textarea path="Note" rows="10"/></p>
        <p><input id="reset" type="reset"><input id="submit" type="submit"></p>
    </fieldset>
</form:form>
</body>
</html>
