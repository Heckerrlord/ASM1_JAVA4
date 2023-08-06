package servlet;

import java.io.IOException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import dao.DAO_Users;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Users;

@WebServlet({
	"/admin/user/create"
	,"/admin/user/update"
	,"/admin/user/edit"
	,"/admin/user/delete"
	,"/admin/user/reset"})
public class userServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if(uri.contains("admin/user/edit")) {
			detail(req, resp);
		}else if (uri.contains("/admin/user/delete")) {
			delete(req, resp);
		}else if (uri.contains("/admin/user/reset")) {
			reset(req, resp);
		}
		
		fillAll(req, resp);

		req.getRequestDispatcher("/views/admin/adminUser.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if(uri.contains("admin/user/create")) {
			create(req, resp);
		}else if (uri.contains("/admin/user/update")) {
			update(req, resp);
		}
		fillAll(req, resp);
		req.getRequestDispatcher("/views/admin/adminUser.jsp").forward(req, resp);
	}
	
	
	private void fillAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			DAO_Users dao = new DAO_Users();
			List<Users> list = dao.findAll();
			req.setAttribute("userList", list);
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("bug", "bug rooif");
			System.out.println("casasda");
		}
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			DAO_Users dao = new DAO_Users();
			dao.delete(req.getParameter("id"));
			req.setAttribute("mes", "Xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Xóa thành công!");
		}
	}

	private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			DAO_Users dao = new DAO_Users();
			Users user = dao.findBYID(req.getParameter("id"));
			req.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Users user = new Users();
			BeanUtils.populate(user, req.getParameterMap());
			DAO_Users dao = new DAO_Users();
			req.setAttribute("mes", "Tạo mới tài khoản thành công");
			dao.create(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Users user = new Users();
			BeanUtils.populate(user, req.getParameterMap());
			DAO_Users dao = new DAO_Users();
			req.setAttribute("mes", "Cập nhật tài khoản thành công");
			dao.update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			DAO_Users dao = new DAO_Users();
			Users user = new Users();
			req.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}


}
