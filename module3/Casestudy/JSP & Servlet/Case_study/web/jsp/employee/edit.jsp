<%--
  Created by IntelliJ IDEA.
  User: DUY
  Date: 29/01/21
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
<form action="editEmployee" method="post">
    <table>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id" value="${employee.employee_id}" readonly></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${employee.employee_name}"></td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><input type="date" name="birthday" value="${employee.employee_birthday}"></td>
        </tr>
        <tr>
            <td>Id Card</td>
            <td><input type="text" name="id_card" value="${employee.employee_id_card}"></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone" value="${employee.employee_phone}"></td>
        </tr>
        <tr>
            <td>Mail</td>
            <td><input type="text" name="mail" value="${employee.employee_email}"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" value="${employee.employee_address}"></td>
        </tr>
        <tr>
            <td>Salary</td>
            <td><input type="text" name="salary" value="${employee.employee_salary}"></td>
        </tr>
        <tr>
            <td>Education</td>
            <td><input type="text" name="education_degree_id" value="${employee.education_degree_id}"></td>
        </tr>
        <tr>
            <td>Id Type Customer</td>
            <td><input type="text" name="position" value="${employee.position_id}"></td>
        </tr>
        <tr>
            <td>Id Type Customer</td>
            <td><input type="text" name="division" value="${employee.division_id}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"></td>
            <td><input type="reset" value="Reset"></td>
        </tr>
    </table>
    <a href="listEmployee">Back to list</a>
    <input type="hidden" name="action" value="edit">
</form>
</body>
</html>
