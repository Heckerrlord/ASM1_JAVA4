<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url var="url" value="/video"></c:url>
<div><%@include file="slideShow.jsp"%></div>
<div class="container">

	<div class="nTab">
		<div class="row">
			<div class="col-3">
				<h3>Phim mới</h3>
			</div>
		</div>
	</div>
	<div class="nProduct">
		<div class="row">

			<c:forEach items="${videoList}" var="item">
				<div class="col-lg-3">
					<div class="card">
						<div class="image-container">
							<img src="/ASM_GD1_JAVA4/static/image/${item.poster}"
								class="card-img-top" alt="..." />
							<div class="caption">
								<a class="nav-link" href="${url}/detail?id=${item.id}">Chi
									tiết</a>
							</div>
						</div>
						<div class="card-body">
							<div class="title">
								<h5 class="card-title">${item.title}</h5>
							</div>
							<div class="row">
								<div class="col-7">
									<div class="justify-content-left">
										<a
											href="http://localhost:8080/CRUDASM/favorite/like?id=${item.id}"
											class="tym"><i style="color: #e1536b;"
											class="far fa-heart"></i></a> <a href="#" class="share"><i
											class="fas fa-share"></i></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<br>

			</c:forEach>



		</div>
		<br>
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-end">
				<li class="page-item disabled"><a class="page-link" href="#"
					tabindex="-1">Previous</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</nav>
	</div>
	<%-- <div class="row tm-mb-90">
			<div
				class="col-12 d-flex justify-content-between align-items-center tm-paging-col">
				<c:if test="${currentPage == 1 }">
				<a href="javascript:void(0);" class="btn btn-primary tm-btn-prev mb-2 disabled">Previous</a>
				</c:if>
				<c:if test="${currentPage > 1 }">
					<a href="index?page=${currentPage - 1}" class="btn btn-primary tm-btn-prev mb-2 ">Previous</a>
				</c:if>
				<div class="tm-paging d-flex">
					<c:forEach varStatus="i" begin ="1" end="${maxPage}"> 
					<a href="index?page=${i.index}" 
					class="active tm-paging-link ${currentPage == i.index ? 'active' : ''}">${i.index}</a>
					</c:forEach>
				</div>
				<c:if test="${currentPage == maxPage }">
				<a href="javascript:void(0);" class="btn btn-primary tm-btn-prev mb-2 disabled">Next</a>
				</c:if>
				<c:if test="${currentPage < maxPage }">
					<a href="index?page=${currentPage + 1}" class="btn btn-primary tm-btn-prev mb-2 ">Next</a>
				</c:if>
					
			</div>
		</div> --%>
</div>
</div>
