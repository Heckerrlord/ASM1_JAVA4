<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url var="url" value="/video"></c:url>
<div class="container">
	<div class="nTab">
		<div class="row">
			<div class="col-6">
				<h3>${mes}</h3>
			</div>
		</div>
	</div>
	<div class="nProduct">
		<div class="row">

			<div class="col-lg-3">
				<div class="card">
					<div class="image-container">
						<img src="/ASM_GD1_JAVA4/static/image/binhdoannguoisat.jpg" class="card-img-top" alt="..." />
						<div class="caption">
							<a class="nav-link" href="${url}/detail?id=qtb-nN3xiT4">Chi
								tiết</a>
						</div>
					</div>
					<div class="card-body">
						<div class="title">
							<h5 class="card-title">Binh đoàn người sắt</h5>
						</div>
						<div class="row">
							<div class="col-7">
								<div class="justify-content-left">
									<a
										href="http://localhost:8080/ASM_GD1_JAVA4/favorite/like?id=${item.id}"
										class="tym"><i style="color: #e1536b;"
										class="fas fa-heart"></i></a> <a href="#" class="share"><i
										class="fas fa-share"></i></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>
