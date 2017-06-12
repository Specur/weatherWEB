<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="pl">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1.0,maximum-scale=1">

	<title>Weather Project</title>

	<!-- Loading third party fonts -->
	<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|"
		  rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/fonts/font-awesome.min.css" />" rel="stylesheet" type="text/css">


	<!-- Loading main css file -->
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/lightbox.css" />" rel="stylesheet">

</head>


<body>

<div class="site-content">
	<div class="site-header">
		<div class="container">
			<a href="<c:url value="/" />" class="branding"> <img
					src="<c:url value="/resources/images/logo.png" />" alt="" class="logo">
				<div class="logo-type">
					<h1 class="site-title">Weather Project</h1>
					<small class="site-description">...</small>
				</div>
			</a>

			<!-- Default snippet for navigation -->
			<div class="main-navigation">
				<button type="button" class="menu-toggle">
					<i class="fa fa-bars"></i>
				</button>
				<ul class="menu">

					<li class="menu-item current-menu-item"><a href="<c:url value="/" />">Strona główna</a></li>
					<li class="menu-item"><a href="<c:url value="/peaks" />">Szczyty</a></li>
					<li class="menu-item"><a href="<c:url value="/weekendWeather"/>">Pogoda na weekend</a></li>
					<li class="menu-item"><a href="<c:url value="/smogkrakow" />">Smog Kraków</a></li>
					<li class="menu-item"><a href="<c:url value="/authors" />">Autorzy</a></li>
				</ul>
				<!-- .menu -->
			</div>
			<!-- .main-navigation -->

			<div class="mobile-navigation"></div>

		</div>
	</div>
	<!-- .site-header -->

	<div class="hero" data-bg-image="<c:url value="/resources/images/banner.jpg" />">
		<div class="container">
			<form:form modelAttribute="city" class="find-location">
				<form:input id="name" path="name" type="text" placeholder="Wpisz miejscowość"/>
				<input type="submit" id="btnAdd" value ="Szukaj"/>
			</form:form>

		</div>
	</div>
	
	<div class="forecast-table">
			<div class="container">
				<div class="forecast-container">
					<div class="today forecast">
						<div class="forecast-header">
							<div class="day">${dayOfWeek[0]}</div>
							<div class="date">${calendar[0]}</div>
						</div>
						<!-- .forecast-header -->
						<div class="forecast-content">
							<div class="location">Kraków</div>
							<div class="degree">
								<div class="num">
									${temperature[0]}<sup>o</sup>C
								</div>
								<div class="forecast-icon">
									<c:if
									test="${fn:contains(description[0], 'Zachmurzenie całkowite')}">
									<img src="<c:url value="/resources/images/icons/icon-6.svg" />"
										alt="" width=90>
								</c:if>
								<c:if
									test="${fn:contains(description[0], 'Pochmurno, słabe opady deszczu')}">
									<img src="<c:url value="/resources/images/icons/icon-4.svg" />"
										alt="" width=90>
								</c:if>
								<c:if
									test="${fn:contains(description[i], 'Bezchmurnie')}">
									<img src="<c:url value="/resources/images/icons/icon-2.svg" />"
										alt="" width=48>
								</c:if>

								<c:choose>
									<c:when test="${fn:contains(description[0], 'Pogodnie')}">

										<c:choose>
											<c:when
												test="${fn:contains(description[0], 'Pogodnie, okresami wzrost zachmurzenia do umiarkowanego')}">

												<img
													src="<c:url value="/resources/images/icons/icon-3.svg" />"
													alt="" width=90>
											</c:when>
											<c:otherwise>

												<img
													src="<c:url value="/resources/images/icons/icon-2.svg" />"
													alt="" width=90>

											</c:otherwise>

										</c:choose>

									</c:when>

								</c:choose>


								<c:if
									test="${fn:contains(description[0], 'Zachmurzenie małe, możliwe słabe opady deszczu')}">
									<img src="<c:url value="/resources/images/icons/icon-4.svg" />"
										alt="" width=90>
								</c:if>
								<c:if
									test="${fn:contains(description[0], 'Pochmurno z przejaśnieniami, słabe opady deszczu')}">
									<img src="<c:url value="/resources/images/icons/icon-4.svg" />"
										alt="" width=90>
								</c:if>
								<c:if
									test="${fn:contains(description[0], 'Pochmurno, okresami przejaśnienia')}">
									<img src="<c:url value="/resources/images/icons/icon-3.svg" />"
										alt="" width=90>
								</c:if>
								</div>
							</div>
							<span><img
								src="<c:url value="/resources/images/icon-wind.png" />" alt="">${wind[0]}</span>
							<span><img
								src="<c:url value="/resources/images/icon-compass.png" />"
								alt="">${pressure[0]}</span>
						</div>
					</div>

					<%!int i;%>

					<%
						for (i = 1; i <= 6; i++) {
					%>

					<c:set var="i" value="<%=i%>" />

					<div class="forecast">
						<div class="forecast-header">
							<div class="day">${dayOfWeek[i]}</div>
						</div>
						<!-- .forecast-header -->
						<div class="forecast-content">
						
							<div class="forecast-icon">

								

								<c:if
									test="${fn:contains(description[i], 'Zachmurzenie całkowite')}">
									<img src="<c:url value="/resources/images/icons/icon-6.svg" />"
										alt="" width=48>
								</c:if>
								<c:if
									test="${fn:contains(description[i], 'Pochmurno, słabe opady deszczu')}">
									<img src="<c:url value="/resources/images/icons/icon-4.svg" />"
										alt="" width=48>
								</c:if>
								
								<c:if
									test="${fn:contains(description[i], 'Bezchmurnie')}">
									<img src="<c:url value="/resources/images/icons/icon-2.svg" />"
										alt="" width=48>
								</c:if>
								

								<c:choose>
									<c:when test="${fn:contains(description[i], 'Pogodnie')}">

										<c:choose>
											<c:when
												test="${fn:contains(description[i], 'Pogodnie, okresami wzrost zachmurzenia do umiarkowanego')}">

												<img
													src="<c:url value="/resources/images/icons/icon-3.svg" />"
													alt="" width=48>
											</c:when>
											<c:otherwise>

												<img
													src="<c:url value="/resources/images/icons/icon-2.svg" />"
													alt="" width=48>

											</c:otherwise>

										</c:choose>

									</c:when>

								</c:choose>


								<c:if
									test="${fn:contains(description[i], 'Zachmurzenie małe, możliwe słabe opady deszczu')}">
									<img src="<c:url value="/resources/images/icons/icon-4.svg" />"
										alt="" width=48>
								</c:if>
								<c:if
									test="${fn:contains(description[i], 'Pochmurno z przejaśnieniami, słabe opady deszczu')}">
									<img src="<c:url value="/resources/images/icons/icon-4.svg" />"
										alt="" width=48>
								</c:if>
								<c:if
									test="${fn:contains(description[i], 'Pochmurno, okresami przejaśnienia')}">
									<img src="<c:url value="/resources/images/icons/icon-3.svg" />"
										alt="" width=48>
								</c:if>


							</div>
							<div class="degree">
								${temperature[i+3]}<sup>o</sup>C
							</div>
							<br> <span><img
								src="<c:url value="/resources/images/icon-wind.png" />" alt=""
								style="float: left;">${wind[i+3]}</span> <br> <span><img
								src="<c:url value="/resources/images/icon-compass.png" />"
								alt="" style="float: left;">${pressure[i+3]}</span>
						</div>
					</div>

					<%
						}
					%>

				</div>
			</div>
		</div>

	<main class="main-content">

		<jsp:include page="modules/livecameras.jsp" />
		

		<jsp:include page="modules/news.jsp" />

		<jsp:include page="modules/interesting.jsp" />

	</main>
	<!-- .main-content -->

	<jsp:include page="modules/footer.jsp" />

	<!-- .site-footer -->
	
	<style>
	
	.arrow-feature li {
	    position: relative;
	    padding-left: 0!important;
	}
	
	</style>
	
</div>

<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/lightbox.js" />"></script>
<script src="<c:url value="/resources/js/plugins.js" />"></script>
<script src="<c:url value="/resources/js/app.js" />"></script>

</body>

</html>