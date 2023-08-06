package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.DAO_Email;
import dao.DAO_Favorite;
import dao.DAO_Video;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import constant.SessionLG;
import models.Favorite;
import models.Share;
import models.Users;
import models.Video;

@WebServlet({ "/index", "/share", "/find", "/favorite", "/video/detail", "/favorite/like", "/favorite/unlike",
		"/video/home" })
public class homeServlet extends HttpServlet {

	public static final int VIDEO_MAX_PAGE_SIZE = 4;
	DAO_Video daov = new DAO_Video();
	DAO_Favorite daof = new DAO_Favorite();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		HttpSession session = req.getSession();
		if (uri.contains("/video/detail")) {
			detail(req, resp);
			req.setAttribute("view", "/views/pages/detailVideo.jsp");
		} else if (uri.contains("/video/home")) {
			Allvideo(req, resp);
			req.setAttribute("view", "/views/pages/allVideo.jsp");
		} else if (uri.contains("/like")) {
			dolike(session, req, resp);
			req.setAttribute("view", "/views/pages/home.jsp");
		} else if (uri.contains("/unlike")) {
			unlike(session, req, resp);
			favoriteVideo(session, req, resp);
			req.setAttribute("view", "/views/pages/home.jsp");
		} else if (uri.contains("/favorite")) {
			favoriteVideo(session, req, resp);
			req.setAttribute("view", "/views/pages/favorite.jsp");
		} else if (uri.contains("/share")) {
			gotoShare(req, resp);
			req.setAttribute("view", "/views/pages/shareVideo.jsp");
		} else {
			findAll(session, req, resp);
			req.setAttribute("view", "/views/pages/home.jsp");
		}

		req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String uri = req.getRequestURI();
	HttpSession session = req.getSession();
	if(uri.contains("share")) {
	doShare(session, req, resp);
		req.setAttribute("view", "/views/pages/home.jsp");
	}
	req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
}
	
	
	
	
	
	
	
	
	
	
	
	private void findAll(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			Users user = (Users) session.getAttribute(SessionLG.CURRENT_USER);
			List<Video> list = daov.findIndex();
			List<Video> listf = new ArrayList<>();

			if (user != null) {
				// Nếu người dùng đã đăng nhập, thì lấy danh sách video yêu thích của người dùng
				listf = daof.findListFavoritebyUser(user.getId());
			}
			req.setAttribute("videoList", list);
			if (user != null) {
				// Chỉ gửi danh sách yêu thích nếu người dùng đã đăng nhập
				System.out.println(listf.size());
				req.setAttribute("ListT", listf);
			}

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("bug", "bug rooif");
			System.out.println("Bug fill all");
		}
	}

	private void Allvideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<Video> list = daov.findAll();
			req.setAttribute("videoList", list);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("bug", "bug rooif");
			System.out.println("bugfillVideo");
		}
	}

	private void favoriteVideo(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {

			Users user = (Users) session.getAttribute(SessionLG.CURRENT_USER);
			List<Video> list = daof.findListFavoritebyUser(user.getId());
			System.out.println(list.size() + "size");
			System.out.println(user.getId() + "teen");
			if (list.size() != 0) {
				req.setAttribute("videoList", list);
				req.setAttribute("mes", "Yêu thích");
			} else {
				req.setAttribute("mes", "Không có video yêu thích");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			Video video = daov.findBYID(req.getParameter("id"));
			req.setAttribute("Video", video);
			findRamdom4(req, resp);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	private void findRamdom4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			List<Video> list = daov.fillRamdom4();
			req.setAttribute("video", list);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("bug", "bug rooif");
			System.out.println("Bugfillramdom");
		}
	}

	private void dolike(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			DAO_Video daovd = new DAO_Video();
			DAO_Favorite dao = new DAO_Favorite();
			Favorite F = new Favorite();
			Users user = (Users) session.getAttribute(SessionLG.CURRENT_USER);
			Video video = daovd.findBYID(req.getParameter("id"));
			Date date = new Date();
			F.setUserFavorite(user);
			F.setVideoFavorite(video);
			F.setLikeDate(date);
			dao.create(F);
//			session.setAttribute(SessionLG.TRANG_THAI, "like");
			findAll(session, req, resp);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void unlike(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			DAO_Video daovd = new DAO_Video();
			DAO_Favorite dao = new DAO_Favorite();
			Users user = (Users) session.getAttribute(SessionLG.CURRENT_USER);
			Video video = daovd.findBYID(req.getParameter("id"));
			dao.unlike(user.getId(), video.getId());

		} catch (Exception e) {

		}
	}

	private void doShare(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			DAO_Video daovd = new DAO_Video();
			DAO_Email daoEmail = new DAO_Email();
			Users user = (Users) session.getAttribute(SessionLG.CURRENT_USER);
			Video video = daovd.findBYID(req.getParameter("id"));
			Share s = new Share();
			Date date = new Date();
			s.setUserShare(user);
			s.setVideoShare(video);
			s.setEmails(req.getParameter("friend_email"));
			s.setShareDate(date);
			daovd.share(s);
			daoEmail.shareVideo(getServletContext(), req.getParameter("friend_email"), req.getParameter("id"));
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void gotoShare(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			DAO_Video daovd = new DAO_Video();
			Video video = daovd.findBYID(req.getParameter("id"));
			req.setAttribute("Video", video);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}