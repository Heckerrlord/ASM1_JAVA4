<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
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
			<%@include
				file="/views/layout/header.jsp"%>
		</div>
		<div class="sidebar" id="sidebar">
			<%@include
				file="/views/layout/slidebarAdmin.jsp"%>
		</div>


		<div class="page-wrapper">
			<div class="content container-fluid">
				<div class="page-name 	mb-4">
					<h4 class="m-0">
						<img src="../static/assets/img/profile.jpg" class="mr-1"
							alt="profile" /> Welcome Admin
					</h4>
					<label>${a}</label>
				</div>

				<div class="row mb-4">
					<div class="col-xl-3 col-sm-6 col-12">
						<div class="card board1 fill1 ">
							<div class="card-body">
								<div class="card_widget_header">
									<label>Người dùng</label>
									<h4>${usersCount}</h4>
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
									<label>Video</label>
									<h4>${videoCount}</h4>
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
									<label>Lượt xem</label>
									<h4>${viewsCount}</h4>
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
									<h5 class="card-title">Đang fix cứng</h5>
								</div>
							</div>
							<div class="card-body">
								<div id="invoice_chart"></div>
								<div class="text-center text-muted">
									<div class="row">
										<div class="col-4">
											<div class="mt-4">
												<p class="mb-2 text-truncate">
														<i class="fas fa-circle text-primary mr-1"></i> Business
													</p>
											</div>
										</div>
										<div class="col-4">
											<div class="mt-4">
												<p class="mb-2 text-truncate">
													<i class="fas fa-circle text-success mr-1"></i> Testing
												</p>
											</div>
										</div>
										<div class="col-4">
											<div class="mt-4">
												<p class="mb-2 text-truncate">
													<i class="fas fa-circle text-danger mr-1"></i> Development
												</p>
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
									<h5 class="card-title">Đang fix cứng</h5>
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

	<script
		src="../static/assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<script src="../static/assets/plugins/apexchart/apexcharts.min.js"></script>
	<script src="../static/assets/plugins/apexchart/chart-data.js"></script>

	<script src="../static/assets/js/script.js"></script>
</body>

</html>