<%--
  Created by IntelliJ IDEA.
  User: linht
  Date: 1/6/2021
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Customer</title>
</head>
<body>
    <p>Information of customer</p>
    <table>
        <tr>
            <td>Name</td>
            <td>${customer.cus_name}</td>
        </tr>
        <tr>
            <td>TypeCustomer</td>
            <td>${customer.customer_type_id}</td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td>${customer.customer_birthday}</td>
        </tr>
        <tr>
            <td>Gender</td>
            <td>${customer.customer_gender}</td>
        </tr>
        <tr>
            <td>ID Card</td>
            <td>${customer.customer_id_card}</td>
        </tr>
        <tr>
            <td>Phone Number</td>
            <td>${customer.customer_phone}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${customer.customer_email}</td>
        </tr>
        <tr>
            <td>Address</td>
            <td>${customer.customer_address}</td>
        </tr>
    </table>
    <a href="listCustomer">Back to list !^^</a>
</body>
</html>
