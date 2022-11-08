<%--
  Created by IntelliJ IDEA.
  User: xumin
  Date: 2022/11/8
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="login" method="post" name="reg-form">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="登录">
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
    <%--added by org.springframework.ui.Model.addAttribute--%>
    <%--this is expression language (EL)--%>
    ${error_message}
</form>
</body>
</html>
