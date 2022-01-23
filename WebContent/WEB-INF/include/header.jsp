<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Galerie ESP</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Abril+Fatface&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

	<link rel="stylesheet" href="css/animate.css">
	
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">
	<link rel="stylesheet" href="css/magnific-popup.css">

	
	<link rel="stylesheet" href="css/flaticon.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/popup_style.css">
</head>
<body>

	<div id="colorlib-page">
		<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
		<aside id="colorlib-aside" role="complementary" class="js-fullheight">

			<h1 id="colorlib-logo" class="mb-4 mb-md-5">Galerie ESP</h1>
			<nav id="colorlib-main-menu" role="navigation">
				<ul>
					
					<li class=""><a href="<c:url value="/"/>">Accueil</a></li>
					<c:choose>
      				<c:when test="${ !empty sessionScope.admin }">
      					<li><a href="<c:url value="/listUser"/>">lister Users</a></li>
      					<li><a href="<c:url value="/listAlbum"/>">lister tous les albums</a></li>
      					<li><a href="<c:url value="/listerAlbum?id=${sessionScope.admin.id }"/>">lister mes albums</a></li>
      					<li><a href="<c:url value="/logout"/>">Se déconnecter</a></li>
      				</c:when>
      				<c:when test="${ !empty sessionScope.simple }">
      					<li><a href="<c:url value="/listerAlbum?id=${ sessionScope.simple.id }"/>">lister mes albums</a></li>
      					<li><a href="<c:url value="/logout"/>">Se déconnecter</a></li>
      				</c:when>
					<c:otherwise>
					<li><a href="<c:url value="/login"/>">Se connecter</a></li>
					<li><a href="<c:url value="/register"/>">S'abonner</a></li>
					</c:otherwise>
    			</c:choose>
				</ul>
			</nav>
</aside> <!-- END COLORLIB-ASIDE -->