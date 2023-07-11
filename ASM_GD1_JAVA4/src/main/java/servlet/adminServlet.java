package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.TK;
import models.Video;

@WebServlet({ "/admin/home", "/admin/user", "/admin/video" })
public class adminServlet extends HttpServlet {
	private List<Video> videoList;
	private List<TK> TKlist;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String a= String.valueOf(java.time.LocalDate.now());
		req.setAttribute("a",a);
		if (uri.contains("/admin/home")) {
			req.getRequestDispatcher("/views/admin/adminIndex.jsp").forward(req, resp);
		}
		if (uri.contains("/admin/video")) {
			fillAllVideo(req);
			req.getRequestDispatcher("/views/admin/adminVideo.jsp").forward(req, resp);
		}
		if (uri.contains("/admin/user")) {
			fillAllUser(req);
			req.getRequestDispatcher("/views/admin/adminUser.jsp").forward(req, resp);
		}
			

	}

	private void fillAllVideo(HttpServletRequest req) {
		req.setAttribute("videoList", videoList);
	}
	private void fillAllUser(HttpServletRequest req) {
		req.setAttribute("userList", TKlist);
	}

	@Override
	public void init() throws ServletException {
		super.init();

		videoList = new ArrayList<>();
		videoList.add(
				new Video("qtb-nN3xiT4", "Binh đoàn người sắt", "binhdoannguoisat.jpg", 100, "Description 1", true));
		videoList.add(
				new Video("qtb-nN3xiT4", "Hiệp sĩ không gian", "hiepsikhonggian.jpg", 200, "Description 2", false));
		videoList.add(new Video("j65Sm4aJ5iI", "Xứ sở người cá", "susonguoica.jpg", 300, "Description 3", true));
		videoList.add(new Video("EYyVPVHnjiU", "Thám hiểm vùng đất mới", "chuyenlamhiemvungdatmoi.jpg", 300,
				"Description 4", true));
		
		TKlist = new ArrayList<>();
		TKlist.add(new TK("user1", "123", "abc@gmail.com", "Nguyen Van A", false));
		TKlist.add(new TK("admin1", "123", "admin@gmail.com", "admin", true));
	}

}
