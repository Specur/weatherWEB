<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html lang="pl">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1">

<title>Weather Project - ${szczyt} - Pogoda</title>

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
						<li class="menu-item"><a href="<c:url value="/" />">Strona główna</a></li>
						<li class="menu-item current-menu-item"><a href="<c:url value="/peaks" />">Szczyty</a></li>
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
		
		<div class="hero" data-bg-image="<c:url value="/resources/images/peak.jpg" />">

		</div>

		
		<main class="main-content">
		<div class="fullwidth-block">
			<div class="container">
				<h2 class="section-title">${szczyt}</h2>
             
           
			         </tr>
			         </br>
			         dzien tygodnia: ${dayOfWeek}
			         </br>
			         dzien      : ${calendar}
			         </br>
			         pora dnia  : ${timeOfTheDay}
			         </br>
			         temperatura najwyzsza: ${temph}
			         </br>
			         temperatura najnizsza: ${templ}
			         </br>
			          deszcz(mm): ${rain}
			         </br>
			         prognoza: ${forecast}
			         </br>
			         
					</div>

			</div>
		</div>
		
		<div class="forecast-table">
			<div class="container">
				<div class="forecast-container" style="margin-top:-50px;">
			
					<div class="forecast forecast-peak">
						<div class="forecast-header">
							<div class="day">${calendar[0]}</div>
						</div>
						<!-- .forecast-header -->
						<div class="forecast-content">
							<div class="forecast-icon">
						
							${timeOfTheDay[0] == '<span class="tiny">night</span>' ? "<strong>Noc</strong><br>" : ''}
							${timeOfTheDay[0] == '<span class="tiny">AM</span>' ? "<strong>Rano</strong><br>" : ''}
							${timeOfTheDay[0] == '<span class="tiny">PM</span>' ? "<strong>Po południu</strong><br>" : ''}
							
							
							<c:choose>
							    <c:when test="${forecast[0]=='rain shwrs'}">
							        <img src="<c:url value="/resources/images/icons/icon-3.svg" />"
									alt="" width=48>
							    </c:when> 
							</c:choose>
							</div>
							min
							<div class="degree">
								 ${templ[0]}<sup>o</sup>C
							</div>
							max
							<div class="degree">
								 ${temph[0]}<sup>o</sup>C
							</div>
							<br>
							 <span><img
								src="<c:url value="/resources/images/icon-umberella.png" />" alt="" style="float:left;">${rain[0]}mm</span>
							
						</div>
						<div class="forecast-content">
							<div class="forecast-icon">
								<img src="<c:url value="/resources/images/icons/icon-3.svg" />"
									alt="" width=48>
							</div>
							<div class="degree">
								${temperature[3]}<sup>o</sup>C
							</div>
							<br>
							 <span><img
								src="<c:url value="/resources/images/icon-umberella.png" />" alt="" style="float:left;">${rain[0]}mm</span>
							<br><span><img
								src="<c:url value="/resources/images/icon-compass.png" />"
								alt="" style="float:left;">${pressure[3]}</span>
						</div>
						<div class="forecast-content">
							<div class="forecast-icon">
								<img src="<c:url value="/resources/images/icons/icon-3.svg" />"
									alt="" width=48>
							</div>
							<div class="degree">
								${temperature[3]}<sup>o</sup>C
							</div>
							<br>
							 <span><img
								src="<c:url value="/resources/images/icon-umberella.png" />" alt="" style="float:left;">${rain[0]}</span>
							<br><span><img
								src="<c:url value="/resources/images/icon-compass.png" />"
								alt="" style="float:left;">${pressure[3]}</span>
						</div>
					</div>
					<div class="forecast forecast-peak">
						<div class="forecast-header">
							<div class="day">${calendar[2]}</div>
						</div>
						<!-- .forecast-header -->
						<div class="forecast-content">
							<div class="forecast-icon">
								<img src="<c:url value="/resources/images/icons/icon-5.svg" />"
									alt="" width=48>
							</div>
							<div class="degree">
								${temperature[4]}<sup>o</sup>C
							</div>
							<br>
							<span><img
								src="<c:url value="/resources/images/icon-wind.png" />" alt="" style="float:left;">${wind[4]}</span>
							<br><span><img
								src="<c:url value="/resources/images/icon-compass.png" />"
								alt="" style="float:left;">${pressure[4]}</span>
						</div>
					</div>
					<div class="forecast forecast-peak">
						<div class="forecast-header">
							<div class="day">${calendar[3]}</div>
						</div>
						<!-- .forecast-header -->
						<div class="forecast-content">
							<div class="forecast-icon">
								<img src="<c:url value="/resources/images/icons/icon-7.svg" />"
									alt="" width=48>
							</div>
							<div class="degree">
								${temperature[5]}<sup>o</sup>C
							</div>
							<br>
							<span><img
								src="<c:url value="/resources/images/icon-wind.png" />" alt="" style="float:left;">${wind[5]}</span>
							<br><span><img
								src="<c:url value="/resources/images/icon-compass.png" />"
								alt="" style="float:left;">${pressure[5]}</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		<br>
		<div class="forecast-table">
			<div class="container">
				<div class="forecast-container" style="margin-top:-50px;">
			
					<div class="forecast forecast-peak">
						<div class="forecast-header">
							<div class="day">${calendar[0]}</div>
						</div>
						<!-- .forecast-header -->
						<div class="forecast-content">
							<div class="forecast-icon">
								<img src="<c:url value="/resources/images/icons/icon-3.svg" />"
									alt="" width=48>
							</div>
							<div class="degree">
								${temperature[3]}<sup>o</sup>C
							</div>
							<br>
							 <span><img
								src="<c:url value="/resources/images/icon-umberella.png" />" alt="" style="float:left;">${rain[0]}</span>
							<br><span><img
								src="<c:url value="/resources/images/icon-compass.png" />"
								alt="" style="float:left;">${pressure[3]}</span>
						</div>
					</div>
					<div class="forecast forecast-peak">
						<div class="forecast-header">
							<div class="day">${calendar[2]}</div>
						</div>
						<!-- .forecast-header -->
						<div class="forecast-content">
							<div class="forecast-icon">
								<img src="<c:url value="/resources/images/icons/icon-5.svg" />"
									alt="" width=48>
							</div>
							<div class="degree">
								${temperature[4]}<sup>o</sup>C
							</div>
							<br>
							<span><img
								src="<c:url value="/resources/images/icon-wind.png" />" alt="" style="float:left;">${wind[4]}</span>
							<br><span><img
								src="<c:url value="/resources/images/icon-compass.png" />"
								alt="" style="float:left;">${pressure[4]}</span>
						</div>
					</div>
					<div class="forecast forecast-peak">
						<div class="forecast-header">
							<div class="day">${calendar[3]}</div>
						</div>
						<!-- .forecast-header -->
						<div class="forecast-content">
							<div class="forecast-icon">
								<img src="<c:url value="/resources/images/icons/icon-7.svg" />"
									alt="" width=48>
							</div>
							<div class="degree">
								${temperature[5]}<sup>o</sup>C
							</div>
							<br>
							<span><img
								src="<c:url value="/resources/images/icon-wind.png" />" alt="" style="float:left;">${wind[5]}</span>
							<br><span><img
								src="<c:url value="/resources/images/icon-compass.png" />"
								alt="" style="float:left;">${pressure[5]}</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<style>
		
		.forecast-container .forecast.forecast-peak .forecast-content {
		    padding: 50px 20px 10px;
		    text-align: center;
		    float: left;
		    width: 33.3333%;
		}
				
		@media screen and (max-width: 990px) {
			.forecast-container .forecast.forecast-peak {
				display: block;
				width: 33.333%!important;
				float: left;
			}
		}
		
		@media screen and (max-width: 767px) {
			.forecast-container .forecast.forecast-peak {
				display: block;
				width: 100%!important;
				float: left;
			}
		}
		
		</style>

		<jsp:include page="modules/news.jsp" />

		<jsp:include page="modules/interesting.jsp" />
		
		</main>
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