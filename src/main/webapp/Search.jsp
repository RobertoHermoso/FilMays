<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>	
<title>Busqueda de peliculas</title>
</head>
<body>

<%@include file="head.jsp"%>

<h1>Busqueda de peliculas</h1>

<c:if test='${empty sessionScope["Spotify-token"]}'>
	   <c:redirect url = "/AuthController/Spotify"/>
	</c:if>
	
 <fieldset id="tmdb">
<legend>Resultados con: <c:out value="${param.searchQuery}"/></legend>
<c:forEach items="${requestScope.movies}" var="movie">
	<form id="searchForm" method="post" class="listaForm" action="/SelectedMovieController">
	<input type='hidden' name='searchQuery' value="<c:out value="${movie.title}"/>" />
	<input type='hidden' name='id' value="<c:out value="${movie.id}"/>" />
	<span>Titulo pelicula: <input type="submit" class="tituloEnviar" name="titulo" value="<c:out value="${movie.title}"/>" />(<c:out value="${movie.releaseDate}"/>) </span><br /><br />
	<img src="https://image.tmdb.org/t/p/w600_and_h900_bestv2/${movie.posterPath}"/>
	<br /><br />
	</form>
</c:forEach>
 </fieldset>
</body>

</html>