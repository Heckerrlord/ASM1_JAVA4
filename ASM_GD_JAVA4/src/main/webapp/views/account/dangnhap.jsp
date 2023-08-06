<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
.hover:hover {
	text-decoration: underline;
}

.form-container {
	max-width: 500px;
	margin: 0 auto;
	padding: 20px;
	background-color: #f8f9fa;
	border: 1px solid #e9ecef;
	border-radius: 5px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.show-password {
	width: 100%;
}
</style>
<div class="container">
	<c:choose>
		<c:when test="${not empty sessionScope.currentUser}">
			<h2 class="text-center mb-4">Đổi mật khẩu</h2>
			<div class="row">
				<div class="col-4"></div>
				<div class="col-4">
					<form method="post">
						<div class="form-group">
							<label for="username">Tên đăng nhập:</label> <input type="text"
								style="width: 100%" class="form-control" id="username"
								name="username" readonly value="${sessionScope.currentUser.id}">
						</div>
						<div class="form-group">
							<label for="password">Mật khẩu cũ:</label> <input
								style="width: 100%" type="password" class="form-control"
								id="password" name="password" required>

						</div>
						<div class="form-group">
							<label for="password">Mật khẩu mới:</label> <input
								style="width: 100%" type="password" class="form-control"
								id="password1" name="password1" required>
						</div>
						<div class="form-group">
							<label for="password">Nhập lại:</label>
							<div class="row">
								<div class="col-10">
									<input style="width: 100%" type="password" class="form-control"
										id="password2" name="password2" required>
								</div>
								<div class="col-2">
									<button class="show-password btn btn-secondary" type="button"
										onclick="togglePassword()">Show</button>
								</div>
							</div>
						</div>
						<button type="submit"
							formaction="http://localhost:8080/ASM_GD1_JAVA4/user/changepass"
							class="btn btn-primary btn-block mt-4">Đổi mật khẩu</button>
						<div class="row" style="text-align: center">
							<div class="col-4">
								<a class="hover"
									href="http://localhost:8080/ASM_GD1_JAVA4/user/sign-up">Register</a>
							</div>
							<div class="col-4">
								<a class="hover"
									href="http://localhost:8080/ASM_GD1_JAVA4/user/profile">My
									profile</a>
							</div>
							<div class="col-4">
								<a class="hover"
									href="http://localhost:8080/ASM_GD1_JAVA4/user/fogotPass">Forgot
									password</a>
							</div>
						</div>
					</form>
				</div>
				<div class="col-4"></div>
			</div>

		</c:when>
		<c:otherwise>
			<div class="form-container">
				<h2 class="text-center mb-4">Đăng nhập</h2>
				<form method="post"
					action="http://localhost:8080/ASM_GD1_JAVA4/user/login">
					<div class="form-group">
						<label for="username">Tên đăng nhập</label> <input type="text"
							class="form-control" id="username" style="width: 100%" name="username" required>
					</div>
					<div class="form-group">
						<label for="password">Mật khẩu</label>
						<div class="input-group">
							<input type="password" class="form-control" id="password"
								name="password" required>
							<div class="input-group-append">
								<button class="show-password btn btn-secondary" type="button"
									onclick="togglePassword()">Hiện</button>
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-primary btn-block mt-4">Đăng
						nhập</button>
					<div class="d-flex justify-content-between mt-3">
						<a href="http://localhost:8080/ASM_GD1_JAVA4/user/sign-up">Tạo
							tài khoản</a> <a
							href="http://localhost:8080/ASM_GD1_JAVA4/user/fogotPass">Quên
							mật khẩu</a>
					</div>
				</form>
			</div>
		</c:otherwise>
	</c:choose>

	<h6 class="text-danger">${errorMessage}</h6>
</div>

<script>
	function togglePassword() {
		var passwordField = document.getElementById("password");
		var passwordField1 = document.getElementById("password1");
		var passwordField2 = document.getElementById("password2");
		if (passwordField.type === "password") {
			passwordField.type = "text";
			passwordField1.type = "text";
			passwordField2.type = "text";
		} else {
			passwordField.type = "password";
			passwordField1.type = "password";
			passwordField2.type = "password";
		}
	}
</script>
