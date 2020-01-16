<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mappa</title>

	<script src="https://www.w3schools.com/lib/w3.js"></script>
	
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<script src="js/map.js"></script>
	<script src="bootstrap/js/jquery-3.4.1.js"></script>
	<script src="bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="bootstrap/js/bootstrap.bundle.min.js"></script>

	<link rel="stylesheet" href="css/map.css">
	<link rel="stylesheet" href="css/menuBar.css">
	
</head>
<body>

	<div w3-include-html="menuBar.jsp"></div>
	<script>w3.includeHTML();</script>
	
	<div id="googleMap" action="myMap"></div>

	
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDoq-xsFhUtC3ucI3N5wH0KVVhVJZvNa68&callback=myMap"></script>
	
	

</body>
</html>