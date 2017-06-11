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
			         ${noURL}
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
		
		<%! int k; %> 
		
		 <%for ( k = 0; k <= 1; k++){ %>
		
		<div class="forecast-table">
			<div class="container">
				<div class="forecast-container" style="margin-top:-50px;">
			
					<%! int i; %> 
					
					 <%for ( i = k*3; i <= (k*3)+2; i++){ %>
					 
					<div class="forecast forecast-peak">
						<div class="forecast-header">
							<c:set var="i" value="<%= i %>"/>
							<div class="day">${calendar[i]} - ${dayOfWeek[i]}</div>
						</div>
						<!-- .forecast-header -->
						
						<%! int j; %> 
						
						<%for ( j = i*3; j <= (i*3)+2; j++){ %>
					       
						<div class="forecast-content">
							<div class="forecast-icon">
							
							<c:set var="j" value="<%= j %>"/>
						
							${timeOfTheDay[j] == '<span class="tiny">night</span>' ? "<strong>Noc</strong><br>" : ''}
							${timeOfTheDay[j] == '<span class="tiny">AM</span>' ? "<strong>Rano</strong><br>" : ''}
							${timeOfTheDay[j] == '<span class="tiny">PM</span>' ? "<strong>Po południu</strong><br>" : ''}
							
							<c:choose>
							    <c:when test="${forecast[j]=='rain shwrs'}">
							        <img src="<c:url value="/resources/images/icons/icon-10.svg" />"
									alt="" width=48>
							    </c:when> 
							    <c:when test="${forecast[j]=='clear'}">
							        <img src="<c:url value="/resources/images/icons/icon-2.svg" />"
									alt="" width=48>
							    </c:when> 
							    <c:when test="${forecast[j]=='some clouds'}">
							        <img src="<c:url value="/resources/images/icons/icon-3.svg" />"
									alt="" width=48>
							    </c:when> 
							    <c:when test="${forecast[j]=='heavy rain'}">
							        <img src="<c:url value="/resources/images/icons/icon-10.svg" />"
									alt="" width=48>
							    </c:when> 
							    <c:when test="${forecast[j]=='snow shwrs'}">
							        <img src="<c:url value="/resources/images/icons/icon-14.svg" />"
									alt="" width=48>
							    </c:when> 
							    <c:when test="${forecast[j]=='light snow'}">
							        <img src="<c:url value="/resources/images/icons/icon-13.svg" />"
									alt="" width=48>
							    </c:when> 
							    <c:when test="${forecast[j]=='mod. rain'}">
							        <img src="<c:url value="/resources/images/icons/icon-10.svg" />"
									alt="" width=48>
							    </c:when> 
							    <c:when test="${forecast[j]=='mod. snow'}">
							        <img src="<c:url value="/resources/images/icons/icon-13.svg" />"
									alt="" width=48>
							    </c:when> 
							</c:choose>
							</div>
							min
							<div class="degree">
								 ${templ[j]}<sup>o</sup>C
							</div>
							max
							<div class="degree">
								 ${temph[j]}<sup>o</sup>C
							</div>
							<br>
							 <span><img
								src="<c:url value="/resources/images/icon-umberella.png" />" alt="" style="float:left;">${rain[j]}mm</span>
							
						</div>
						
						 <%}%>
							
					</div>
					
					 <%}%>
					
				</div>
			</div>
		</div>
		
		<br>
		
		 <%}%>
		
		
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