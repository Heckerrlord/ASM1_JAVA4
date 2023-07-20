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
<style>
.sameVideo {
	margin-bottom: 10px;
}
</style>
<section class="detailProduct" style="margin-top: -80px">
	<div class="container">
		<div class="detailP">
			<div class="row">
				<div class="col-md-9">
					<iframe width="100%" height="500px"
						src="https://www.youtube.com/embed/${Video.id}"
						title="YouTube video player" frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
						allowfullscreen></iframe>
				</div>
				<div class="col-md-3">

					<c:forEach items="${video}" var="item">
						<a class="nav-link"
							href="http://localhost:8080/ASM_GD1_JAVA4/video/detail?id=${item.id}">
							<div class="row" style="margin-bottom: 10px;">

								<div class="col-8">
									<div class="image-container">
										<img src="/ASM_GD1_JAVA4/static/image/${item.poster}"
											class="card-img-top" alt="..."
											style="width: 200px; height: 115px;border-radius:10px;" />
									</div>
								</div>
								<div class="col-4">
									<p style="font-weight: bold;">${item.title}</p>

									<p style="font-size: 12px">Lượt xem: ${item.views}</p>

								</div>

							</div>
						</a>
					</c:forEach>

				</div>
			</div>
		</div>
		<div>

			<div>
				<h1>
					<span style="font-weight: 100">Tên :</span> ${Video.title}
				</h1>
				<h2>
					<span style="color: #85c94f">Lượt xem: ${Video.views+1}</span>
				</h2>




				<a href="http://localhost:8080/CRUDASM/favorite/like?id=${Video.id}"
					class="btn btn-success">Like</a> <a
					href="http://localhost:8080/CRUDASM/favorite/hate?id=${Video.id}"
					class="btn btn-info">Share</a>
				<hr />
				<p>
					<strong>Mô tả:</strong> <br> ${Video.description}
				</p>
			</div>
		</div>
	</div>
</section>
