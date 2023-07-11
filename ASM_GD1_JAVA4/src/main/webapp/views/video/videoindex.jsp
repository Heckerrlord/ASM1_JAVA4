<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<c:url var="url" value="/video"></c:url>
<div class="container">
	<div class="nTab">
		<div class="row">
			<div class="col-3">
				<h3>Phim mới</h3>
			</div>
		</div>
	</div>
	<div class="nProduct" >
		<div class="row" style="padding-bottom: 20px">
		<c:forEach items="${video}" var="item">
			 <div class="col-lg-3">
				<div class="card">
					<div class="image-container">
						<img src="static/image/${item.poster}" class="card-img-top"
							alt="..." />
						<div class="caption">
							<a class="nav-link" href="${url}/detail?id=${item.id}">Chi tiết</a>
						</div>
					</div>
					<div class="card-body">
					<div class="title">
						<h5 class="card-title">${item.title}</h5>
						</div>
						<h5 class="card-price">${item.description}</h5>
						<div class="row">
							<div class="col-7">
								<div class="justify-content-left">
									<a class="tym"><i class="far fa-heart"></i></a> <a
										href="#" class="share"><i class="fas fa-share"></i></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>
			
		</div>
	</div>
</div>
