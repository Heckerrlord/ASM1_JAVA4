<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
</style>

<div class="container">
	<h1 class="text-center mb-4">Chia sẻ</h1>
	<div class="row">
		<div class="col-4"></div>
		<div class="col-4">
			<form method="post">
				<div class="form-group">
					<label for="email">Your friend email:</label> <input type="email"
						style="width: 100%" class="form-control" id="email"
						name="friend_email" required>

				</div>
				<div class="form-group">
					<label for="email">${Video.title}</label>
					<iframe width="100%" height="500px"
						src="https://www.youtube.com/embed/${Video.id}"
						title="YouTube video player" frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
						allowfullscreen></iframe>
				</div>
				<input name="admin" type="hidden" value="false">
				<button type="submit" formaction="/ASM_JAVA4/share?id=${Video.id}"
					class="btn btn-primary btn-block btn-submit mt-4">Gửi</button>
			</form>
		</div>
		<div class="col-4"></div>
	</div>
</div>


