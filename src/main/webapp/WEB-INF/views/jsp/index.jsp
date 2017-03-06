<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title> Music trend</title>
</head>
<body>
	<h1> WELCOME TO THESIS MUSIC TREND, PLEASE CHOICE YOUR OPTION </h1>
	
	<form method="GET" action="${pageContext.request.contextPath}/Service/ShowHomePage">
		<button type="submit"> Show Home Page !</button>
	</form>
	
	<form method="GET" action="${pageContext.request.contextPath}/Service/UpdateTop100ZingSong">
		<button type="submit"> Get data !</button>
	</form>
	
	<form method="GET" action="${pageContext.request.contextPath}/Service/UpdateTotalListener">
		<button type="submit"> Update total listener !</button>
	</form>

	

</body>
</html>