<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Witaj!
</br>
Prosze o wpisanie nazwy miejscowosci:</br>
<form:form modelAttribute="city" class="form-horizontal"> 
<form:input id="name" path="name" type="text" class="form:input-large"/> 
<input type="submit" id="btnAdd" class="btn btn-primary" value ="Dodaj"/> 
 </form:form> 
 
 Smog w Krakowie:</br>
Al. Krasinskiego	${Sensor1}  g/m3	</br>
ul. Bulwarowa		${Sensor2}  g/m3</br>
ul. Bujaka			${Sensor3}  g/m3</br>
ul. Dietla			${Sensor4}  g/m3</br>
os. Piastow			${Sensor5}  g/m3</br>
ul. Zloty Rog		${Sensor6}  g/m3</br>
</body>
</html>