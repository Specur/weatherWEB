<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
              <link rel="stylesheet"     
              href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
                    <title>Witaj</title>
                       </head>
     <body>  
                     <section>  
    							 <div class="jumbotron"> <div class="container">
  								    <h1> ${greeting} </h1> 
  							   	 </div>
  							    Aby przejsc do strony z pogoda kiknij ten przycisk:
  							    
  	 <button onclick="location.href='http://localhost:8080/spring-webmvc/products';">;)</button>
      							 </div>  
           			</section>
           			
           			
     </body> 
</html>