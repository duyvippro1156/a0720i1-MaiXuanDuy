<%--
  Created by IntelliJ IDEA.
  User: linht
  Date: 1/6/2021
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Customer</title>
</head>
<body>
    <form action="createCustomer" method="post">
        <table>
            <tr>
                <td>ID</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Birthday</td>
                <td><input type="date" name="birthday"></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td><input type="text" name="gender"></td>
            </tr>
            <tr>
                <td>Id Card</td>
                <td><input type="text" name="id_card"></td>
            </tr>
            <tr>
                <td>Phone</td>
                <td><input type="text" name="phone"></td>
            </tr>
            <tr>
                <td>Mail</td>
                <td><input type="text" name="mail"></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address"></td>
            </tr>
            <tr>
                <td>Id Type Customer</td>
                <td><input type="text" name="id_type_customer"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Create"></td>
                <td><input type="reset" value="Reset"></td>
            </tr>
        </table>
        <a href="listCustomer">Back to list</a>
    </form>
</body>
</html>
