<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="pl">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1">

<title>Weather Project - Pogoda</title>

<!-- Loading third party fonts -->
<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/fonts/font-awesome.min.css" />"
	rel="stylesheet" type="text/css">


<!-- Loading main css file -->
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/lightbox.css" />"
	rel="stylesheet">

</head>


<body>

	<div class="site-content">
		<div class="site-header">
			<div class="container">
				<a href="<c:url value="/" />" class="branding"> <img
					src="<c:url value="/resources/images/logo.png" />" alt=""
					class="logo">
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
						<li class="menu-item"><a href="<c:url value="/" />">Strona
								główna</a></li>
						<li class="menu-item"><a href="<c:url value="/peaks" />">Szczyty</a></li>
						<li class="menu-item"><a href="#">Pogoda na weekend</a></li>
						<li class="menu-item"><a href="<c:url value="/smogkrakow" />">Smog
								Kraków</a></li>
						<li class="menu-item"><a href="<c:url value="/authors" />">Autorzy</a></li>
					</ul>
					<!-- .menu -->
				</div>
				<!-- .main-navigation -->

				<div class="mobile-navigation"></div>

			</div>
		</div>
		<!-- .site-header -->

		<div class="hero"
			data-bg-image="<c:url value="/resources/images/weather.jpg" />">

		</div>


		<main class="main-content">
		<div class="fullwidth-block">
			<div class="container">

				<h2 class="section-title">Pogoda ${city}</h2>
				<br>

				<div class="col-12">
					<p>
						Dni <b> ${calendar}</b>
					</p>
					<p>
						Wiatr <b> ${wind}</b>
					</p>
					<p>
						Cisnienie <b> ${pressure}</b>
					</p>
					<p>
						Temperatura <b> ${temperature}</b>
					</p>
					<p>
						Temperatura <b> ${temperature[0]}</b>
					</p>
				</div>


			</div>
		</div>

		<div class="fullwidth-block">
			<div class="container">
				<h2 class="section-title">Pogoda ${city}</h2>
			</div>
		</div>

		<div style="clear: both"></div>

		<div class="forecast-table">
			<div class="container">
				<div class="forecast-container" style="margin-top:-50px;">
					<div class="today forecast">
						<div class="forecast-header">
							<div class="day">Monday</div>
							<div class="date">${calendar[0]}</div>
						</div>
						<!-- .forecast-header -->
						<div class="forecast-content">
							<div class="location">${city}</div>
							<div class="degree">
								<div class="num">
									${temperature[0]}<sup>o</sup>C
								</div>
								<div class="forecast-icon">
									<img src="<c:url value="/resources/images/icons/icon-1.svg" />"
										alt="" width=90>
								</div>
							</div>
							 <span><img
								src="<c:url value="/resources/images/icon-wind.png" />" alt="">${wind[0]}</span>
							<span><img
								src="<c:url value="/resources/images/icon-compass.png" />"
								alt="">${pressure[0]}</span>
						</div>
					</div>
					<div class="forecast">
						<div class="forecast-header">
							<div class="day">Tuesday</div>
						</div>
						<!-- .forecast-header -->
						<div class="forecast-content">
							<div class="forecast-icon">
								<img src="<c:url value="/resources/images/icons/icon-3.svg" />"
									alt="" width=48>
							</div>
							<div class="degree">
								23<sup>o</sup>C
							</div>
							<small>18<sup>o</sup></small>
						</div>
					</div>
					<div class="forecast">
						<div class="forecast-header">
							<div class="day">Wednesday</div>
						</div>
						<!-- .forecast-header -->
						<div class="forecast-content">
							<div class="forecast-icon">
								<img src="<c:url value="/resources/images/icons/icon-5.svg" />"
									alt="" width=48>
							</div>
							<div class="degree">
								23<sup>o</sup>C
							</div>
							<small>18<sup>o</sup></small>
						</div>
					</div>
					<div class="forecast">
						<div class="forecast-header">
							<div class="day">Thursday</div>
						</div>
						<!-- .forecast-header -->
						<div class="forecast-content">
							<div class="forecast-icon">
								<img src="<c:url value="/resources/images/icons/icon-7.svg" />"
									alt="" width=48>
							</div>
							<div class="degree">
								23<sup>o</sup>C
							</div>
							<small>18<sup>o</sup></small>
						</div>
					</div>
					<div class="forecast">
						<div class="forecast-header">
							<div class="day">Friday</div>
						</div>
						<!-- .forecast-header -->
						<div class="forecast-content">
							<div class="forecast-icon">
								<img src="<c:url value="/resources/images/icons/icon-12.svg" />"
									alt="" width=48>
							</div>
							<div class="degree">
								23<sup>o</sup>C
							</div>
							<small>18<sup>o</sup></small>
						</div>
					</div>
					<div class="forecast">
						<div class="forecast-header">
							<div class="day">Saturday</div>
						</div>
						<!-- .forecast-header -->
						<div class="forecast-content">
							<div class="forecast-icon">
								<img src="<c:url value="/resources/images/icons/icon-13.svg" />"
									alt="" width=48>
							</div>
							<div class="degree">
								23<sup>o</sup>C
							</div>
							<small>18<sup>o</sup></small>
						</div>
					</div>
					<div class="forecast">
						<div class="forecast-header">
							<div class="day">Sunday</div>
						</div>
						<!-- .forecast-header -->
						<div class="forecast-content">
							<div class="forecast-icon">
								<img src="<c:url value="/resources/images/icons/icon-14.svg" />"
									alt="" width=48>
							</div>
							<div class="degree">
								23<sup>o</sup>C
							</div>
							<small>18<sup>o</sup></small>
						</div>
					</div>
				</div>
			</div>
		</div>

		<jsp:include page="modules/news.jsp" /> <jsp:include
			page="modules/interesting.jsp" /> </main>
		<!-- .main-content -->

		<jsp:include page="modules/footer.jsp" />

		<!-- .site-footer -->
	</div>

	<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/lightbox.js" />"></script>
	<script src="<c:url value="/resources/js/plugins.js" />"></script>
	<script src="<c:url value="/resources/js/app.js" />"></script>

</body>

</html>

