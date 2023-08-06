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

<link rel="shortcut icon"
	href="/ASM_JAVA4/static/assets/img/favicon.png">

<link rel="stylesheet"
	href="/ASM_JAVA4/static/assets/css/bootstrap.min.css">

<link rel="stylesheet"
	href="/ASM_JAVA4/static/assets/plugins/fontawesome/css/fontawesome.min.css">
<link rel="stylesheet"
	href="/ASM_JAVA4/static/assets/plugins/fontawesome/css/all.min.css">

<link rel="stylesheet" href="/ASM_JAVA4/static/assets/css/style.css">
<!--[if lt IE 9]>
			<script src="/ASM_JAVA4/static/assets/js/html5shiv.min.js"></script>
			<script src="/ASM_JAVA4/static/assets/js/respond.min.js"></script>
		<![endif]-->
</head>

<body>

	<div class="main-wrapper">
		<div class="header">
			<%@include file="/views/layout/header.jsp"%>
		</div>
		<div class="sidebar" id="sidebar">
			<%@include file="/views/layout/slidebarAdmin.jsp"%>
		</div>


		<div class="page-wrapper">
			<div class="content container-fluid">
				<div class="page-name 	mb-4">
					<h4 class="m-0">Quản lý tài khoản</h4>
					<label>${localDate}</label>
				</div>
				<form method="post">

					<div class="row">
						<div class="col-6">
							<div class="form-group">
								<label for="id">User Name:</label>
								<c:choose>
									<c:when test="${disabled == 'disabled'}">
										<input type="text" class="form-control" name="id"
											value="${user.id}" disabled="disabled" />

									</c:when>
									<c:otherwise>
										<input type="text" class="form-control" name="id"
											value="${user.id}" required />

									</c:otherwise>
								</c:choose>
							</div>
							<div class="form-group">
								<label for="title">Password:</label> <input type="text"
									name="password" class="form-control" value="${user.password}"
									required />
							</div>
							<div class="form-group">
								<label for="Role">Role:</label> <input type="radio" name="admin"
									value="false" ${!user.admin?'checked':''} />Guest <input
									type="radio" name="admin" value="true"
									${user.admin?'checked':''} style="margin-left: 20px" />Admin <br />
							</div>
						</div>

						<div class="col-6">
							<div class="form-group">
								<label for="Address">Email:</label> <input class="form-control"
									type="email" id="email" name="email" value="${user.email}"
									required />
							</div>
							<div class="form-group">
								<label for="Age">Full name:</label> <input class="form-control"
									type="text" id="fullname" name="fullname"
									value="${user.fullname}" required />
							</div>

						</div>
					</div>


					<input type="submit"
						formaction="http://localhost:8080/ASM_JAVA4/admin/user/create"
						value="ADD" class="btn btn-success" /> <input type="submit"
						formaction="http://localhost:8080/ASM_JAVA4/admin/user/update"
						value="UPDATE" class="btn btn-info" />

				</form>
				<div class="row">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">User name</th>
								<th scope="col">Password</th>
								<th scope="col">Email</th>
								<th scope="col">Full name</th>
								<th scope="col">Admin?</th>
								<th scope="col">Edit</th>
								<th scope="col">Un active</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userList}" var="item">
								<tr>
									<th>${item.id}</th>
									<td>${item.password}</td>
									<td>${item.email}</td>
									<td>${item.fullname}</td>
									<td>${item.admin?'yes':'no'}</td>
									<td><a class="btn btn-success"
										href="http://localhost:8080/ASM_JAVA4/admin/user/edit?id=${item.id}">Edit</a></td>
									<td><a class="btn btn-danger"
										href="http://localhost:8080/ASM_JAVA4/admin/user/delete?id=${item.id}">X</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
		</div>

	</div>


	<script src="/ASM_JAVA4/static/assets/js/jquery-3.6.0.min.js"></script>

	<script src="/ASM_JAVA4/static/assets/js/popper.min.js"></script>
	<script src="/ASM_JAVA4/static/assets/js/bootstrap.min.js"></script>

	<script src="/ASM_JAVA4/static/assets/js/feather.min.js"></script>

	<script
		src="/ASM_JAVA4/static/assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<script
		src="/ASM_JAVA4/static/assets/plugins/apexchart/apexcharts.min.js"></script>
	<script src="/ASM_JAVA4/static/assets/plugins/apexchart/chart-data.js"></script>

	<script src="/ASM_JAVA4/static/assets/js/script.js"></script>
</body>

</html>