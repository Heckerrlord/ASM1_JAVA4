<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<link rel="stylesheet" href="https://kit.fontawesome.com/a7a43ca69d.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" />
<link rel="stylesheet" href="../static/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../static/css/allstyle.css">
<link rel="stylesheet" type="text/css" href="../static/css/styleht.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<section class="detailProduct" style="margin-top: -80px">
	<div class="container">
		<div class="detailP">
			<div class="row">
				<div class="col-md-8">
					<iframe width="100%" height="500px"
						src="https://www.youtube.com/embed/${Video.id}"
						title="YouTube video player" frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
						allowfullscreen></iframe>
				</div>
				<div class="col-md-4">
					<h1>
						<span style="font-weight: 100">Tên :</span> ${Video.title}
					</h1>
					<h2>
						<span style="color: #85c94f">Lượt xem: ${Video.views+1}</span>
					</h2>
					<p><strong>Mô tả:</strong> <br> ${Video.description}</p>
					<hr />


					<a href="http://localhost:8080/CRUDASM/favorite/like?id=${Video.id}" class="tym"><i style="color:#e1536b;" class="far fa-heart"></i></a> 
									<a href="http://localhost:8080/CRUDASM/favorite/hate?id=${Video.id}" class="tym"><i class="far fa-heart"></i></a> 
					 <a href="#"
						class="share"><i class="fas fa-share"></i></a> <br> Contact
					<hr />
					<div class="contactdetail">
						<ul class="nav justify-content-left">
							<a class="nav-link"
								href="#"><i
								class="fab fa-facebook"></i></a>
							<a class="nav-link" href="#"><i
								class="fab fa-instagram"></i></a>
							<a class="nav-link"
								href="#"><i
								class="fab fa-youtube"></i></a>
							<a class="nav-link" href="#"><i
								class="fab fa-github"></i></a>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="sameProduct">
			<div class="nTab">
				<div class="row">
					<div class="col-6">
						<h3>Product Recommendations</h3>
					</div>
					<div class="col-6">
						<ul class="nav justify-content-end">
							<li class="nav-item"><a class="nav-link active" href="#shop"
								style="border: none"><i class="far fa-eye"></i> View more</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div>
				<div class="row">
					<c:forEach items="${video}" var="item">
						<div class="col-lg-3">
							
								<div class="image-container">
									<img src="/CRUDASM/static/image/${item.poster}"
										class="card-img-top" alt="..." />
									<div class="caption">
										<a class="nav-link" href="http://localhost:8080/ASM_GD1_JAVA4/video/detail?id=${item.id}">${item.title}</a>
									</div>
								</div>
							</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</section>
