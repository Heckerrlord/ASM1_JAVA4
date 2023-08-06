<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
</style>

<div class="container">
		<h1 class="text-center mb-4">Đăng ký</h1>
		<div class="row">
		<div class="col-4"></div>
		<div class="col-4">	<form method="post">
			<div class="form-group">
				<label for="id">Username</label>
				<input style="width: 100%" class="form-control" id="id" name="id" required>
			</div>
			<div class="form-group">
				<label for="password">Password</label>
				<input type="password" style="width: 100%" class="form-control" id="password" name="password" required>
			</div>
			<div class="form-group">
				<label for="fullname">Fullname</label>
				<input  style="width: 100%" class="form-control" id="fullname" name="fullname" required>
			</div>
			<div class="form-group">
				<label for="email">Email</label>
				<input type="email" style="width: 100%" class="form-control" id="email" name="email" required>
			</div>
			<input name="admin"  type="hidden" value="false">
			<button type="submit" formaction="http://localhost:8080/ASM_JAVA4/user/sign-up" class="btn btn-primary btn-block btn-submit mt-4">Đăng ký</button>
		</form></div>
		<div class="col-4"></div>
		</div>
	
		<h6>${message}</h6>
	</div>


