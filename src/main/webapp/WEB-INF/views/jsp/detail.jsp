<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/core/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/core/css/detail.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/core/css/menu.css" />
<script src="${pageContext.request.contextPath}/resources/core/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/core/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<div class="container-full">
        <ul class="menu">
            <li class="active"><a href="ShowHomePage">Home </a></li>
            <li><a href="ShowDetail">Detail</a></li>
            <li><a href="contact">Contact</a></li>
            <li><a href="about">About</a></li>
        </ul>


        <div class="row">
            <div class="col-sm-4 left-container">
                <p>MUSIC TREND WEEKLY</p>
                <h1>(Song: ${name})</h1>
                <ul class="detail">
                    <li>Monday : ${data[0].info[0].percent}%</li>
                    <li>Tuesday : ${data[1].info[0].percent}%</li>
                    <li>Wednesday : ${data[2].info[0].percent}%</li>
                    <li>Thusday : ${data[3].info[0].percent}%</li>
                    <li>Friday : ${data[4].info[0].percent}%</li>
                    <li>Satuday : ${data[5].info[0].percent}%</li>
                    <li>Sunday: ${data[6].info[0].percent}%</li>
                </ul>
            </div>

            <div class="col-sm-6 chart">
                <div class="bargraph">
                    <ul class="bars">
                        <li class="bar1 crimsonbar" style="height: ${data[0].info[1].height}px;">${data[0].info[0].percent}</li>
                        <li class="bar2 redbar" style="height: ${data[1].info[1].height}px;;">${data[1].info[0].percent}</li>
                        <li class="bar3 greenbar" style="height: ${data[2].info[1].height}px;;">${data[2].info[0].percent}</li>
                        <li class="bar4 orangebar" style="height: ${data[3].info[1].height}px;;">${data[3].info[0].percent}</li>
                        <li class="bar5 bluebar" style="height: ${data[4].info[1].height}px;">${data[4].info[0].percent}</li>
                        <li class="bar6 purplebar" style="height: ${data[5].info[1].height}px;">${data[5].info[0].percent}</li>
                        <li class="bar7 tealbar" style="height: ${data[6].info[1].height}px;">${data[6].info[0].percent}</li>
                    </ul>
                    <ul class="label">
                        <li>Monday</li>
                        <li>Tuesday</li>
                        <li>Wednesday</li>
                        <li>Thusday</li>
                        <li>Friday</li>
                        <li>Satuday</li>
                        <li>Sunday</li>

                    </ul>
                    <ul class="y-axis">
                        <li>100</li>
                        <li>75</li>
                        <li>50</li>
                        <li>25</li>
                        <li>0</li>
                    </ul>
                    <p class="centered">${name}</p>
                </div>
            </div>

             <div class="thumbnail">
                <a class="back-button" href="ShowHomePage"> <img
                    src="../resources/core/images/back home.png">
                </a>
            </div> 
        </div>
    </div>


</body>
</html>