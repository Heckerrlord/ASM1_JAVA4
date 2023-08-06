<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<h1 class="text-center mb-4">My Profile</h1>
	<div class="row">
		<div class="col-4"></div>
		<div class="col-4">
			<form method="post">
				<div class="form-group">
					<label for="id">Username</label> <input type="text"
						style="width: 100%" class="form-control" id="id" name="id"
						value="${user.id}" readonly>
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						style="width: 100%" class="form-control" id="password"
						name="password" value="${user.password}" readonly required>
				</div>
				<div class="form-group">
					<label for="fullname">Fullname</label> <input type="text"
						style="width: 100%" class="form-control" id="fullname"
						name="fullname" value="${user.fullname}" required>
				</div>
				<div class="form-group">
					<label for="email">Email</label> <input type="email"
						style="width: 100%" class="form-control" id="email" name="email"
						value="${user.email}" required>
				</div>

				<input name="admin" type="hidden" value="${user.admin}">




				<button type="submit"
					formaction="http://localhost:8080/ASM_JAVA4/user/profile"
					class="btn btn-primary btn-block btn-submit mt-4">Cập nhật
					thông tin</button>
				<div class="row" style="text-align: center">
					<div class="col-4">
						<a class="hover"
							href="http://localhost:8080/ASM_JAVA4/user/sign-up">Register</a>
					</div>
					<div class="col-4">
						<a class="hover"
							href="http://localhost:8080/ASM_JAVA4/user/changepass">Change
							password</a>
					</div>
					<div class="col-4">
						<a class="hover"
							href="http://localhost:8080/ASM_JAVA4/user/fogotPass">Forgot
							password</a>
					</div>
				</div>
			</form>
		</div>
		<div class="col-4"></div>
	</div>
	<h6 class="text-danger">${errorMessage}</h6>
	<h6>${message}</h6>
</div>


