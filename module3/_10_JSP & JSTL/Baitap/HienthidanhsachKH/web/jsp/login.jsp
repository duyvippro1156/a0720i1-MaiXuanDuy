<%--
  Created by IntelliJ IDEA.
  User: DUY
  Date: 12/01/21
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="login" method="post">
        <table>
            <tr>
                <td>Username: </td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><input type="text" name="password"></td>
            </tr>
        </table>
        <input type="submit" value="Login">
    </form>
</body>
</html>
