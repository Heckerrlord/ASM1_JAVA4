package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO_Users;
import dao.DAO_Video;
import models.Users;
import models.Video;

@WebServlet({ "/admin/home", "/admin/user", "/admin/video" })
public class adminServlet extends HttpServlet {
	private List<Video> videoList;
	private List<Users> userList;
	DAO_Video daoVD = new DAO_Video();
	DAO_Users daoUs = new DAO_Users();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String pageParam = req.getParameter("page");
		int currentPage = (pageParam != null && !pageParam.isEmpty()) ? Integer.parseInt(pageParam) : 1;
		int recordsPerPage = 3;
		String a = String.valueOf(java.time.LocalDate.now());
		req.setAttribute("a", a);
		if (uri.contains("/admin/home")) {
			fillIndex(req);
			req.getRequestDispatcher("/views/admin/adminIndex.jsp").forward(req, resp);
		}
		if (uri.contains("/admin/video")) {
			fillPagedVideo(req, currentPage, recordsPerPage);
			req.getRequestDispatcher("/views/admin/adminVideo.jsp").forward(req, resp);
		}
		if (uri.contains("/admin/user")) {
			fillAllUser(req);
			req.getRequestDispatcher("/views/admin/adminUser.jsp").forward(req, resp);
		}

	}

	private void fillIndex(HttpServletRequest req) {
		try {
			long usersCount = daoUs.countUsers();
			long viewsCount = daoVD.getTotalViewCount();
			long videoCount = daoVD.countVideo();
			req.setAttribute("viewsCount", viewsCount);
			req.setAttribute("videoCount", videoCount);
			req.setAttribute("usersCount", usersCount);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Lỗi fill index");
		}
	}

	private void fillPagedVideo(HttpServletRequest req, int currentPage, int recordsPerPage) {
		try {
			// Tính tổng số lượng bản ghi (video)
			int totalRecords = (int) daoVD.countTotalVideos();

			// Tính tổng số trang dựa trên tổng số lượng bản ghi và số bản ghi trên mỗi
			// trang
			int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);

			// Xác định vị trí bắt đầu và kết thúc của dữ liệu trên trang hiện tại
			int startRecord = (currentPage - 1) * recordsPerPage;
			int endRecord = Math.min(startRecord + recordsPerPage, totalRecords);

			// Lấy danh sách video cho trang hiện tại từ vị trí bắt đầu đến vị trí kết thúc
			videoList = daoVD.findVideosByPage(startRecord, endRecord);

			// Đặt danh sách video và các thông tin phân trang vào request
			req.setAttribute("videoList", videoList);
			req.setAttribute("currentPage", currentPage);
			req.setAttribute("totalPages", totalPages);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Lỗi fill video");
		}
	}

	private void fillAllUser(HttpServletRequest req) {
		try {
			userList = daoUs.findAll();
			req.setAttribute("userList", userList);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Lỗi fill user");
		}
		req.setAttribute("userList", userList);
	}

	private static final int RECORDS_PER_PAGE = 10; // Số bản ghi trên mỗi trang

	protected void phantrang(HttpServletRequest req) throws ServletException, IOException {
		// Xác định số trang hiện tại từ tham số trên URL (nếu có)
		int currentPage = 1;
		String pageParam = req.getParameter("page");
		if (pageParam != null && !pageParam.isEmpty()) {
			currentPage = Integer.parseInt(pageParam);
		}
		// Lấy dữ liệu nguồn (từ cơ sở dữ liệu hoặc bất kỳ nguồn nào khác)

		// Tính tổng số trang dựa trên tổng số bản ghi và số bản ghi trên mỗi trang
		int totalRecords = 100; // Số lượng bản ghi tổng cộng (ví dụ: tổng số users)
		int totalPages = (int) Math.ceil((double) totalRecords / RECORDS_PER_PAGE);

		// Tính vị trí bắt đầu và vị trí kết thúc của dữ liệu trên trang hiện tại
		int startRecord = (currentPage - 1) * RECORDS_PER_PAGE;
		int endRecord = Math.min(startRecord + RECORDS_PER_PAGE, totalRecords);

		// Tạo danh sách các trang con để hiển thị các nút ấn
		List<Integer> pageNumbers = new ArrayList<>();
		int startPage = Math.max(1, currentPage - 5);
		int endPage = Math.min(totalPages, currentPage + 5);
		for (int i = startPage; i <= endPage; i++) {
			pageNumbers.add(i);
		}
		req.setAttribute("pageNumbers", pageNumbers);

		// Đặt dữ liệu vào request để hiển thị trên trang JSP
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("totalPages", totalPages);
		// Đặt dữ liệu của trang hiện tại vào đây (ví dụ: danh sách các users)

	}

}
