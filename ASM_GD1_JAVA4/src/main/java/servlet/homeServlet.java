package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import constant.SessionLG;

import dao.DAO_Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import models.Favorite;
import models.Users;
import models.Video;

@WebServlet({ "/index","/share","/find", "/favorite/home", "/video/detail", "/favorite/like", "/favorite/hate","/video/home" })
public class homeServlet extends HttpServlet {
	
	public static final int VIDEO_MAX_PAGE_SIZE = 4;
	
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
		} else {
			findAll(req, resp);
			req.setAttribute("view", "/views/pages/home.jsp");
		}

		req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			DAO_Video dao = new DAO_Video();
			List<Video> list = dao.findIndex();
			System.out.println(list.size());
			req.setAttribute("videoList", list);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("bug", "bug rooif");
			System.out.println("casasda");
		}
	}
	private void Allvideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			DAO_Video dao = new DAO_Video();
			List<Video> list = dao.findAll();
			req.setAttribute("videoList", list);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("bug", "bug rooif");
			System.out.println("casasda");
		}
	}
	private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			DAO_Video dao = new DAO_Video();
			Video video = dao.findBYID(req.getParameter("id"));
			req.setAttribute("Video", video);
			
			findRamdom4(req, resp);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	private void findRamdom4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			DAO_Video dao = new DAO_Video();
			List<Video> list = dao.fillRamdom4();
			req.setAttribute("video", list);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("bug", "bug rooif");
			System.out.println("casasda");
		}
	}
	
//	private void doShare(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		try {
//			DAO_Video daovd = new DAO_Video();
//			TK user = (TK) session.getAttribute(SessionLG.CURRENT_USER);
//			Video video = daovd.findBYID(req.getParameter("id"));
//			SHARE s = new SHARE();
//			Date date = new Date();
//			s.setUserShare(user);
//			s.setVideoShare(video);
//			s.setEmails(req.getParameter("friend_email"));
//			s.setShareDate(date);
//			daovd.share(s);
////
//			findAll(req, resp);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	
	
	
	
}