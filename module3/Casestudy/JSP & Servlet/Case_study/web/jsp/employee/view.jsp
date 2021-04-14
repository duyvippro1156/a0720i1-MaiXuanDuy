<%--
  Created by IntelliJ IDEA.
  User: DUY
  Date: 29/01/21
  Time: 7:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Employee</title>
</head>
<body>
<table border="1px">
    <tr>
        <th>ID</th>
        <td>${employee.employee_id}</td>
    </tr>
    <tr>
        <th>Name</th>
        <td>${employee.employee_name} </td>
    </tr>
    <tr>
        <th>Level</th>
        <td>${employee.education_degree_id} </td>
    </tr>
    <tr>
        <th>Department</th>
        <td>${employee.division_id} </td>
    </tr>
    <tr>
        <th>Position</th>
        <td>${employee.position_id}</td>
    </tr>
    <tr>
        <th>Birthday</th>
        <td>${employee.employee_birthday}</td>
    </tr>
    <tr>
        <th>ID Card</th>
        <td>${employee.employee_id_card}</td>
    </tr>
    <tr>
        <th>Phone Number</th>
        <td>${employee.employee_phone}</td>
    </tr>
    <tr>
        <th>Email</th>
        <td>${employee.employee_email}</td>
    </tr>
    <tr>
        <th>Address</th>
        <td>${employee.employee_address}</td>
    </tr>
    <tr>
        <th>Salary</th>
        <td>${employee.employee_salary}</td>
    </tr>
</table>
<hr>
<a  href="listEmployee">Back to List !!</a>
</body>
</html>
