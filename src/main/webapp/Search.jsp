<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Intento de busqueda con Spotify</title>
</head>
<body>
<h1>Busqueda con Spotify</h1>
<c:if test='${empty sessionScope["Spotify-token"]}'>
	   <c:redirect url = "/AuthController/Spotify"/>
	</c:if>
 <div id="searchDiv">
		<form id="searchForm" action="SearchController" method="post">
			Busqueda: <input type="text" name="searchQuery" required/> 
			<input type="submit" name="searchBtn" title="search" value="search">
		</form>
	</div>
</body>
<tr><th>Spotify token:<th><td><c:out value='${sessionScope["Spotify-token"]}' />
</html>