<%--
  Created by IntelliJ IDEA.
  User: DUY
  Date: 10/03/21
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Information</title>
</head>
<body>
<h2>Setting</h2>
<h3>Language: ${setting.language}</h3>
<h3>Page size: ${setting.pageSize}</h3>
<h3>Spam Filter: ${setting.spamFilter}</h3>
<h3>Signature: ${setting.signature}</h3>
<a href="/setting">Change</a>
</body>
</html>
