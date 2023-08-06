<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <link rel="stylesheet" href="https://kit.fontawesome.com/a7a43ca69d.css" />
 
 <div class="sidebar-inner slimscroll">
				<div class="sidebar-contents">
					<div id="sidebar-menu" class="sidebar-menu">
						<div class="mobile-show">
							<div class="offcanvas-menu">
								<div class="user-info align-center bg-theme text-center">
									<span class="lnr lnr-cross  text-white" id="mobile_btn_close">X</span>
									<a href="javascript:void(0)"
										class="d-block menu-style text-white">
										<div class="user-avatar d-inline-block mr-3">
											<img src="/ASM_JAVA4/static/assets/img/profiles/avatar-18.jpg"
												alt="user avatar" class="rounded-circle" width="50">
										</div>
									</a>
								</div>
							</div>
							<div class="sidebar-input">
								<div class="top-nav-search">
									<form>
										<input type="text" class="form-control"
											placeholder="Search here">
										<button class="btn" type="submit">
											<i class="fas fa-search"></i>
										</button>
									</form>
								</div>
							</div>
						</div>
						<ul>
							<li class="active"><a
								href="http://localhost:8080/ASM_JAVA4/admin/home"><img
									src="/ASM_JAVA4/static/assets/img/home.svg" alt="sidebar_img"> <span>Dashboard</span></a>
							</li>
							<li><a href="http://localhost:8080/ASM_JAVA4/admin/user"><img
									src="/ASM_JAVA4/static/assets/img/employee.svg" alt="sidebar_img"><span>
										User</span></a></li>
							<li><a href="http://localhost:8080/ASM_JAVA4/admin/video"><img
									src="/ASM_JAVA4/static/assets/img/manage.svg" alt="sidebar_img">
									<span>Video</span></a></li>

						</ul>
						<ul class="logout">
							<li><a href="profile.html"><img
									src="/ASM_JAVA4/static/assets/img/logout.svg" alt="sidebar_img"><span>Log
										out</span></a></li>
						</ul>
					</div>
				</div>
			</div>