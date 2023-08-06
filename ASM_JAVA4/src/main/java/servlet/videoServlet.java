package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.DAO_Users;
import dao.DAO_Video;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import models.Users;
import models.Video;

@javax.servlet.annotation.MultipartConfig
@WebServlet({ "/admin/video/create", "/admin/video/update", "/admin/video/delete", "/admin/video/edit" })
public class videoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String pageParam = req.getParameter("page");
		int currentPage = (pageParam != null && !pageParam.isEmpty()) ? Integer.parseInt(pageParam) : 1;
		int recordsPerPage = 3;

		if (uri.contains("/video/delete")) {
			delete(req, resp);
		} else if (uri.contains("/admin/video/edit")) {
			detail(req, resp);
		}
		fillPagedVideo(req, currentPage, recordsPerPage);

		req.getRequestDispatcher("/views/admin/adminVideo.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String pageParam = req.getParameter("page");
		int currentPage = (pageParam != null && !pageParam.isEmpty()) ? Integer.parseInt(pageParam) : 1;
		int recordsPerPage = 3;
		if (uri.contains("/video/create")) {
			System.out.println("creat");
			create(req, resp);
		} else if (uri.contains("/video/update")) {
			System.out.println("update");
			update(req, resp);
		}
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		fillPagedVideo(req, currentPage, recordsPerPage);
		req.getRequestDispatcher("/views/admin/adminVideo.jsp").forward(req, resp);
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			DAO_Video dao = new DAO_Video();
			List<Video> list = dao.findAll();
			req.setAttribute("countVideo", list.size());
			req.setAttribute("video", list);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("bug", "bug rooif");
			System.out.println("casasda");
		}
	}

	private void fillPagedVideo(HttpServletRequest req, int currentPage, int recordsPerPage) {
		try {
			DAO_Video dao = new DAO_Video();
			// Tính tổng số lượng bản ghi (video)
			int totalRecords = (int) dao.countTotalVideos();

			// Tính tổng số trang dựa trên tổng số lượng bản ghi và số bản ghi trên mỗi
			// trang
			int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);

			// Xác định vị trí bắt đầu và kết thúc của dữ liệu trên trang hiện tại
			int startRecord = (currentPage - 1) * recordsPerPage;
			int endRecord = Math.min(startRecord + recordsPerPage, totalRecords);

			// Lấy danh sách video cho trang hiện tại từ vị trí bắt đầu đến vị trí kết thúc
			List<Video> videoList = dao.findVideosByPage(startRecord, endRecord);

			// Đặt danh sách video và các thông tin phân trang vào request
			req.setAttribute("videoList", videoList);
			req.setAttribute("currentPage", currentPage);
			req.setAttribute("totalPages", totalPages);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Lỗi fill video");
		}
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			DAO_Video dao = new DAO_Video();
			dao.delete(req.getParameter("id"));
			req.setAttribute("mes", "Xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Xóa thành công!");
		}
	}

	private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			DAO_Video dao = new DAO_Video();
			Video video = dao.findBYID(req.getParameter("id"));
			req.setAttribute("disabled", "disabled");
			req.setAttribute("Video", video);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			Video vd = new Video();
			String anh = req.getParameter("anhten");

			if (anh == null) {
				Part photo = req.getPart("poster_file"); // file hình
				String photoName = photo.getSubmittedFileName();
				vd.setPoster(photoName);
			} else {
				vd.setPoster(anh);
			}

			BeanUtils.populate(vd, req.getParameterMap());
			DAO_Video dao = new DAO_Video();
			req.setAttribute("mes", "Thêm thành công");
			dao.create(vd);
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Video vd = new Video();
			String anh = req.getParameter("anhten");
			System.out.println(anh + "tenanh");
			if (anh.isEmpty()) {
				Part photo = req.getPart("poster_file"); // file hình
				String photoName = photo.getSubmittedFileName();
				vd.setPoster(photoName);
			} else {
				vd.setPoster(anh);
			}
			BeanUtils.populate(vd, req.getParameterMap());
			DAO_Video dao = new DAO_Video();
			req.setAttribute("mes", "Cập nhật thành công");
			System.out.println(vd.getTitle()+"Tên video");
			dao.update(vd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
