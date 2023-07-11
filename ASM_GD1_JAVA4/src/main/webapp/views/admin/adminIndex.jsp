<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
	<title>Dleohr - Bootstrap Admin HTML Template</title>

	<link rel="shortcut icon" href="../static/assets/img/favicon.png">

	<link rel="stylesheet" href="../static/assets/css/bootstrap.min.css">

	<link rel="stylesheet" href="../static/assets/plugins/fontawesome/css/fontawesome.min.css">
	<link rel="stylesheet" href="../static/assets/plugins/fontawesome/css/all.min.css">

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
				<a href="http://localhost:8080/ASM_GD1_JAVA4/index" class="logo">
					<img src="../static/assets/img/logo.png" alt="Logo">
				</a>
				<a href="http://localhost:8080/ASM_GD1_JAVA4/index" class="logo logo-small">
					<img src="../static/assets/img/logo-small.png" alt="Logo" width="30" height="30">
				</a>
				<a href="javascript:void(0);" id="toggle_btn">
					<span class="bar-icon">
						<span></span>
						<span></span>
						<span></span>
					</span>
				</a>
			</div>
			<div class="top-nav-search">
				<form>
					<input type="text" class="form-control" placeholder="">
					<button class="btn" type="submit"><i class="fas fa-search"></i></button>
				</form>
			</div>
			<a class="mobile_btn" id="mobile_btn">
				<i class="fas fa-bars"></i>
			</a>
			<ul class="nav user-menu">
				<li class="nav-item dropdown has-arrow main-drop">
					<a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
						<span class="user-img">
							<img src="../static/assets/img/profile.jpg" alt="">
							<span class="status online"></span>
						</span>
						<span>Kavin Hansen</span>
					</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="profile.html"><i data-feather="user" class="mr-1"></i>
							Profile</a>
						<a class="dropdown-item" href="settings.html"><i data-feather="settings" class="mr-1"></i>
							Settings</a>
						<a class="dropdown-item" href="login.html"><i data-feather="log-out" class="mr-1"></i>
							Logout</a>
					</div>
				</li>

			</ul>
			<div class="dropdown mobile-user-menu show">
				<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i
						class="fa fa-ellipsis-v"></i></a>
				<div class="dropdown-menu dropdown-menu-right ">
					<a class="dropdown-item" href="profile.html">My Profile</a>
					<a class="dropdown-item" href="settings.html">Settings</a>
					<a class="dropdown-item" href="login.html">Logout</a>
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
									<a href="javascript:void(0)" class="d-block menu-style text-white">
										<div class="user-avatar d-inline-block mr-3">
											<img src="../static/assets/img/profiles/avatar-18.jpg" alt="user avatar"
												class="rounded-circle" width="50">
										</div>
									</a>
								</div>
							</div>
							<div class="sidebar-input">
								<div class="top-nav-search">
									<form>
										<input type="text" class="form-control" placeholder="Search here">
										<button class="btn" type="submit"><i class="fas fa-search"></i></button>
									</form>
								</div>
							</div>
						</div>
						<ul>
							<li class="active">
								<a href="http://localhost:8080/ASM_GD1_JAVA4/admin/home"><img src="../static/assets/img/home.svg" alt="sidebar_img">
									<span>Dashboard</span></a>
							</li>
							<li>
								<a href="http://localhost:8080/ASM_GD1_JAVA4/admin/user"><img src="../static/assets/img/employee.svg" alt="sidebar_img"><span>
										User</span></a>
							</li>
							<li>
								<a href="http://localhost:8080/ASM_GD1_JAVA4/admin/video"><img src="../static/assets/img/manage.svg" alt="sidebar_img">
									<span>Video</span></a>
							</li>
							
						</ul>
						<ul class="logout">
							<li>
								<a href="profile.html"><img src="../static/assets/img/logout.svg" alt="sidebar_img"><span>Log
										out</span></a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>


		<div class="page-wrapper">
			<div class="content container-fluid">
				<div class="page-name 	mb-4">
					<h4 class="m-0"><img src="../static/assets/img/profile.jpg" class="mr-1" alt="profile" /> Welcome Admin</h4>
					<label>${a}</label>
				</div>
				
				<div class="row mb-4">
					<div class="col-xl-3 col-sm-6 col-12">
						<div class="card board1 fill1 ">
							<div class="card-body">
								<div class="card_widget_header">
									<label>Employees</label>
									<h4>700</h4>
								</div>
								<div class="card_widget_img">
									<img src="../static/assets/img/dash1.png" alt="card-img" />
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 col-12">
						<div class="card board1 fill2 ">
							<div class="card-body">
								<div class="card_widget_header">
									<label>Companies</label>
									<h4>30</h4>
								</div>
								<div class="card_widget_img">
									<img src="../static/assets/img/dash2.png" alt="card-img" />
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 col-12">
						<div class="card board1 fill3 ">
							<div class="card-body">
								<div class="card_widget_header">
									<label>Leaves</label>
									<h4>9</h4>
								</div>
								<div class="card_widget_img">
									<img src="../static/assets/img/dash3.png" alt="card-img" />
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 col-12">
						<div class="card board1 fill4 ">
							<div class="card-body">
								<div class="card_widget_header">
									<label>Salary</label>
									<h4>$5.8M</h4>
								</div>
								<div class="card_widget_img">
									<img src="../static/assets/img/dash4.png" alt="card-img" />
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xl-6 d-flex mobile-h">
						<div class="card flex-fill">
							<div class="card-header">
								<div class="d-flex justify-content-between align-items-center">
									<h5 class="card-title">Total Employees</h5>
								</div>
							</div>
							<div class="card-body">
								<div id="invoice_chart"></div>
								<div class="text-center text-muted">
									<div class="row">
										<div class="col-4">
											<div class="mt-4">
												<p class="mb-2 text-truncate"><i
														class="fas fa-circle text-primary mr-1"></i> Business</p>
											</div>
										</div>
										<div class="col-4">
											<div class="mt-4">
												<p class="mb-2 text-truncate"><i
														class="fas fa-circle text-success mr-1"></i> Testing</p>
											</div>
										</div>
										<div class="col-4">
											<div class="mt-4">
												<p class="mb-2 text-truncate"><i
														class="fas fa-circle text-danger mr-1"></i> Development</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-6 d-flex">
						<div class="card flex-fill">
							<div class="card-header">
								<div class="d-flex justify-content-between align-items-center">
									<h5 class="card-title">Total Salary By Unit</h5>
								</div>
							</div>
							<div class="card-body">
								<div id="sales_chart"></div>
							</div>
						</div>
					</div>
				</div>
		
			</div>
		</div>

	</div>


	<script src="../static/assets/js/jquery-3.6.0.min.js"></script>

	<script src="../static/assets/js/popper.min.js"></script>
	<script src="../static/assets/js/bootstrap.min.js"></script>

	<script src="../static/assets/js/feather.min.js"></script>

	<script src="../static/assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<script src="../static/assets/plugins/apexchart/apexcharts.min.js"></script>
	<script src="../static/assets/plugins/apexchart/chart-data.js"></script>

	<script src="../static/assets/js/script.js"></script>
</body>

</html>