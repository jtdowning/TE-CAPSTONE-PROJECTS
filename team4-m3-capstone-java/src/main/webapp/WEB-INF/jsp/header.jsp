<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
	<title>National Park Geek</title>
    <c:url value="/css/nationalPark.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
    <link href="https://fonts.googleapis.com/css?family=Arvo" rel="stylesheet">
</head>
<body>
	<header>
		<div>
			<c:url var ="logoImgSrc" value = "/img/logo.png"/>
			<img class="parkImage" src ="${logoImgSrc}" alt = "National Park Geek"/>		
		</div>
		<nav>
			<ul>
				<li><a href="/m3-capstone-java/">Home</a></li>
				<li><a href="/m3-capstone-java/survey">Survey</a></li>
			</ul>
		</nav>
	</header>
	
