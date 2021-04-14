<%--
  Created by IntelliJ IDEA.
  User: DUY
  Date: 28/12/20
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Converter</title>
</head>
<body>
<h2>Currency Converter</h2>
<form action="converter.jsp" method="post">
<%--    http://localhost:8080/Chuyendoitiente_war_exploded/jsp/converter.jsp--%>
    <label>Rate: </label><br/>
    <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>
    <label>USD: </label><br/>
    <input type="text" name="usd" placeholder="USD" value="0"/><br/>
    <input type = "submit" id = "submit" value = "Converter"/>
</form>
</body>
</body>
</html>
