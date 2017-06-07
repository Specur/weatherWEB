<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> ${szczyt} - prognoza pogody</title>
</head>
<body>
<tr>
            Nazwa szczytu:
            <td>${szczyt}</td>
             
           
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
         
</body>
</html>