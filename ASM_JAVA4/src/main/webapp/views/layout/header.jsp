<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" href="https://kit.fontawesome.com/a7a43ca69d.css" />

<link rel="shortcut icon" href="../static/assets/img/favicon.png">

<link rel="stylesheet" href="../static/assets/css/bootstrap.min.css">

<link rel="stylesheet"
	href="../static/assets/plugins/fontawesome/css/fontawesome.min.css">
<link rel="stylesheet"
	href="../static/assets/plugins/fontawesome/css/all.min.css">

<link rel="stylesheet" href="../static/assets/css/style.css">

<div class="header-left">
	<a href="index.html" class="logo">
		<p style="font-size: large; font-weight: 800;">
			<img src="/ASM_JAVA4/static/assets/img/D.png" alt="">UTUBE
		</p>
	</a> <a href="index.html" class="logo logo-small"> <img
		src="/ASM_JAVA4/static/assets/img/D.png" alt="">

	</a> <a href="javascript:void(0);" id="toggle_btn"> <span
		class="bar-icon"> <span></span> <span></span> <span></span>
	</span>
	</a>
</div>
<div class="top-nav-search	">

	<form>
		<input type="text" class="form-control" placeholder="">
		<button class="btn" type="submit">
			<i class="fas fa-search"></i>
		</button>
	</form>

</div>
<a class="mobile_btn" id="mobile_btn"> <i class="fas fa-bars"></i>
</a>
<ul class="nav user-menu">
	<li class="nav-item dropdown has-arrow main-drop"><a href="#"
		class="dropdown-toggle nav-link" data-toggle="dropdown"> <span
			class="user-img"> <img
				src="/ASM_JAVA4/static/assets/img/profile.jpg" alt=""> <span
				class="status online"></span>
		</span> <span>${sessionScope.currentUser.id}</span>
	</a>
		<div class="dropdown-menu">
			<a class="dropdown-item"
				href="http://localhost:8080/ASM_JAVA4/user/profile"><i
				data-feather="user" class="mr-1"></i> Profile</a>
			<c:if test="${sessionScope.currentUser.admin == true}">
				<a class="dropdown-item"
					href="http://localhost:8080/ASM_JAVA4/admin/home"><i
					data-feather="settings" class="mr-1"></i> Admin Tools</a>
			</c:if>

			<a class="dropdown-item"
				href="http://localhost:8080/ASM_JAVA4/logout"><i
				data-feather="log-out" class="mr-1"></i> Logout</a>

		</div></li>

</ul>
<div class="dropdown mobile-user-menu show">
	<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown"
		aria-expanded="false"><i class="fa fa-ellipsis-v"></i></a>
	<div class="dropdown-menu dropdown-menu-right ">
		<a class="dropdown-item"
			href="http://localhost:8080/ASM_JAVA4/user/profile">My Profile</a>
		<c:if test="${sessionScope.currentUser.admin == true}">
			<a class="dropdown-item"
				href="http://localhost:8080/ASM_JAVA4/admin/home"><i
				data-feather="settings" class="mr-1"></i> Admin Tools</a>
		</c:if>
		<a class="dropdown-item" href="http://localhost:8080/ASM_JAVA4/logout">Logout</a>
	</div>
</div>
