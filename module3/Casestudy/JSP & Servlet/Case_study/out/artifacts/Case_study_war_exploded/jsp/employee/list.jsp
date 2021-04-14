<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DUY
  Date: 29/01/21
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Employee</title>
</head>
<body>
<h1>Customer</h1>
<form action="searchEmployee" method="post">
    Search
    <input type="text" placeholder="Search" name="search">
    <input type="submit" value="Search">
    <a href="listEmployee">Show all Employee</a>
</form>
<p>
    <a href="createEmployee">Create new Employee</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Position</td>
        <td colspan="2">Action</td>
    </tr>
    <c:forEach items="${listEmployee}" var="employee">
        <tr>
            <td><a href="viewEmployee?id=${employee.employee_id}">${employee.employee_name}</a></td>
            <td>${employee.position_id}</td>
            <td><a href="editEmployee?id=${employee.employee_id}">edit</a></td>
            <td><a href="deleteEmployee?id=${employee.employee_id}">delete</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>

