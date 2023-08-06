package servlet;

import java.io.IOException;


import org.apache.commons.beanutils.BeanUtils;

import constant.SessionLG;
import dao.DAO_Email;
import dao.DAO_Users;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Users;

@WebServlet({ "/user"
	, "/user/login"
	, "/logout"
	, "/user/logout"
	, "/login"
	, "/admin/logout"
	, "/video/logout"
	, "/user/sign-up"
	, "/user/resetpass"
	, "/user/fogotPass"
	, "/user/changepass"
	, "/user/profile"
	, "/favorite/logout"})
public class loginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		HttpSession session = req.getSession();
		if (uri.contains("logout")) {
			logout(session, req, resp);
			req.setAttribute("view", "/views/account/dangnhap.jsp");
		} else if (uri.contains("/user/sign-up")) {
			req.setAttribute("view", "/views/account/dangky.jsp");
		} else if (uri.contains("/user/fogotPass")) {
			req.setAttribute("view", "/views/account/resetPass.jsp");
		} else if (uri.contains("/user/profile")) {
			detail(session, req, resp);
			req.setAttribute("view", "/views/account/myProfile.jsp");
		} else {
			req.setAttribute("view", "/views/account/dangnhap.jsp");
		}

		req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		HttpSession session = req.getSession();
		if (uri.contains("/login")) {
			login(session, req, resp);
			req.setAttribute("view", "/views/account/dangnhap.jsp");
		} else if (uri.contains("/user/sign-up")) {
			creatAccount(session, req, resp);
			req.setAttribute("view", "/views/account/dangky.jsp");
		} else if (uri.contains("/user/resetpass")) {
			resetPass(req, resp);
			req.setAttribute("view", "/views/account/resetPass.jsp");
		} else if (uri.contains("/user/changepass")) {
			System.out.println("change pass");
			changePass(session, req, resp);
			req.setAttribute("view", "/views/account/dangnhap.jsp");
		} else if (uri.contains("/user/profile")) {
			updateProfile(req, resp);
			req.setAttribute("view", "/views/account/myProfile.jsp");
		}
		req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
	}

	public void login(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DAO_Users dao = new DAO_Users();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Users user = dao.login(username, password);
		if (user != null) {
			session.setAttribute(SessionLG.CURRENT_USER, user);
			req.setAttribute("errorMessage", "Đăng nhập thành công");
		} else {
			req.setAttribute("errorMessage", "Đăng nhập thất bại, kiểm tra thông tin tài khoản");

		}

	}

	public void logout(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		session.removeAttribute(SessionLG.CURRENT_USER);

	}

	public void creatAccount(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			Users entity = new Users();
			BeanUtils.populate(entity, req.getParameterMap());
			DAO_Users dao = new DAO_Users();
			DAO_Email mail = new DAO_Email();
			mail.sendMail(getServletContext(), entity, "welcome");
			dao.create(entity);
			req.setAttribute("errorMessage", "Đăng ký thành công!");
		} catch (Exception e) {
			req.setAttribute("errorMessage", "Lỗi đăng ký!");
		}

	}

	public void resetPass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAO_Users dao = new DAO_Users();
		Users user = dao.findBYGmail(req.getParameter("email"));
		if (user != null) {
			System.out.println(req.getParameter("email"));
			dao.resetPass(req.getParameter("email"));
			DAO_Email mail = new DAO_Email();
			mail.sendMail(getServletContext(), user, "forgot");
			req.setAttribute("errorMessage", "Mật khẩu mới đã được gửi về gmail");
		} else {
			req.setAttribute("errorMessage", "Không tìm thấy email của người dùng");
		}

	}

	public void changePass(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DAO_Users dao = new DAO_Users();

		Users user = dao.login(req.getParameter("username"), req.getParameter("password"));
		if (user != null) {

			if (req.getParameter("password1").equals(req.getParameter("password2"))) {
				dao.changePass(req.getParameter("username"), req.getParameter("password1"));
				DAO_Email mail = new DAO_Email();
				mail.sendMail(getServletContext(), user, "changepass");
				req.setAttribute("errorMessage", "Đổi mật khẩu thành công");
				logout(session, req, resp);
			} else {
				req.setAttribute("errorMessage", "Nhập lại mật khẩu không đúng");
			}

		} else {
			req.setAttribute("errorMessage", "Tài khoản hoặc mật khẩu sai");
		}

	}

	private void updateProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Users user = new Users();
			DAO_Users dao = new DAO_Users();
			req.setAttribute("errorMessage", "Cập nhật tài khoản thành công");
			user.setPassword(req.getParameter("password"));
			user.setId(req.getParameter("id"));
			user.setFullname(req.getParameter("fullname"));
			user.setEmail(req.getParameter("email"));
			user.setAdmin(Boolean.parseBoolean(req.getParameter("admin")) );
			dao.update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void detail(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			Users user = (Users) session.getAttribute(SessionLG.CURRENT_USER);
			DAO_Users Dao = new DAO_Users();
			Users b = Dao.findBYID(user.getId());
			req.setAttribute("user", b);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
