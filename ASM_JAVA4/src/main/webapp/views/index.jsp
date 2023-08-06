<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
	<title>UTUBE</title>

	<link rel="shortcut icon" href="/ASM_JAVA4/static/assets/img/DLogo.png">




<link rel="stylesheet" href="/ASM_JAVA4/static/assets/css/bootstrap.min.css">

<link rel="stylesheet"
	href="/ASM_JAVA4/static/assets/plugins/fontawesome/css/fontawesome.min.css">
<link rel="stylesheet"
	href="/ASM_JAVA4/static/assets/plugins/fontawesome/css/all.min.css">

<link rel="stylesheet" href="/ASM_JAVA4/static/assets/css/style.css">
<!--[if lt IE 9]>
			<script src="../static/assets/js/html5shiv.min.js"></script>
			<script src="../static/assets/js/respond.min.js"></script>
		<![endif]-->
</head>

<body>

	<div class="main-wrapper">
		<div class="header">
			<%@include file="layout/header.jsp"%>
		</div>
		<div class="sidebar" id="sidebar">
			<%@include file="layout/slidebar.jsp"%></div>
		<div class="page-wrapper"><jsp:include page="${ view }" /></div>
	</div>


	<script src="/ASM_JAVA4/static/assets/js/jquery-3.6.0.min.js"></script>

	<script src="/ASM_JAVA4/static/assets/js/popper.min.js"></script>
	<script src="/ASM_JAVA4/static/assets/js/bootstrap.min.js"></script>

	<script src="/ASM_JAVA4/static/assets/js/feather.min.js"></script>

	<script
		src="/ASM_JAVA4/static/assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<script src="/ASM_JAVA4/static/assets/plugins/apexchart/apexcharts.min.js"></script>
	<script src="/ASM_JAVA4/static/assets/plugins/apexchart/chart-data.js"></script>

	<script src="/ASM_JAVA4/static/assets/js/script.js"></script>
</body>

</html>