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

<title> ${szczyt} - prognoza pogody</title>

<!-- Loading third party fonts -->
<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/fonts/font-awesome.min.css" />" rel="stylesheet" type="text/css">


<!-- Loading main css file -->
<link href="<c:url value="/resources/style.css" />" rel="stylesheet">

</head>


<body>

	<div class="site-content">
		<div class="site-header">
			<div class="container">
				<a href="index.html" class="branding"> <img
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
							<li class="menu-item"><a href="#">Pogoda na weekend</a></li>
						<li class="menu-item"><a href="<c:url value="/smogkrakow" />">Smog Kraków</a></li>
						<li class="menu-item"><a href="#">Kontakt</a></li>
					</ul>
					<!-- .menu -->
				</div>
				<!-- .main-navigation -->

				<div class="mobile-navigation"></div>

			</div>
		</div>
		<!-- .site-header -->

		
		<main class="main-content">
		<div class="fullwidth-block">
			<div class="container">
				<h2 class="section-title">${szczyt}</h2>
             
           
         </tr>
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
					</div>

			</div>
		</div>

		<div class="fullwidth-block" data-bg-color="#262936">
			<div class="container">
				<div class="row">
					<div class="col-md-4">
						<div class="news">
							<div class="date">06.10</div>
							<h3>
								<a href="#">Doloremque laudantium totam sequi </a>
							</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
								Illo saepe assumenda dolorem modi, expedita voluptatum ducimus
								necessitatibus. Asperiores quod reprehenderit necessitatibus
								harum, mollitia, odit et consequatur maxime nisi amet
								doloremque.</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="news">
							<div class="date">06.10</div>
							<h3>
								<a href="#">Doloremque laudantium totam sequi </a>
							</h3>
							<p>Nobis architecto consequatur ab, ea, eum autem aperiam
								accusantium placeat vitae facere explicabo temporibus minus
								distinctio cum optio quis, dignissimos eius aspernatur fuga.
								Praesentium totam, corrupti beatae amet expedita veritatis.</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="news">
							<div class="date">06.10</div>
							<h3>
								<a href="#">Doloremque laudantium totam sequi </a>
							</h3>
							<p>Enim impedit officiis placeat qui recusandae doloremque
								possimus, iusto blanditiis, quam optio delectus maiores.
								Possimus rerum, velit cum natus eos. Cumque pariatur beatae
								asperiores, esse libero quas ad dolorem. Voluptates.</p>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="fullwidth-block">
			<div class="container">
				<div class="row">
					<div class="col-md-4">
						<h2 class="section-title">Application features</h2>
						<ul class="arrow-feature">
							<li>
								<h3>Natus error sit voluptatem accusantium</h3>
								<p>Doloremque laudantium totam rem aperiam Inventore
									veritatis et quasi architecto beatae vitae.</p>
							</li>
							<li>
								<h3>Natus error sit voluptatem accusantium</h3>
								<p>Doloremque laudantium totam rem aperiam Inventore
									veritatis et quasi architecto beatae vitae.</p>
							</li>
							<li>
								<h3>Natus error sit voluptatem accusantium</h3>
								<p>Doloremque laudantium totam rem aperiam Inventore
									veritatis et quasi architecto beatae vitae.</p>
							</li>
						</ul>
					</div>
					<div class="col-md-4">
						<h2 class="section-title">Weather analyssis</h2>
						<ul class="arrow-list">
							<li><a href="#">Accusantium doloremque laudantium rem
									aperiam</a></li>
							<li><a href="#">Eaque ipsa quae ab illo inventore
									veritatis quasi</a></li>
							<li><a href="#">Architecto beatae vitae dicta sunt
									explicabo</a></li>
							<li><a href="#">Nemo enim ipsam voluptatem quia voluptas</a></li>
							<li><a href="#">Aspernatur aut odit aut fugit, sed quia
									consequuntur</a></li>
							<li><a href="#">Magni dolores eos qui ratione voluptatem
									sequi</a></li>
							<li><a href="#">Neque porro quisquam est qui dolorem
									ipsum quia</a></li>
						</ul>
					</div>
					<div class="col-md-4">
						<h2 class="section-title">Awesome Photos</h2>
						<div class="photo-grid">
							<a href="#"><img src="images/thumb-1.jpg" alt="#"></a> <a
								href="#"><img src="images/thumb-2.jpg" alt="#"></a> <a
								href="#"><img src="images/thumb-3.jpg" alt="#"></a> <a
								href="#"><img src="images/thumb-4.jpg" alt="#"></a> <a
								href="#"><img src="images/thumb-5.jpg" alt="#"></a> <a
								href="#"><img src="images/thumb-6.jpg" alt="#"></a> <a
								href="#"><img src="images/thumb-7.jpg" alt="#"></a> <a
								href="#"><img src="images/thumb-8.jpg" alt="#"></a> <a
								href="#"><img src="images/thumb-9.jpg" alt="#"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		</main>
		<!-- .main-content -->

		<footer class="site-footer">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<form method="post" action="https://app.freshmail.com/pl/actions/subscribe/" class="subscribe-form">
						<input type="hidden" name="subscribers_list_hash" value="jk7c4b1rd5" />
						<input type="text" id="freshmail_email" name="freshmail_email" placeholder="Wpisz email, aby zapisać się do newslettera..."/>
						<input type="submit" value="Zapisz mnie!" />
					</form>
				</div>
				<div class="col-md-3 col-md-offset-1">
					<div class="social-links">
						<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
							class="fa fa-twitter"></i></a> <a href="#"><i
							class="fa fa-google-plus"></i></a> <a href="#"><i
							class="fa fa-pinterest"></i></a>
					</div>
				</div>
			</div>

			<p class="colophon">Copyright &copy; 2017 Weather Team Project. All rights reserved</p>
		</div>
		</footer>
		<!-- .site-footer -->
	</div>

	<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/plugins.js" />"></script>
	<script src="<c:url value="/resources/js/app.js" />"></script>

</body>

</html>