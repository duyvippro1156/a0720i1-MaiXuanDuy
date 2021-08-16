<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Главная</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="<c:url value="/css/master.css"/>" />
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" />
    <style>
        body {
            background-image: url(<c:url value="/img/back.jpg"/>);
        }
    </style>
</head>
<body>
<header>
    <div class="logo"><a href="${pageContext.request.contextPath}/index"><img src="<c:url value="/img/logo_yellow.png"/>" alt="Site logo"></a></div>
    <div class="menu">
        <div class="menu-item"><a href="${pageContext.request.contextPath}/sessions">СЕАНСЫ</a></div>
        <div class="menu-item"><a href="${pageContext.request.contextPath}/movies_l">ФИЛЬМЫ</a></div>
        <div class="menu-item"><a href="${pageContext.request.contextPath}/cinema">КИНОТЕАТР</a></div>
    </div>
    <div class="search">
        <form class="search" action="${pageContext.request.contextPath}/index.jsp" method="post">
            <label>
                <input type="search" name="search"/>
            </label>
            <input type="image" src="<c:url value="/img/search_img.png"/>" alt="Submit" />
        </form>
    </div>
    <div class="service_menu">
        <div class="service-item"><a href="#">ПОМОЩЬ</a></div>
        <div class="service-item"><a href="${pageContext.request.contextPath}/login_page">КАБИНЕТ</a></div>
    </div>
    <div class="languages">
        <div class="wrap">
            <button class="clicker">рус</button>
            <div class="circle angled"></div>
        </div>
        <div class="wrap1">
            <button class="clicker1">укр</button>
            <div class="circle angled1"></div>
        </div>
    </div>
</header>
<div class="film-page">
    <div class="film-list">
        <c:forEach items="${movieDTOList}" var="movies">
        <div class="film-box">
            <div class="film-date">c<fmt:setLocale value="ru_RU" />
                <fmt:parseDate var="realCreationDate" value="${movies.startDate}" pattern="yyyy-MM-dd"/>
                <fmt:formatDate value="${realCreationDate}" pattern="dd-MM-yyyy" />
            </div>
            <div class="film-poster"><img src="<c:url value="${movies.posterUrl}"/>" alt="poster" /></div>
            <div class="film-data">
                <b><c:out value="${movies.title}"/></b>
                <p><i><c:out value="${movies.genre}"/></i></p>
                <p><c:out value="${movies.country}"/></p>
            </div>
            <div class="film-ticket"><a href="${pageContext.servletContext.contextPath}/movie_s?id=${movies.id}">КУПИТЬ БИЛЕТ</a></div>
        </div>
        </c:forEach>
    </div>
</div>
<footer>
    <div class="mail">info@ymovie.kharkiv.ua</div>
    <div class="phone">
        <b>0 800 300 500</b>
        <p>Звоните бесплатно с 9:00 до 21:00</p>
    </div>
    <div class="icons">
        <a href="#"> <img src="<c:url value="/img/icon1.png"/>" alt="viber"></a>
        <a href="#"> <img src="<c:url value="/img/icon2.png"/>" alt="skype"></a>
        <a href="#"> <img src="<c:url value="/img/icon3.png"/>" alt="facebook"></a>
        <a href="#"> <img src="<c:url value="/img/icon4.png"/>" alt="twitter"></a>
    </div>
</footer>

<script src=""></script>
</body>
</html>