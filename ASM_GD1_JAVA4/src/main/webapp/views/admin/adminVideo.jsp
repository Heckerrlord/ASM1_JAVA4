<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>Dleohr - Bootstrap Admin HTML Template</title>

<link rel="shortcut icon" href="../static/assets/img/favicon.png">

<link rel="stylesheet" href="../static/assets/css/bootstrap.min.css">

<link rel="stylesheet"
	href="../static/assets/plugins/fontawesome/css/fontawesome.min.css">
<link rel="stylesheet"
	href="../static/assets/plugins/fontawesome/css/all.min.css">

<link rel="stylesheet" href="../static/assets/css/style.css">
<!--[if lt IE 9]>
			<script src="../static/assets/js/html5shiv.min.js"></script>
			<script src="../static/assets/js/respond.min.js"></script>
		<![endif]-->
</head>

<body>

	<div class="main-wrapper">
		<div class="header">
			<div class="header-left">
				<a href="http://localhost:8080/ASM_GD1_JAVA4/index" class="logo"> <img
					src="../static/assets/img/logo.png" alt="Logo">
				</a> <a href="http://localhost:8080/ASM_GD1_JAVA4/index" class="logo logo-small"> <img
					src="../static/assets/img/logo-small.png" alt="Logo" width="30"
					height="30">
				</a> <a href="javascript:void(0);" id="toggle_btn"> <span
					class="bar-icon"> <span></span> <span></span> <span></span>
				</span>
				</a>
			</div>
			<div class="top-nav-search">
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
							src="../static/assets/img/profile.jpg" alt=""> <span
							class="status online"></span>
					</span> <span>Kavin Hansen</span>
				</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="profile.html"><i
							data-feather="user" class="mr-1"></i> Profile</a> <a
							class="dropdown-item" href="settings.html"><i
							data-feather="settings" class="mr-1"></i> Settings</a> <a
							class="dropdown-item" href="login.html"><i
							data-feather="log-out" class="mr-1"></i> Logout</a>
					</div></li>

			</ul>
			<div class="dropdown mobile-user-menu show">
				<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown"
					aria-expanded="false"><i class="fa fa-ellipsis-v"></i></a>
				<div class="dropdown-menu dropdown-menu-right ">
					<a class="dropdown-item" href="profile.html">My Profile</a> <a
						class="dropdown-item" href="settings.html">Settings</a> <a
						class="dropdown-item" href="login.html">Logout</a>
				</div>
			</div>
		</div>
		<div class="sidebar" id="sidebar">
			<div class="sidebar-inner slimscroll">
				<div class="sidebar-contents">
					<div id="sidebar-menu" class="sidebar-menu">
						<div class="mobile-show">
							<div class="offcanvas-menu">
								<div class="user-info align-center bg-theme text-center">
									<span class="lnr lnr-cross  text-white" id="mobile_btn_close">X</span>
									<a href="javascript:void(0)"
										class="d-block menu-style text-white">
										<div class="user-avatar d-inline-block mr-3">
											<img src="../static/assets/img/profiles/avatar-18.jpg"
												alt="user avatar" class="rounded-circle" width="50">
										</div>
									</a>
								</div>
							</div>
							<div class="sidebar-input">
								<div class="top-nav-search">
									<form>
										<input type="text" class="form-control"
											placeholder="Search here">
										<button class="btn" type="submit">
											<i class="fas fa-search"></i>
										</button>
									</form>
								</div>
							</div>
						</div>
						<ul>
							<li class="active"><a
								href="http://localhost:8080/ASM_GD1_JAVA4/admin/home"><img
									src="../static/assets/img/home.svg" alt="sidebar_img"> <span>Dashboard</span></a>
							</li>
							<li><a href="http://localhost:8080/ASM_GD1_JAVA4/admin/user"><img
									src="../static/assets/img/employee.svg" alt="sidebar_img"><span>
										User</span></a></li>
							<li><a
								href="http://localhost:8080/ASM_GD1_JAVA4/admin/video"><img
									src="../static/assets/img/manage.svg" alt="sidebar_img">
									<span>Video</span></a></li>

						</ul>
						<ul class="logout">
							<li><a href="profile.html"><img
									src="../static/assets/img/logout.svg" alt="sidebar_img"><span>Log
										out</span></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>


		<div class="page-wrapper">
			<div class="content container-fluid">
				<div class="page-name 	mb-4">
					<h4 class="m-0">Quản lý video</h4>
					<h5>${a}</h5>
				</div>
				<form>

					<label for="inputId">ID</label> <input type="text"
						class="form-control" id="inputId" placeholder="Enter ID">


					<label for="inputTitle">Title</label> <input type="text"
						class="form-control" id="inputTitle" placeholder="Enter Title">

					<label for="inputPoster">Poster</label> <input type="text"
						class="form-control" id="inputPoster"
						placeholder="Enter Poster URL"> <label for="inputViews">Views</label>
					<input type="number" class="form-control" id="inputViews"
						placeholder="Enter Views"> <label for="inputDescription">Description</label>
					<textarea class="form-control" id="inputDescription" rows="3"
						placeholder="Enter Description"></textarea>

					<input type="submit" class="btn btn-success" value="Create" /> <input
						type="submit" class="btn btn-success" value="Update" />
				</form>

				<div class="row">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Title</th>
								<th scope="col">Poster</th>
								<th scope="col">Views</th>
								<th scope="col">Description</th>
								<th scope="col">Edit</th>
								<th scope="col">Un active</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${videoList}" var="item">
								<tr>
									<th>${item.id}</th>
									<td>${item.title}</td>
									<td>${item.poster}</td>
									<td>${item.views}</td>
									<td>${item.description}</td>
									<td><a class="btn btn-success">Edit</a></td>
									<td><a class="btn btn-danger">X</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
		</div>

	</div>


	<script src="../static/assets/js/jquery-3.6.0.min.js"></script>

	<script src="../static/assets/js/popper.min.js"></script>
	<script src="../static/assets/js/bootstrap.min.js"></script>

	<script src="../static/assets/js/feather.min.js"></script>

	<script
		src="../static/assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<script src="../static/assets/plugins/apexchart/apexcharts.min.js"></script>
	<script src="../static/assets/plugins/apexchart/chart-data.js"></script>

	<script src="../static/assets/js/script.js"></script>
</body>

</html>