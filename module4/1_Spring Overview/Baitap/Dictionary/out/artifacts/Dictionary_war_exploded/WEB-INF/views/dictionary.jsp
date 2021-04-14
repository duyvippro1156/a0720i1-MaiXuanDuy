<%--
  Created by IntelliJ IDEA.
  User: DUY
  Date: 10/03/21
  Time: 5:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="/search", method="post">
    <label>English</label>
    <input type="text" name="word" required>
    <input type="submit" value="search">
</form>
<hr>
<c:if test="${vietnamese != null}">
    <h3>English: ${english}</h3>
    <h3>Tiếng Việt: ${vietnamese}</h3>
</c:if>
</body>
</html>
