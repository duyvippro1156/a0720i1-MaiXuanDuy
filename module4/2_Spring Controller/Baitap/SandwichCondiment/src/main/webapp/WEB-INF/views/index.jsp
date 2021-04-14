<%--
  Created by IntelliJ IDEA.
  User: DUY
  Date: 26/02/21
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>The World Clock</title>
  <style type="text/css">
    select {
      width: 200px;
      height: 20px;
    }
  </style>
</head>
<body>
<h2>Sandwich Condiment</h2>
<form action="/sandwich", commandName = "sandwich" , method="post">
  <input type="checkbox"  name="condiments" value="lettuce">
  <label>Lettuce</label>
  <input type="checkbox"  name="condiments" value="tomato">
  <label>Tomato</label>
  <input type="checkbox"  name="condiments" value="mustard">
  <label>Mustard</label>
  <input type="checkbox"  name="condiments" value="sprouts">
  <label>Sprouts</label>
  <br><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>