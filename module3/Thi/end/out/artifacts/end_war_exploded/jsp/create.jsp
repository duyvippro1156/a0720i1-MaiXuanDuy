<%--
  Created by IntelliJ IDEA.
  User: DUY
  Date: 01/02/21
  Time: 6:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Motel</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<form action="createMotel" method="post">
    <div class="form-group">
        <label for="exampleInputNameCustomer">Tên người thuê trọ</label>
        <input type="text" class="form-control" id="exampleInputNameCustomer" name="name_customer"  placeholder="Nhập tên người thuê trọ">
    </div>

    <div class="form-group">
        <label for="exampleInputPhoneNumber">Số điện thoại</label>
        <input type="tel" class="form-control" id="exampleInputPhoneNumber" name="phone_number" placeholder="Số điện thoại">
    </div>

    <div class="form-group">
        <label for="exampleInputDateBegin">Ngày bắt đầu thuê</label>
        <input type="date" class="form-control" id="exampleInputDateBegin" name="date_begin" placeholder="Ngày bắt đầu thuê">
    </div>

    <div class="form-group">
        <label for="exampleInputPayment">Hình thức thanh toán</label>
        <input type="text" class="form-control" id="exampleInputPayment" name="id_payments" placeholder="Hình thức thanh toán (1:tháng , 2:quý ,3: năm)">
    </div>

    <div class="form-group">
        <label for="exampleInputNote">Ghi chú</label>
        <input type="text" class="form-control" id="exampleInputNote" name="note" placeholder="Ghi chú">
    </div>

    <input type="submit" class="btn btn-primary" value="Create">
    <input type="reset" class="btn btn-primary" value="Reset">
    <a href="listMotel">Back to list</a>
</form>
</body>
</html>
