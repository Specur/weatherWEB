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

    <title>Weather Project - Pogoda na weekend</title>

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

    <div class="hero" data-bg-image="<c:url value="/resources/images/weather.jpg" />">

    </div>


    <main class="main-content">
       
		
		<%!int outIndex;%>

		<%
			for (outIndex = 0; outIndex <= 2; outIndex++) {
		%>
		
		<div class="fullwidth-block weather-weekend-block">
            <div class="container">
            
            <% 
            if(outIndex == 0){
            %>
               <h2>Piątek - ${calendar["Piątek"]}</h2>
            <%	
            }
            %>
            <% 
            if(outIndex == 1){
            %>
               <h2>Sobota - ${calendar["Sobota"]}</h2>
            <%	
            }
            %>
            <% 
            if(outIndex == 2){
            %>
               <h2>Niedziela - ${calendar["Niedziela"]}</h2>
            <%	
            }
            %>
            </div>
        </div>
		
		<div class="forecast-table">
     
			<div class="container">
				 
			
				<div class="forecast-container" style="margin-top: -50px;">	
				

					<%!int index;%>

					<%
						for (index = outIndex*8; index <= (outIndex*8)+7; index++) {
				
					%>

					<c:set var="index" value="<%=index%>" />

					<div class="forecast">
						<div class="forecast-header">
						<% 
			            if(outIndex == 0){
			            %>
			               <div class="day">${hours[index]}</div>
			            <%	
			            }
			            %>
			            <% 
			            if(outIndex == 1){
			            %>
			               <div class="day">${hours[index-8]}</div>
			            <%	
			            }
			            %>
			            <% 
			            if(outIndex == 2){
			            %>
			               <div class="day">${hours[index-16]}</div>
			            <%	
			            }
			            %>
							
						</div>
						<!-- .forecast-header -->
						<div class="forecast-content">
						
							<div class="forecast-icon">

								

								<c:if
									test="${fn:contains(description[index], 'Zachmurzenie całkowite')}">
									<img src="<c:url value="/resources/images/icons/icon-6.svg" />"
										alt="" width=48>
								</c:if>
								<c:if
									test="${fn:contains(description[index], 'Pochmurno, słabe opady deszczu')}">
									<img src="<c:url value="/resources/images/icons/icon-4.svg" />"
										alt="" width=48>
								</c:if>
								<c:if
									test="${fn:contains(description[index], 'Bezchmurnie')}">
									<img src="<c:url value="/resources/images/icons/icon-2.svg" />"
										alt="" width=48>
								</c:if>

								<c:choose>
									<c:when test="${fn:contains(description[index], 'Pogodnie')}">

										<c:choose>
											<c:when
												test="${fn:contains(description[index], 'Pogodnie, okresami wzrost zachmurzenia do umiarkowanego')}">

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
									test="${fn:contains(description[index], 'Zachmurzenie małe, możliwe słabe opady deszczu')}">
									<img src="<c:url value="/resources/images/icons/icon-4.svg" />"
										alt="" width=48>
								</c:if>
								<c:if
									test="${fn:contains(description[index], 'Pochmurno z przejaśnieniami, słabe opady deszczu')}">
									<img src="<c:url value="/resources/images/icons/icon-4.svg" />"
										alt="" width=48>
								</c:if>
								<c:if
									test="${fn:contains(description[index], 'Pochmurno, okresami przejaśnienia')}">
									<img src="<c:url value="/resources/images/icons/icon-3.svg" />"
										alt="" width=48>
								</c:if>


							</div>
							<div class="degree">
								${temperature[index]}<sup>o</sup>C
							</div>
							<br> <span><img
								src="<c:url value="/resources/images/icon-wind.png" />" alt=""
								style="float: left;">${wind[index]}</span> <br> <span><img
								src="<c:url value="/resources/images/icon-compass.png" />"
								alt="" style="float: left;">${pressure[index]}</span>
						</div>
					</div>

					<%
						}
					%>

				</div>
			</div>
		</div>
		
		<%
			}
		%>
		
		<style>
		
		.weather-weekend-block:not(:first-child){
			padding-top:0!important;
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

