<%--
  Created by IntelliJ IDEA.
  User: DUY
  Date: 12/01/21
  Time: 6:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h1>Edit product</h1>
<form action="edit" method="post">
    <table>
        <tr>
            <th>Id</th>
            <td><input type="text" name="id" value="${product.id}" readonly></td>
        </tr>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name" value="${product.name}"></td>
        </tr>
        <tr>
            <th>Price</th>
            <td><input type="text" name="price" value="${product.price}"></td>
        </tr>
        <tr>
            <th>Producer</th>
            <td><input type="text" name="producer" value="${product.producer}"></td>
        </tr>
        <tr>
            <th>Description</th>
            <td><input type="text" name="description" value="${product.description}"></td>
        </tr>
    </table>
    <input type="submit" value="Save">
    <input type="reset" value="Reset">
    <input type="hidden" name="action" value="edit">
    <a href="list">Back to list</a>
</form>
</body>
</html>
