<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <html>
    <head> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"> 
    <title>Produkty</title> 
     </head>  
      <body>
      <p>KRAKOW:</p>
      <p>${dataDzis} dzien :	<b> ${product.tempMaxNextDay}</b></p>
      <p>${dataDzis} noc:	 <b> ${product.tempMinNextDay}</b></p>
      <p>${dataDzis1} dzien:	<b> ${product.tempMaxSecondDay}</b></p>
      <p>${dataDzis1} noc:	<b> ${product.tempMinSecondDay}</b></p>
      <p>${dataDzis2} dzien:	<b> ${product.tempMaxThirdDay}</b></p>
      <p>${dataDzis2} noc:	 <b>${product.tempMinThirdDay}</b></p>
      <p>${dataDzis3} dzien:	<b> ${product.tempMaxFourthDay}</b></p>
      <p>${dataDzis3} noc:	<b> ${product.tempMinFourthDay}</b></p>
      
      </body>
                  
                 