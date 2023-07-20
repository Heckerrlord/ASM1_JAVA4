<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<style>
</style>

<div class="container">
		<h1 class="text-center mb-4">Quên mật khẩu</h1>
		<div class="row">
		<div class="col-4"></div>
		<div class="col-4">	<form method="post">
			<div class="form-group">
				<label for="email">Nhập email:</label>
				<input type="email" style="width: 100%" class="form-control" id="email" name="email" required>
			</div>
			<input name="admin"  type="hidden" value="false">
			<button type="submit" formaction="http://localhost:8080/ASM_GD1_JAVA4/user/resetpass" class="btn btn-primary btn-block btn-submit mt-4">Quên mật khẩu</button>
		</form></div>
		<div class="col-4"></div>
		</div>
	
		<h6>${message}</h6>
	</div>


