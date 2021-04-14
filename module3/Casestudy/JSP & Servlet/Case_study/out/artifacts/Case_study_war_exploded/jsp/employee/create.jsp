<%--
  Created by IntelliJ IDEA.
  User: DUY
  Date: 29/01/21
  Time: 7:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee</title>
</head>
<body>
<form action="createEmployee" method="post">
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
            <td>Salary</td>
            <td><input type="text" name="salary"></td>
        </tr>
        <tr>
            <td>Education Degree</td>
            <td><input type="text" name="education_degree_id"></td>
        </tr>
        <tr>
            <td>Position</td>
            <td><input type="text" name="position"></td>
        </tr>
        <tr>
            <td>Division</td>
            <td><input type="text" name="division"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Create"></td>
            <td><input type="reset" value="Reset"></td>
        </tr>
    </table>
    <a href="listEmployee">Back to list</a>
</form>
</body>
</html>
