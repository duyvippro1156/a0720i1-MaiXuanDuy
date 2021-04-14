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
    <title>View</title>
</head>
<body>
    <p>Information of product</p>
    <table>
        <tr>
            <td>Name</td>
            <td>${product.name}</td>
        </tr>
        <tr>
            <td>Price</td>
            <td>${product.price}</td>
        </tr>
        <tr>
            <td>Producer</td>
            <td>${product.producer}</td>
        </tr>
        <tr>
            <td>Description</td>
            <td>${product.description}</td>
        </tr>
    </table>
    <a href="list">Back to list</a>
</body>
</html>
