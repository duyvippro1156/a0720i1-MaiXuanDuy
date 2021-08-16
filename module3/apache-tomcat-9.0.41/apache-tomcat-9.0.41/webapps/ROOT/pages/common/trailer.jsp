<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="button"><a href="<c:url value="${pageContext.request.contextPath}/index"/>">Вернуться на Главную</a></div>
<video width="80%" height="80%" controls="controls" autoplay>
    <source src="<c:url value="${movieDTO2.trailerUrl}"/>" type='video/mp4; codecs="avc1.42E01E, mp4a.40.2"'>
    Видео не поддерживается вашим браузером.
</video>

</body>
</html>
