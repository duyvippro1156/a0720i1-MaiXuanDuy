<%--
  Created by IntelliJ IDEA.
  User: linht
  Date: 1/6/2021
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="editCustomer" method="post">
        <table>
            <tr>
                <td>ID</td>
                <td><input type="text" name="id" value="${customer.customer_id}" readonly></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${customer.cus_name}"></td>
            </tr>
            <tr>
                <td>Birthday</td>
                <td><input type="date" name="birthday" value="${customer.customer_birthday}"></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td><input type="text" name="gender" value="${customer.customer_gender}"></td>
            </tr>
            <tr>
                <td>Id Card</td>
                <td><input type="text" name="id_card" value="${customer.customer_id_card}"></td>
            </tr>
            <tr>
                <td>Phone</td>
                <td><input type="text" name="phone" value="${customer.customer_phone}"></td>
            </tr>
            <tr>
                <td>Mail</td>
                <td><input type="text" name="mail" value="${customer.customer_email}"></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address" value="${customer.customer_address}"></td>
            </tr>
            <tr>
                <td>Id Type Customer</td>
                <td><input type="text" name="id_type_customer" value="${customer.customer_type_id}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update"></td>
                <td><input type="reset" value="Reset"></td>
            </tr>
        </table>
        <a href="listCustomer">Back to list</a>
        <input type="hidden" name="action" value="edit">
    </form>
</body>
</html>
