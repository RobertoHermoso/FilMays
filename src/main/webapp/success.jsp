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

<%@include file="head.jsp"%>

	
<fieldset id="tmdb">
<legend>Resultados de TMDB para <c:out value="${param.searchQuery}" /></legend>
<h1>	<span> <c:out value="${requestScope.movies.title}"/> (<c:out value="${requestScope.movies.releaseDate}"/>)</span> </h1>	
	<img src="https://image.tmdb.org/t/p/w600_and_h900_bestv2/${requestScope.movies.posterPath}"/>
	<br /><br />
<h2>	Descripción: </h2>
<p> <c:out value="${requestScope.movies.overview}"/> </p>
	
<h2>Trailer</h2>
<c:forEach items="${requestScope.items}" var="item">
	<iframe src="https://www.youtube.com/embed/<c:out value="${item.id.videoId}"/>"></iframe>
</c:forEach>
</fieldset>

	<fieldset>
	<legend>Banda sonora de <c:out value="${param.searchQuery}" /> </legend>
	<form  id="addTrackForm" action="/AddTrackController" method="post">
	<h2>Seleccione la playlist en donde desee añadir la canción </h2>
			<select name="plId">
	<c:forEach items="${requestScope.pl.items}" var="plu">
    				<option class="formPL" value="<c:out value="${plu.id}"/>"> <c:out value="${plu.name}"/></option>
    			</c:forEach>
    		</select> <br> <br>
    		
<c:forEach items="${requestScope.Tracks.tracks.items}" var="track">
<iframe src="https://open.spotify.com/embed?uri=spotify:track:<c:out value="${track.id}"/>" width="300" height="100" frameborder="0" allowtransparency="true" allow="encrypted-media"></iframe>
<input class="formPL" type="radio" name="songId" value="<c:out value="${track.id}"/>"> <br><br>
	</c:forEach>
 <input type="hidden" name="userId" value="<c:out value="${requestScope.User.id}"/>">	
 <input type="submit" value="Añadir">
	</form>
	
	</fieldset>

<fieldset id="aliexpress">
		<legend>
			Productos de  
			<c:out value="${param.searchQuery}" />
		</legend>
		<c:forEach items="${requestScope.products}" var="producto" begin="1" end="5">
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