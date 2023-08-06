<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<link rel="stylesheet" href="https://kit.fontawesome.com/a7a43ca69d.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" />
<link rel="stylesheet" href="static/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="static/css/allstyle.css">
<link rel="stylesheet" type="text/css" href="static/css/styleht.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:url var="url" value="/"></c:url>
<div id="main-menu">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<div class="nav justify-content-left">
				<a class="navbar-brand" href="#home">phimcu.net</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNav" aria-controls="navbarNav"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a class="nav-link"
							href="${url}index">Trang chủ</a></li>

						<li class="nav-item"><a class="nav-link"
							href="${url}favorite/home">Yêu thích</a></li>
						<%-- <li class="nav-item"><a class="nav-link"
							href="${url}video/home">Video</a></li> --%>

						

						<!-- <li class="nav-item">
              <a class="nav-link" href="#"></a>
            </li> -->
					</ul>
				</div>
			</div>
			<div class="nav justify-content-end">
				<form method="post">
					<div class="row">
						<div class="col-7">
							<input class="form-control mr-sm-2" type="search" name="search"
								placeholder="Tìm kiếm" />
						</div>
						<div class="col-4">
							<button class="btn btn-outline-success my-2 my-sm-0"
								formaction="${url}find" type="submit">Tìm kiếm</button>
						</div>
					</div>


				</form>


				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="${url}user">Tài
							khoản</a></li>
				</ul>

			</div>
		</div>
	</nav>
</div>
<script>
	window.addEventListener("scroll", function() {
		var header = document.querySelector("#main-menu");
		header.classList.toggle("active", window.scrollY > 0);
	});
</script>