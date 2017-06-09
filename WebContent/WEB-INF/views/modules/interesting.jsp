<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="fullwidth-block">
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<h2 class="section-title">Zalety WeatherProject</h2>
				<ul class="arrow-feature">
					<li>
						<h3>Aktualne dane</h3>
						<p>Pokazujemy zawsze najnowsze, zaktualizowane dane, które są pobierane z róznych serwisów internetowych.</p>
					</li>
					<li>
						<h3>Nowoczesne technologie</h3>
						<p>Nasz projekt został napisany z użyciem takich technologii jak: Java, Spring MVC, JSP, HTML5, CSS, Javascript.</p>
					</li>
					<li>
						<h3>Nowoczesny design</h3>
						<p>Strona została zaprojektowana z użyciem najnowszych trendów webdesignu w technologii RWD.</p>
					</li>
				</ul>
			</div>
			<div class="col-md-4">
				<h2 class="section-title">Ciekawe linki</h2>
				<ul class="arrow-list">
					<li><a href="http://pogodynka.pl">Pogodynka.pl</a></li>
					<li><a href="http://www.weatheronline.pl">Weather Online</a></li>
					<li><a href="http://powietrzewkrakowie.pl">Powietrze w Krakowie</a></li>
					<li><a href="http://lowcyburz.pl">Łowcy burz</a></li>
					<li><a href="http://www.twojapogoda.pl/tematyczne/dla-alergikow">Prognoza dla alergików</a></li>
					<li><a href="http://www.lightningmaps.org/?lang=pl">Wyładowania na żywo</a></li>
					<li><a href="https://www.flightradar24.com">FlightRadar24</a></li>
				</ul>
			</div>
			<div class="col-md-4">
				<h2 class="section-title">Zdjęcia</h2>
				<div class="photo-grid">
					<a href="<c:url value="/resources/images/thumb-1.jpg" />" data-lightbox="weather"><img src="<c:url value="/resources/images/thumb-1.jpg" />" alt="#"></a>
					<a href="<c:url value="/resources/images/thumb-1.jpg" />" data-lightbox="weather"><img src="<c:url value="/resources/images/thumb-1.jpg" />" alt="#"></a>
					<a href="<c:url value="/resources/images/thumb-1.jpg" />" data-lightbox="weather"><img src="<c:url value="/resources/images/thumb-1.jpg" />" alt="#"></a>
					<a href="<c:url value="/resources/images/thumb-1.jpg" />" data-lightbox="weather"><img src="<c:url value="/resources/images/thumb-1.jpg" />" alt="#"></a>
					<a href="<c:url value="/resources/images/thumb-1.jpg" />" data-lightbox="weather"><img src="<c:url value="/resources/images/thumb-1.jpg" />" alt="#"></a>
					<a href="<c:url value="/resources/images/thumb-1.jpg" />" data-lightbox="weather"><img src="<c:url value="/resources/images/thumb-1.jpg" />" alt="#"></a>
					<a href="<c:url value="/resources/images/thumb-1.jpg" />" data-lightbox="weather"><img src="<c:url value="/resources/images/thumb-1.jpg" />" alt="#"></a>
					<a href="<c:url value="/resources/images/thumb-1.jpg" />" data-lightbox="weather"><img src="<c:url value="/resources/images/thumb-1.jpg" />" alt="#"></a>
					<a href="<c:url value="/resources/images/thumb-1.jpg" />" data-lightbox="weather"><img src="<c:url value="/resources/images/thumb-1.jpg" />" alt="#"></a>
				</div>
			</div>
		</div>
	</div>
</div>