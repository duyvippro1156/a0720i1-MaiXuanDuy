<%@ page import="java.time.LocalDate" %>
<%@ page import="ua.org.oa.annabezkrovnaya.service.impl.SessionServiceImpl" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.format.TextStyle" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>О Фильме</title>
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
        <div class="service-item"><a href="#">КАБИНЕТ</a></div>
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
    <div class="top">
        <div class="title"><c:out value="${movieDTO1.title}"/></div>
        <div class="button">Сегодня</div>
        <div class="button">Завтра</div>
        <div class="button">Неделя</div>
        <div class="button">Все даты</div>
    </div>
    <div class="film">
        <div class="data">
            <div class="poster"><img src="<c:url value="${movieDTO1.posterUrl}"/>" alt="Poster" /></div>
            <div class="trailer" data-title="Трейлер"><a href="${pageContext.servletContext.contextPath}/trailer?id=${movieDTO1.id}"><img src="<c:url value="/img/d_icon.png"/>" alt="icon"></a></div>
            <div class="data-b">
                <p><c:out value="${movieDTO1.genre}"/></p>
                <p><c:out value="${movieDTO1.country}"/></p>
                <p>
                    <fmt:setLocale value="ru_RU" />
                    <fmt:parseDate var="realCreationDate" value="${movieDTO1.startDate}" pattern="yyyy-MM-dd"/>
                    <fmt:formatDate value="${realCreationDate}" pattern="dd.MM.yyyy" />
                    -
                    <fmt:parseDate var="realCreationDate" value="${movieDTO1.finishDate}" pattern="yyyy-MM-dd"/>
                    <fmt:formatDate value="${realCreationDate}" pattern="dd.MM.yyyy" />
                </p>
                <p><c:out value="${movieDTO1.ageLimit}"/></p>
            </div>
            <div class="fullDescription">
                <i><c:out value="${movieDTO1.description}"/></i>
            </div>
        </div>
        <div class="session">
            <div class="dayS">
                <div class="block">
                    <p><%=LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yy"))%></p>
                    <p><%=LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru RU"))%></p>
                    <p>Синий зал</p>
                    <p>2D</p>
                </div>
                <div class="s_time">
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(1).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(2).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(3).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(4).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(5).getStartTime()%></a></div>
                </div>
            </div>
            <div class="dayS">
                <div class="block">
                    <p><%=LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("dd.MM.yy"))%></p>
                    <p><%=LocalDate.now().plusDays(1).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru RU"))%></p>
                    <p>Синий зал</p>
                    <p>2D</p>
                </div>
                <div class="s_time">
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(1).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(2).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(3).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(4).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(5).getStartTime()%></a></div>
                </div>
            </div>
            <div class="dayS">
                <div class="block">
                    <p><%=LocalDate.now().plusDays(2).format(DateTimeFormatter.ofPattern("dd.MM.yy"))%></p>
                    <p><%=LocalDate.now().plusDays(2).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru RU"))%></p>
                    <p>Синий зал</p>
                    <p>2D</p>
                </div>
                <div class="s_time">
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(1).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(2).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(3).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(4).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(5).getStartTime()%></a></div>
                </div>
            </div>
            <div class="dayS">
                <div class="block">
                    <p><%=LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yy"))%></p>
                    <p><%=LocalDate.now().plusDays(3).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru RU"))%></p>
                    <p>Синий зал</p>
                    <p>2D</p>
                </div>
                <div class="s_time">
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(1).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(2).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(3).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(4).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(5).getStartTime()%></a></div>
                </div>
            </div>
            <div class="dayS">
                <div class="block">
                    <p><%=LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yy"))%></p>
                    <p><%=LocalDate.now().plusDays(4).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru RU"))%></p>
                    <p>Синий зал</p>
                    <p>2D</p>
                </div>
                <div class="s_time">
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(1).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(2).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(3).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(4).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(5).getStartTime()%></a></div>
                </div>
            </div>
            <div class="dayS">
                <div class="block">
                    <p><%=LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yy"))%></p>
                    <p><%=LocalDate.now().plusDays(5).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru RU"))%></p>
                    <p>Синий зал</p>
                    <p>2D</p>
                </div>
                <div class="s_time">
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(1).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(2).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(3).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(4).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(5).getStartTime()%></a></div>
                </div>
            </div>
            <div class="dayS">
                <div class="block">
                    <p><%=LocalDate.now().plusDays(6).format(DateTimeFormatter.ofPattern("dd.MM.yy"))%></p>
                    <p><%=LocalDate.now().plusDays(6).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru RU"))%></p>
                    <p>Синий зал</p>
                    <p>2D</p>
                </div>
                <div class="s_time">
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(1).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(2).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(3).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(4).getStartTime()%></a></div>
                    <div class="block2"></div>
                    <div class="block1"><a href="#"><%=SessionServiceImpl.getInstance().getById(5).getStartTime()%></a></div>
                </div>
            </div>
        </div>
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
</body>
</html>
