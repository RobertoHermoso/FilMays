<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	  
Token:
	<p> <c:out value="${requestScope.token.requestToken} "/> <p>
	  <p><a href= "https://www.themoviedb.org/authenticate/<c:out value="${requestScope.token.requestToken}"/>?redirect_to=https://localhost:8090">
	   Logueate en TMDB </a></p>

</body>
</html>