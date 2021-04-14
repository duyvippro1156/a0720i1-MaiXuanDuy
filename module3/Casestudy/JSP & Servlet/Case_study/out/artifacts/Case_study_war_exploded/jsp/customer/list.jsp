<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linht
  Date: 1/6/2021
  Time: 6:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>
</head>
<body>
    <h1>Customer</h1>
    <form action="searchCustomer" method="post">
        Search
        <input type="text" placeholder="Search" name="search">
        <input type="submit" value="Search">
    </form>
    <p>
        <a href="createCustomer">Create new Customer</a>
    </p>
    <table border="1">
        <tr>
            <td>Name</td>
            <td>TypeCustomer</td>
<%--            <td>Birthday</td>--%>
<%--            <td>Gender</td>--%>
<%--            <td>ID Card</td>--%>
<%--            <td>Phone Number</td>--%>
<%--            <td>Email</td>--%>
<%--            <td>Address</td>--%>
            <td colspan="2">Action</td>
        </tr>
        <c:forEach items="${listCustomer}" var="customer">
            <tr>
                <td><a href="viewCustomer?id=${customer.customer_id}">${customer.cus_name}</a></td>
                <td>${customer.customer_type_id}</td>
<%--                <td>${customer.customer_birthday}</td>--%>
<%--                <td>${customer.customer_gender}</td>--%>
<%--                <td>${customer.customer_id_card}</td>--%>
<%--                <td>${customer.customer_phone}</td>--%>
<%--                <td>${customer.customer_email}</td>--%>
<%--                <td>${customer.customer_address}</td>--%>
                <td><a href="editCustomer?id=${customer.customer_id}">edit</a></td>
                <td><a href="deleteCustomer?id=${customer.customer_id}">delete</a></td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
