<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Search Results</title>
</head>
<body>
	
<fieldset id="tmdb">
<legend>TMDB search for <c:out value="${param.searchQuery}"/></legend>
<c:forEach items="${requestScope.movies}" var="movie">
	<span>Titulo pelicula: <c:out value="${movie.title}"/> (<c:out value="${movie.releaseDate}"/>)</span>
	<img src="https://image.tmdb.org/t/p/w600_and_h900_bestv2/${movie.posterPath}"/>
	<br /><br />
</c:forEach>

</fieldset>

<fieldset id="youtube">
<legend>Youtube search for <c:out value="${param.searchQuery}"/></legend>
<c:forEach items="${requestScope.items}" var="item">
	<iframe src="https://www.youtube.com/embed/<c:out value="${item.id.videoId}"/>"></iframe>
</c:forEach>

</fieldset>
<fieldset id="aliexpress">
		<legend>
			Resultados de búsqueda en AliExpress para 
			<c:out value="${param.searchQuery}" />
		</legend>
		<c:forEach items="${requestScope.products}" var="producto">
			<a target="_blank" href="<c:out value="${producto.productUrl}"/>">${producto.productTitle}</a>
			<img src="<c:out value = "${producto.imageUrl}"/>" height="314"
				width="350" />
			<br><br>
			<div style="text-align: center;">
			<span style="font-size: 24px; font-family: arial; color:#f60; font-weight: 700; align: center; "><c:out value="${producto.localPrice}"/></span>
			</div>
			<br>
			<br>
		</c:forEach>
	</fieldset>
	

</body>
</html>