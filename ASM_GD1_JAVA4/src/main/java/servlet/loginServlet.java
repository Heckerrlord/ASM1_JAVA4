package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.TK;
import models.Video;

@WebServlet({ "/user", "/user/login", "/logout", "/user/logout", "/login", "/admin/logout", "/video/logout",
		"/user/sign-up", "/user/resetpass", "/user/fogotPass", "/user/changepass", "/user/profile" })
public class loginServlet extends HttpServlet {

	private List<TK> TKlist;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();

		if (uri.contains("logout")) {
			req.setAttribute("view", "/views/account/dangnhap.jsp");
		} else if (uri.contains("/user/sign-up")) {
			req.setAttribute("view", "/views/account/dangky.jsp");
		} else if (uri.contains("/user/fogotPass")) {
			req.setAttribute("view", "/views/account/resetPass.jsp");
		} else if (uri.contains("/user/profile")) {
			req.setAttribute("view", "/views/account/myProfile.jsp");
		} else {
			req.setAttribute("view", "/views/account/dangnhap.jsp");
		}

		req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		TKlist = new ArrayList<>();
		TKlist.add(new TK("user1", "123", "abc@gmail.com", "Nguyen Van A", false));
		TKlist.add(new TK("admin1", "123", "admin@gmail.com", "admin", true));
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();

		if (uri.contains("/user/login")) {
			login(req, resp);
		}
		
		
		
		

	}
	
	
	
	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String username = req.getParameter("username");
	    String password = req.getParameter("password");
	    // Kiểm tra đăng nhập
	    boolean isAuthenticated = checkAuthentication(username, password);
	    if (isAuthenticated) {
	        // Lấy thông tin tài khoản
	        TK account = getAccountByUsername(username);
	        if (account != null) {
	            if (account.isAdmin()) {
	                // Nếu là tài khoản admin, chuyển hướng đến trang admin home
	                resp.sendRedirect("http://localhost:8080/ASM_GD1_JAVA4/admin/home");
	            } else {
	                // Nếu là tài khoản user, chuyển hướng đến URL cụ thể
	                resp.sendRedirect("http://localhost:8080/ASM_GD1_JAVA4/index");
	            }
	        } else {
	            // Xử lý khi không tìm thấy tài khoản
	            req.setAttribute("errorMessage", "Tài khoản không tồn tại");
	            req.getRequestDispatcher("login.jsp").forward(req, resp);
	        }
	    } else {
	        // Xử lý khi đăng nhập không thành công
	        req.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng");
	        req.setAttribute("view", "/views/account/dangnhap.jsp");
	        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
	    }
		
	}
	
	private boolean checkAuthentication(String username, String password) {
	    // Thực hiện xác thực tài khoản ở đây
	    // Trả về true nếu xác thực thành công, ngược lại trả về false
	    // Ví dụ: so sánh thông tin đăng nhập với danh sách tài khoản
	    for (TK account : TKlist) {
	        if (account.getId().equals(username) && account.getPassword().equals(password)) {
	            return true;
	        }
	    }
	    return false;
	}

	private TK getAccountByUsername(String username) {
	    // Tìm kiếm tài khoản theo username
	    // Trả về tài khoản nếu tìm thấy, ngược lại trả về null
	    for (TK account : TKlist) {
	        if (account.getId().equals(username)) {
	            return account;
	        }
	    }
	    return null;
	}

}
