<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DUY
  Date: 01/02/21
  Time: 6:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>List Motel</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Danh sách phòng trọ</h2>
    <h5 style="float: right"><a href="createMotel">Create new Motel</a></h5>
    <form action="search" method="post">
        <input type="text" placeholder="Search" name="search">
        <input class="btn btn-primary" type="submit" value="Search">
    </form>
    <table class="table">
        <thead>
        <tr>
            <th>Mã phòng trọ</th>
            <th>Tên người thuê trọ</th>
            <th>Số điện thoại</th>
            <th>Ngày bắt đầu thuê</th>
            <th>Hình thức thanh toán</th>
            <th>Ghi chú</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listMotel}" var="motel">
            <tr class="table-primary">
                <td><a href="viewMotel?id=${motel.id}">${motel.id}</a></td>
                <td>${motel.name_customer}</td>
                <td>${motel.phone_number}</td>
                <td>${motel.date_begin}</td>
                <td>${motel.payment}</td>
                <td>${motel.note}</td>
                <td><a href="deleteMotel?id=${motel.id}">delete</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

</body>
</html>
