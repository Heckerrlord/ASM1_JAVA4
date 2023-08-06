<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>Dleohr - Bootstrap Admin HTML Template</title>
<link rel="shortcut icon" href="/ASM_JAVA4/static/assets/img/favicon.png">
<link rel="stylesheet" href="/ASM_JAVA4/static/assets/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/ASM_JAVA4/static/assets/plugins/fontawesome/css/fontawesome.min.css">
<link rel="stylesheet"
	href="/ASM_JAVA4/static/assets/plugins/fontawesome/css/all.min.css">
<link rel="stylesheet" href="/ASM_JAVA4/static/assets/css/style.css">
<style type="text/css">
<
style> /* CSS cho thanh phân trang */ .pagination {
	display: inline-block;
}

.pagination li {
	display: inline-block;
	margin: 5px;
}

.pagination .page-link {
	color: #007bff;
	background-color: #fff;
	border: 1px solid #007bff;
	padding: 5px 10px;
	text-decoration: none;
}

.pagination .page-link:hover {
	background-color: #007bff;
	color: #fff;
}

.pagination .active .page-link {
	background-color: #007bff;
	color: #fff;
	border-color: #007bff;
}

#previewImage.grayscale {
	filter: grayscale(100%);
}

.form-control {
	border: 1px solid black;
}
</style>

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
					<h4 class="m-0">Quản lý video</h4>
					<h5>${a}</h5>
				</div>
				<h6 style="color: red;">${mes}</h6>
				<div class="centerForm">
					<form method="post" accept-charset="UTF-8" enctype="multipart/form-data">
						<div class=row>
							<div class="col-6">
								<label for="">POSTER HERE :</label><img
									style="width: 533px; height: 300px"
									src="/ASM_JAVA4/static/image/${Video.poster}" alt=""
									id="previewImage" />
									<input type="text" value="${Video.poster}" name="anhten" hidden="true">
								<div class="form-group">
									<label for="poster">Poster:</label> <input type="file"
										name="poster_file" id="imageInput" class="form-control"
										value="${Video.poster}" />
								</div>
							</div>
							<div class="col-6">

								<div class="form-group">
									<label for="id">ID Video:</label> <input name="id"
										class="form-control" value="${Video.id}" required />
								</div>
								<div class="form-group">
									<label for="title">Title:</label> <input type="text" name="title"
										class="form-control" value="${Video.title}" required />
								</div>

								<div class="form-group">
									<label for="views">Views:</label> <input name="views"
										id="views" class="form-control" value="${Video.views}"
										required />
								</div>

								<div class="form-group">
									<label for="active">Active:</label><br /> <input type="radio"
										name="active" value="false" ${!Video.active?'checked':''}>
									No <input type="radio" name="active" value="true"
										${Video.active?'checked':''} style="margin-left: 20px">
									Yes
								</div>


								<button type="submit"
									formaction="http://localhost:8080/ASM_JAVA4/admin/video/create"
									class="btn btn-success">ADD</button>
								<button type="submit"
									formaction="http://localhost:8080/ASM_JAVA4/admin/video/update"
									class="btn btn-info">UPDATE</button>

							</div>
						</div>
						<div class="form-group">
							<label for="description">Description:</label>
							<textarea rows="" cols="" name="description" class="form-control"
								required id="description">${Video.description}</textarea>
						</div>
					</form>
				</div>
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
									<td><a href="/ASM_JAVA4/admin/video/edit?id=${item.id}" class="btn btn-success">Edit</a></td>
									<td><a href="/ASM_JAVA4/admin/video/delete?id=${item.id}" class="btn btn-danger">X</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>


				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-end">

						<c:if test="${currentPage > 1}">
							<li class="page-item"><a class="page-link"
								href="http://localhost:8080/ASM_JAVA4/admin/video?page=${currentPage - 1}">Trang trước</a></li>
						</c:if>
						<c:forEach var="pageNumber" items="${pageNumbers}">
							<c:choose>
								<c:when test="${pageNumber eq currentPage}">
									<li class="page-item active"><a class="page-link"
										href="http://localhost:8080/ASM_JAVA4/admin/video?page=${pageNumber}">${pageNumber}</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="http://localhost:8080/ASM_JAVA4/admin/video?page=${pageNumber}">${pageNumber}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${currentPage < totalPages}">
							<li class="page-item"><a class="page-link"
								href="http://localhost:8080/ASM_JAVA4/admin/video?page=${currentPage + 1}">Trang sau</a></li>
						</c:if>

					</ul>
				</nav>



			</div>


		</div>

	</div>

	<script>
		const imageInput = document.getElementById('imageInput');
		const previewImage = document.getElementById('previewImage');

		imageInput.addEventListener('change', function() {
			const file = imageInput.files[0];
			if (file) {
				previewImage.classList.remove('grayscale'); // Remove grayscale effect
				const reader = new FileReader();
				reader.onload = function(e) {
					previewImage.src = e.target.result;
				};
				reader.readAsDataURL(file);
			} else {
				previewImage.classList.add('grayscale'); // Add grayscale effect
				previewImage.src = ""; // Clear the image source
			}
		});
	</script>
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