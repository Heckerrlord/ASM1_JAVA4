<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="content container-fluid">
	<div class="page-name mb-4">
		<ul class="list-inline">
			<li class="list-inline-item">Tất cả</li>
			<li class="list-inline-item">Âm nhạc</li>
			<li class="list-inline-item">Hoạt hình</li>
			<li class="list-inline-item">Thịnh hành</li>
		</ul>
	</div>
<style>
		.list-inline-item {
			padding: 5px;
			background-color: #ffffff;
		}

		.list-inline-item:hover {
			background-color: #8d8c8c;
			color: aliceblue;
			border: 1px solid #ccc;
			border-radius: 5px;
			margin: -1px;
		}
	</style>
	<div class="row">
		<c:forEach items="${videoList}" var="item">
			<div class="col col-xl-4">
				<div class="card" style="width: 24rem;">
					<a href="http://localhost:8080/ASM_JAVA4/video/detail?id=${item.id}"> <img class="card-img-top"
						src="/ASM_JAVA4/static/image/${item.poster}"
						style="border-radius: 10px; height: 212px;" alt="Card image cap">
						<div class="card-body">
							<h5>${item.title}</h5>
							<p class="card-text" style="color: #AAAAAA">Lượt xem - ${item.views}</p>
							<a
								href="http://localhost:8080/CRUDASM/favorite/like?id=${Video.id}"
								class="btn btn-success">Like</a> <a
								href="http://localhost:8080/CRUDASM/favorite/hate?id=${Video.id}"
								class="btn btn-info">Share</a>
						</div>
					</a>
				</div>
			</div>

		</c:forEach>
	</div>

</div>
