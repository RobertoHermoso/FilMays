<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Muestra de canciones</title>
</head>
<body>

<c:if test='${empty sessionScope["Spotify-token"]}'>
	   <c:redirect url = "/AuthController/Spotify"/>
	</c:if>
	
<h1>Canciones de Spotify</h1>
<c:forEach items="${requestScope.Tracks.tracks.items}" var="item" begin="1" end= "1">
<iframe src="https://open.spotify.com/embed?uri=spotify:album:<c:out value="${item.album.id}"/>" width="300" height="380" frameborder="0" allowtransparency="true" allow="encrypted-media"></iframe>

</c:forEach>
</body>
</html>