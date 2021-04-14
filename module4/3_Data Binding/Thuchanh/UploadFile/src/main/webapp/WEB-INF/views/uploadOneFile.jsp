<%--
  Created by IntelliJ IDEA.
  User: DUY
  Date: 01/03/21
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Upload One File</title>

</head>

<body>

<jsp:include page="menu.jsp"/>

<h3>Upload One File:</h3>

<!-- MyUploadForm -->

<form:form modelAttribute="myUploadForm" method="POST" action="" enctype="multipart/form-data">

    Description:

    <br>

    <form:input path="description" style="width:300px;"/>

    <form:input path="fileDatas" type="file" /><br/>

    <input type="submit" value="Upload">

</form:form>

</body>

</html>