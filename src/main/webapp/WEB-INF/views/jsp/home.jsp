<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/core/css/home.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/core/css/menu.css" />
<title>Insert title here</title>
</head>
<body>
	
	<h1 class="title">MUSIC TREND</h1>
	<ul class="menu">
		<li class="active"><a href="home.jsp">Home </a></li>
		<li><a href="detail">News</a></li>
		<li><a href="contact">Contact</a></li>
		<li><a href="about">About</a></li>
	</ul>
	<div class="musicContent">
		<c:forEach var="item" items="${songData}" varStatus="loop">
			<ul class="favoriteSong">
				<li>
					<div class="albumCover">
						<a href="${item.songItem[2].link}" target="_blank"> 
						      <img src="${item.songItem[3].src}" />
						      <span class="iconPlay"> </span>
						</a> 
					</div>
					<span class="viewNumber"> </span>
					<div class="info">
						<a href="${item.songItem[4].link}"> ${item.songItem[1].name} </a>
						<p class="artirst">${item.songItem[4].artirst}</p>
						<a href="detail?id=${item.songItem[0].id}"> trend song detail >> </a>
					</div>
				</li>
			</ul>

		</c:forEach>
	</div>
</body>
</html>